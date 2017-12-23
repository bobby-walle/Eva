/*
 * Create by BobEve on 17-12-18 下午9:41
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午9:23
 */

package bob.eve.walle.ui.fragment;

import android.os.Bundle;
import android.view.View;
import bob.eve.comm.lib.layout.tab.NavigationTabStrip;
import bob.eve.comm.lib.layout.viewpager.ParallaxViewPager;
import bob.eve.mvp.base.AbsEveEasyFragment;
import bob.eve.walle.R;
import butterknife.BindView;

/**
 * Created by Bob on 17/12/18.
 */

public class AboutFragment extends AbsEveEasyFragment {
	@BindView(R.id.parallaxViewPager)
	ParallaxViewPager mParallaxViewPager;
	@BindView(R.id.navigationTabStrip)
	NavigationTabStrip mNavigationTabStrip;

	public static AboutFragment newInstance() {
		Bundle args = new Bundle();
		AboutFragment fragment = new AboutFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int layoutResID() {
		return R.layout.fragment_it_circle_tab_layout;
	}

	@Override
	public void attachView() {

	}

	@Override
	public void initView(View view) {

	}

	@Override
	public void initLazyView(View view) {
	}
}
