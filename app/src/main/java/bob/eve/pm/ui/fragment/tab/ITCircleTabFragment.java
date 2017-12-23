/*
 * Create by BobEve on 17-12-18 下午9:19
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午9:19
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
import bob.eve.pm.ui.fragment.ITCircleFromGankCategoryFragment;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ITCircleTabFragment extends AbsEveEasyFragment {
	public static final String GANK_CATEGORY_TYPE_KEY = "type_key";
	public static final int GANK_CATEGORY_Android_TYPE = 1;
	public static final int GANK_CATEGORY_IOS_TYPE = 2;
	public static final int GANK_CATEGORY_MORE_TYPE = 3;
	public static final int GANK_CATEGORY_WEB_TYPE = 4;
	public static final String GANK_CATEGORY_Android = "Android";
	public static final String GANK_CATEGORY_IOS = "iOS";
	public static final String GANK_CATEGORY_MORE = "拓展资源";
	public static final String GANK_CATEGORY_WEB = "前端";

	@BindView(R.id.parallaxViewPager)
	ParallaxViewPager mParallaxViewPager;
	@BindView(R.id.navigationTabStrip)
	NavigationTabStrip mNavigationTabStrip;

	private EveEasyFragmentAdapter adapter;
	private List<AbsEveBaseFragment> fragments = new ArrayList<>();

	public static ITCircleTabFragment newInstance() {
		Bundle args = new Bundle();
		ITCircleTabFragment fragment = new ITCircleTabFragment();
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
		fragments.add(ITCircleFromGankCategoryFragment.newInstance(GANK_CATEGORY_Android));
		fragments.add(ITCircleFromGankCategoryFragment.newInstance(GANK_CATEGORY_IOS));
		fragments.add(ITCircleFromGankCategoryFragment.newInstance(GANK_CATEGORY_WEB));
		fragments.add(ITCircleFromGankCategoryFragment.newInstance(GANK_CATEGORY_MORE));
		adapter = new EveEasyFragmentAdapter(getChildFragmentManager(), fragments);
	}

	@Override
	public void initLazyView(View view) {
		mParallaxViewPager.setAdapter(adapter);
		mNavigationTabStrip.setViewPager(mParallaxViewPager);
		mNavigationTabStrip.setmStripPadding(10);
	}
}
