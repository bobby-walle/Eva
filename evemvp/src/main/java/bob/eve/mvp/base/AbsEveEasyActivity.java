/*
 * Create by BobEve on 17-12-20 下午6:25
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午6:25
 */

package bob.eve.mvp.base;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import bob.eve.comm.lib.util.Preconditions;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jaeger.library.StatusBarUtil;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Bob on 17/12/11.
 */

public abstract class AbsEveEasyActivity<C> extends SupportActivity implements IActivity<C> {

	private Unbinder mUnbinder;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int layoutResID = layoutResID();
		Preconditions.checkArgument(layoutResID > 0, "Activity layoutResID must be set");
		setContentView(layoutResID);
		mUnbinder = ButterKnife.bind(this);

		initView();
	}

	@Override
	protected void onDestroy() {
		if (mUnbinder != null) {
			mUnbinder.unbind();
			mUnbinder = null;
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

	public void useNightMode(boolean isNight) {
		if (isNight) {
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
		} else {
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
		}
		recreate();
	}

	/**
	 * 查找View
	 *
	 * @param id
	 * 		控件的id
	 * @param <VT>
	 * 		View类型
	 */
	protected <VT extends View> VT getViewById(@IdRes int id) {
		return (VT) findViewById(id);
	}
}
