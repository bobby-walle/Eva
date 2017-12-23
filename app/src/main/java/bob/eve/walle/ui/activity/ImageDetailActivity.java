/*
 * Create by BobEve on 17-12-22 下午2:14
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-22 下午2:14
 */

package bob.eve.walle.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bob.eve.comm.lib.util.BitmapUtils;
import bob.eve.comm.lib.util.FileUtils;
import bob.eve.comm.lib.util.SystemShareUtils;
import bob.eve.walle.R;
import bob.eve.walle.app.Constants;
import bob.eve.walle.ui.widget.imageloader.GlideApp;
import bob.eve.walle.util.SnackbarUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.github.chrisbanes.photoview.OnViewTapListener;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Bob on 17/12/22.
 * TODO 整合BaseActivity
 */

public class ImageDetailActivity extends SupportActivity implements View.OnClickListener {
	public static final String INTENT_IT_CICLE_DETAIL_TITLE = "it_cicle_detail_title";
	public static final String INTENT_IT_CICLE_DETAIL_URL = "it_cicle_detail_url";
	public static final String INTENT_IT_CICLE_DETAIL_IMG_URL = "it_cicle_detail_img_url";
	public static final String INTENT_IT_CICLE_DETAIL_ID = "it_cicle_detail_id";
	public static final String INTENT_IT_CICLE_DETAIL_CATEGORY = "it_cicle_detail_category";

	@BindView(R.id.appbar_layout)
	protected AppBarLayout mAppBar;
	@BindView(R.id.toolbar)
	protected Toolbar toolBar;
	@BindView(R.id.detail_image)
	ImageView girlView;

	private Unbinder mUnbinder;
	private PhotoViewAttacher mPhotoViewAttacher;
	private String imgUrl;
	private String title;
	private String id;
	private String category;
	protected boolean mIsHidden = false;
	private boolean isLiked;
	private MenuItem menuItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_detail_layout);
		mUnbinder = ButterKnife.bind(this);

		//		getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_ALL);

		initToolbar();
		initData();
	}

	private void initToolbar() {
		setAppBarAlpha(0.65f);
		toolBar.setOnClickListener(this);
		setSupportActionBar(toolBar);

		if (canBack()) {
			ActionBar actionBar = getSupportActionBar();
			if (actionBar != null) {
				getSupportActionBar().setDisplayHomeAsUpEnabled(true);
				getSupportActionBar().setDisplayShowHomeEnabled(true);
				toolBar.setNavigationOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						onBackPressedSupport();
					}
				});
			}
		}
	}

	private void initData() {
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			title = bundle.getString(INTENT_IT_CICLE_DETAIL_TITLE);
			imgUrl = bundle.getString(INTENT_IT_CICLE_DETAIL_IMG_URL);
			id = bundle.getString(INTENT_IT_CICLE_DETAIL_ID);
			category = bundle.getString(INTENT_IT_CICLE_DETAIL_CATEGORY);
		}

		toolBar.setTitle(title);
		if (imgUrl != null) {
			showGirl();
		}
	}

	private void showGirl() {
		GlideApp.with(this)
						.asBitmap()
						.load(imgUrl)
						.diskCacheStrategy(DiskCacheStrategy.ALL)
						.into(new SimpleTarget<Bitmap>() {
							@Override
							public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
								girlView.setImageBitmap(resource);
								mPhotoViewAttacher = new PhotoViewAttacher(girlView);
								setupPhotoAttacher();
							}
						});
	}

	private void setupPhotoAttacher() {
		mPhotoViewAttacher.setOnViewTapListener(new OnViewTapListener() {
			@Override
			public void onViewTap(View view, float x, float y) {
				hideOrShowAppbar();
			}
		});
		mPhotoViewAttacher.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				AlertDialog.Builder builder = new AlertDialog.Builder(ImageDetailActivity.this);
				builder.setIcon(R.drawable.ic_lovely_gaze)
							 .setMessage("保存妹子么？")
							 .setNegativeButton("点错了", new DialogInterface.OnClickListener() {
								 @Override
								 public void onClick(DialogInterface dialogInterface, int i) {
									 dialogInterface.dismiss();
								 }
							 })
							 .setPositiveButton("收了", new DialogInterface.OnClickListener() {
								 @Override
								 public void onClick(DialogInterface dialogInterface, int i) {
									 dialogInterface.dismiss();
									 toSaveImage();
								 }
							 })
							 .show();
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.girl_menu, menu);
		menuItem = menu.findItem(R.id.action_fav);
		/*
		setLikeState(mRealmHelper.queryLikeId(id));
		*/
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
			case R.id.action_fav:
				if (isLiked) {
					item.setIcon(R.drawable.ic_toolbar_unfav);

					/*
					mRealmHelper.deleteLikeBean(this.id);
					*/
					isLiked = false;
				} else {
					item.setIcon(R.drawable.ic_toolbar_fav);

					/*RealmLikeBean bean = new RealmLikeBean();
					bean.setId(this.id);
					bean.setImage(imgUrl);
					bean.setUrl(imgUrl);
					bean.setTitle(title);
					bean.setType(type);
					bean.setTime(System.currentTimeMillis());
					mRealmHelper.insertLikeBean(bean);
					*/

					isLiked = true;
				}
				break;
			case R.id.action_save:
				toSaveImage();
				break;
			case R.id.action_share:
				SystemShareUtils.shareText(getApplicationContext(), imgUrl, "送你一只妹纸，要不要");
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void toSaveImage() {
		Observable<Uri> observable = saveImage(getApplicationContext(), imgUrl, title);
		observable.observeOn(AndroidSchedulers.mainThread())
							.subscribe(new DefaultObserver<Uri>() {
								@Override
								public void onNext(Uri uri) {
									if (uri == null) {
										SnackbarUtil.show(girlView, "保存失败，再试试～");
									} else {
										String path = uri.getPath();
										SnackbarUtil.show(girlView, "保存成功～");
									}
								}

								@Override
								public void onError(Throwable e) {
									SnackbarUtil.show(girlView, "保存失败，再试试～");
								}

								@Override
								public void onComplete() {

								}
							});
	}

	/**
	 * 限制SwipeBack的条件,默认栈内Fragment数 <= 1时 , 优先滑动退出Activity , 而不是Fragment
	 *
	 * @return true: Activity优先滑动退出;  false: Fragment优先滑动退出
	 */
	//	@Override
	//	public boolean swipeBackPriority() {
	//		return super.swipeBackPriority();
	//	}
	protected boolean canBack() {
		return true;
	}

	@Override
	public void onBackPressedSupport() {
		if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
			pop();
		} else {
			supportFinishAfterTransition();
		}
	}

	protected void setAppBarAlpha(float alpha) {
		mAppBar.setAlpha(alpha);
	}

	protected void hideOrShowAppbar() {
		mAppBar.animate()
					 .translationY(mIsHidden ? 0 : -mAppBar.getHeight())
					 .setInterpolator(new DecelerateInterpolator(2))
					 .start();
		mIsHidden = !mIsHidden;
	}

	protected void onToolbarClick() {
	}

	@Override
	protected void onDestroy() {
		if (mUnbinder != null) {
			mUnbinder.unbind();
			mUnbinder = null;
		}
		super.onDestroy();
	}

	private Observable<Uri> saveImage(final Context context, final String url, final String title) {
		return Observable.just(url)
										 .flatMap(new Function<String, ObservableSource<Bitmap>>() {
											 @Override
											 public ObservableSource<Bitmap> apply(String s) throws Exception {
												 return Observable.just(GlideApp.with(context)
																												.asBitmap()
																												.load(s)
																												.submit(Target.SIZE_ORIGINAL,
																																Target.SIZE_ORIGINAL)
																												.get());
											 }
										 })
										 .flatMap(new Function<Bitmap, ObservableSource<Uri>>() {
											 @Override
											 public ObservableSource<Uri> apply(Bitmap bitmap) throws Exception {
												 String fileName =
														 url.substring(url.lastIndexOf("/"), url.lastIndexOf(".")) + ".png";
												 File fileDir = new File(Constants.GIRLS_SDCARD_PATH);
												 FileUtils.makeDirs(fileDir.getAbsolutePath());

												 File girlFile = new File(fileDir, fileName);
												 FileUtils.makeDirs(girlFile.getAbsolutePath());

												 Uri uri = Uri.fromFile(girlFile);

												 if (girlFile.exists()) {
													 return Observable.just(uri);
												 }
												 BitmapUtils.saveBitmap(bitmap, girlFile);

												 // 更新相册
												 context.sendBroadcast(
														 new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));

												 return Observable.just(uri);
											 }
										 })
										 .subscribeOn(Schedulers.io());
	}

	@Override
	public void onClick(View view) {
		onToolbarClick();
	}
}
