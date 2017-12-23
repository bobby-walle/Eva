/*
 * Create by BobEve on 17-12-22 上午12:18
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 下午5:59
 */

package bob.eve.pm.ui.adapter;

import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import bob.eve.pm.R;
import bob.eve.pm.app.PmWeatherApplication;
import bob.eve.pm.mvp.model.bean.gank.GankItem;
import bob.eve.pm.ui.widget.imageloader.GlideApp;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Bob on 17/12/19.
 */

public class HiGirlGankAdapter extends BaseQuickAdapter<GankItem, BaseViewHolder> {
	private Fragment fragment;

	public HiGirlGankAdapter(Fragment fragment, @LayoutRes int layoutResId) {
		super(layoutResId);
		this.fragment = fragment;
	}

	@Override
	public int getItemViewType(int position) {
		if (getData().size() <= 0) {
			return 0;
		}

		return Math.round((float) PmWeatherApplication.SCREEN_WIDTH / (float) getData().get(position)
																																									 .getHeight() *
											10f);
	}

	@Override
	public void onBindViewHolder(final BaseViewHolder holder, final int position) {
		//存在记录的高度时先Layout再异步加载图片
		if (getData().size() > 0) {
			if (getData().get(position)
									 .getHeight() > 0) {
				ViewGroup.LayoutParams params = holder.getView(R.id.ig_image)
																							.getLayoutParams();
				params.height = getData().get(position)
																 .getHeight();
				params.width = PmWeatherApplication.SCREEN_WIDTH / 2;
				holder.getView(R.id.ig_image)
							.setLayoutParams(params);
			}
		}
		super.onBindViewHolder(holder, position);
	}

	@Override
	protected void convert(final BaseViewHolder helper, final GankItem item) {
		GlideApp.with(mContext)
						.asBitmap()
						.load(item.getUrl())
						.diskCacheStrategy(DiskCacheStrategy.ALL)
						.into(new SimpleTarget<Bitmap>(PmWeatherApplication.SCREEN_WIDTH / 2,
																					 PmWeatherApplication.SCREEN_WIDTH / 2) {
							@Override
							public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
								if (helper.getAdapterPosition() != RecyclerView.NO_POSITION) {
									if (item.getHeight() <= 0) {
										final ImageView image = helper.getView(R.id.ig_image);
										int imageHeight =
												(PmWeatherApplication.SCREEN_WIDTH / 2) * resource.getHeight() /
												resource.getWidth();
										item.setHeight(imageHeight);

										ViewGroup.LayoutParams params = image.getLayoutParams();
										params.height = imageHeight;
										image.setLayoutParams(params);
									}

									((ImageView) helper.getView(R.id.ig_image)).setImageBitmap(resource);
								}
							}
						});
	}
}