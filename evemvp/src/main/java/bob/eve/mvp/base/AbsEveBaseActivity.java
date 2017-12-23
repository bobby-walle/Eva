/*
 * Create by BobEve on 17-12-11 下午7:53
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午7:53
 */

package bob.eve.mvp.base;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import bob.eve.comm.lib.util.Preconditions;
import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.view.IView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jaeger.library.StatusBarUtil;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/11.
 */

public abstract class AbsEveBaseActivity<P extends IPresenter, C> extends AbsEveEasyActivity<C>
		implements IView {

	@Inject
	protected P mPresenter;
	private Unbinder mUnbinder;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int layoutResID = layoutResID();
		Preconditions.checkArgument(layoutResID > 0, "Activity layoutResID must be set");
		setContentView(layoutResID);
		mUnbinder = ButterKnife.bind(this);

		attachView();
		initView();
	}

	@Override
	protected void onResume() {
		if (mPresenter != null) {
			mPresenter.resume();
		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		if (mPresenter != null) {
			mPresenter.pause();
		}
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		if (mUnbinder != null) {
			mUnbinder.unbind();
			mUnbinder = null;
		}
		if (mPresenter != null) {
			mPresenter.destroy();
			mPresenter = null;
		}
		super.onDestroy();
	}

	protected void setToolBar(Toolbar toolbar, String title) {
		toolbar.setTitle(title);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressedSupport();
			}
		});
	}

	/**
	 * 设置状态栏颜色
	 */
	protected void setStatusBarColor(@ColorInt int color) {
		setStatusBarColor(color, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
	}

	/**
	 * 设置状态栏颜色
	 *
	 * @param statusBarAlpha
	 * 		透明度
	 */
	public void setStatusBarColor(@ColorInt int color,
																@IntRange(from = 0, to = 255) int statusBarAlpha) {
		StatusBarUtil.setColorForSwipeBack(this, color, statusBarAlpha);
	}

	protected abstract void attachView();
}
