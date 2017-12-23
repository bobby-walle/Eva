/*
 * Create by BobEve on 17-12-18 下午9:21
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午9:21
 */

package bob.eve.walle.ui.fragment.tab;

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

public class ReadTabFragment extends AbsEveEasyFragment {
	@BindView(R.id.parallaxViewPager)
	ParallaxViewPager mParallaxViewPager;
	@BindView(R.id.navigationTabStrip)
	NavigationTabStrip mNavigationTabStrip;

	public static ReadTabFragment newInstance() {
		Bundle args = new Bundle();
		ReadTabFragment fragment = new ReadTabFragment();
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
