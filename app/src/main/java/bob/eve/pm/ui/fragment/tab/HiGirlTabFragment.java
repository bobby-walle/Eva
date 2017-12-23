/*
 * Create by BobEve on 17-12-18 下午9:21
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午9:21
 */

package bob.eve.pm.ui.fragment.tab;

import android.os.Bundle;
import android.view.View;
import bob.eve.comm.lib.layout.tab.NavigationTabStrip;
import bob.eve.comm.lib.layout.viewpager.ParallaxViewPager;
import bob.eve.mvp.base.AbsEveBaseFragment;
import bob.eve.mvp.base.AbsEveEasyFragment;
import bob.eve.pm.R;
import bob.eve.pm.ui.adapter.EveEasyFragmentAdapter;
import bob.eve.pm.ui.fragment.HiGirlFromGankFragment;
import bob.eve.pm.ui.fragment.HiGirlFromTianFragment;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class HiGirlTabFragment extends AbsEveEasyFragment {
	public static final String GANK_CATEGORY_GIRL = "福利";

	@BindView(R.id.parallaxViewPager)
	ParallaxViewPager mParallaxViewPager;
	@BindView(R.id.navigationTabStrip)
	NavigationTabStrip mNavigationTabStrip;
	private EveEasyFragmentAdapter adapter;
	private List<AbsEveBaseFragment> fragments = new ArrayList<>();

	public static HiGirlTabFragment newInstance() {
		Bundle args = new Bundle();
		HiGirlTabFragment fragment = new HiGirlTabFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int layoutResID() {
		return R.layout.fragment_higirl_tab_layout;
	}

	@Override
	public void attachView() {

	}

	@Override
	public void initView(View view) {

	}

	@Override
	public void initLazyView(View view) {
		fragments.add(HiGirlFromGankFragment.newInstance(GANK_CATEGORY_GIRL));
		fragments.add(HiGirlFromTianFragment.newInstance(GANK_CATEGORY_GIRL));
		
		adapter = new EveEasyFragmentAdapter(getChildFragmentManager(), fragments);
		mParallaxViewPager.setAdapter(adapter);
		mNavigationTabStrip.setViewPager(mParallaxViewPager);
		mNavigationTabStrip.setmStripPadding(10);
	}
}
