/*
 * Create by BobEve on 17-12-20 下午6:23
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午6:23
 */

package bob.eve.walle.ui.activity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import bob.eve.comm.lib.util.NetworkUtils;
import bob.eve.comm.lib.util.SystemShareUtils;
import bob.eve.comm.lib.util.SystemUtils;
import bob.eve.mvp.base.AbsEveEasyActivity;
import bob.eve.mvp.di.component.AppComponent;
import bob.eve.walle.R;
import bob.eve.walle.config.ImplPreferencesHelper;
import bob.eve.walle.di.component.DaggerActivityComponent;
import butterknife.BindView;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/20.
 */

public class EveWebActivity extends AbsEveEasyActivity {
	// ITCircleFromGankCategoryFragment 进入web也数据key
	public static final String INTENT_IT_CICLE_DETAIL_TITLE = "it_cicle_detail_title";
	public static final String INTENT_IT_CICLE_DETAIL_URL = "it_cicle_detail_url";
	public static final String INTENT_IT_CICLE_DETAIL_IMG_URL = "it_cicle_detail_img_url";
	public static final String INTENT_IT_CICLE_DETAIL_ID = "it_cicle_detail_id";
	public static final String INTENT_IT_CICLE_DETAIL_CATEGORY = "it_cicle_detail_category";

	@Inject
	ImplPreferencesHelper preferencesHelper;
	@BindView(R.id.toolbar)
	Toolbar toolBar;
	@BindView(R.id.tencent_wv)
	WebView tencentWebView;
	@BindView(R.id.progress)
	ProgressBar progress;
	private String title = "N/A";
	private String url;
	private String imgUrl;
	private String id;
	private String category;
	private boolean isLiked;
	private MenuItem menuItem;

	@Override
	public int layoutResID() {
		return R.layout.activity_tencent_web_layout;
	}

	@Override
	public void initView() {
		getWindow().setFormat(PixelFormat.TRANSLUCENT);

		initData();
		initWebView();
	}

	private void initWebView() {
		WebSettings settings = tencentWebView.getSettings();
		if (preferencesHelper.getNoImageState()) {
			settings.setBlockNetworkImage(true);
		}
		if (preferencesHelper.getAutoCacheState()) {
			settings.setAppCacheEnabled(true);
			settings.setDomStorageEnabled(true);
			settings.setDatabaseEnabled(true);
			if (NetworkUtils.isConnected(getApplicationContext())) {
				settings.setCacheMode(WebSettings.LOAD_DEFAULT);
			} else {
				settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
			}
		}
		settings.setJavaScriptEnabled(true);
		settings.setLoadWithOverviewMode(true);
		settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		settings.setSupportZoom(true);

		setWebClient();
		tencentWebView.loadUrl(url);
	}

	private void setWebClient() {
		tencentWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});

		tencentWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				if (progress != null) {
					if (newProgress > 95) {
						if (progress.getVisibility() != View.GONE) {
							progress.animate()
											.alpha(0)
											.setDuration(500)
											.start();
							progress.setVisibility(View.GONE);
						}
					} else {
						if (progress.getVisibility() != View.VISIBLE) {
							progress.setVisibility(View.VISIBLE);
						}
						progress.setProgress(newProgress);
					}
				}
			}

			@Override
			public void onReceivedTitle(WebView view, String title) {
				super.onReceivedTitle(view, title);
				setTitle(title);
			}
		});
	}

	private void initData() {
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			title = bundle.getString(INTENT_IT_CICLE_DETAIL_TITLE);
			url = bundle.getString(INTENT_IT_CICLE_DETAIL_URL);
			imgUrl = bundle.getString(INTENT_IT_CICLE_DETAIL_IMG_URL);
			id = bundle.getString(INTENT_IT_CICLE_DETAIL_ID);
			category = bundle.getString(INTENT_IT_CICLE_DETAIL_CATEGORY);
		}

		setToolBar(toolBar, title);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && tencentWebView.canGoBack()) {
			tencentWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.web_meun, menu);
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
					bean.setUrl(url);
					bean.setTitle(title);
					bean.setType(type);
					bean.setTime(System.currentTimeMillis());
					mRealmHelper.insertLikeBean(bean);
					*/
					isLiked = true;
				}
				break;
			case R.id.action_copy:
				SystemUtils.copyToClipBoard(getApplicationContext(), url);
				return true;
			case R.id.action_share:
				SystemShareUtils.shareText(getApplicationContext(), url, "分享一篇文章");
		}
		return super.onOptionsItemSelected(item);
	}

	private void setLikeState(boolean state) {
		if (state) {
			menuItem.setIcon(R.drawable.ic_toolbar_fav);
			isLiked = true;
		} else {
			menuItem.setIcon(R.drawable.ic_toolbar_unfav);
			isLiked = false;
		}
	}

	@Override
	public void onBackPressedSupport() {
		if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
			pop();
		} else {
			supportFinishAfterTransition();
		}
	}

	@Override
	public void injectComponent(AppComponent appComponent) {
		DaggerActivityComponent.builder()
													 .appComponent(appComponent)
													 .build()
													 .inject(this);
	}

	@Override
	public Object getComponent() {
		return null;
	}
}
