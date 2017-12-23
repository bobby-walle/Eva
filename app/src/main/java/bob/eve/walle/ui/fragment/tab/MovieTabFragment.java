/*
 * Create by BobEve on 17-12-18 下午9:20
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午9:20
 */

package bob.eve.walle.ui.fragment.tab;

import android.os.Bundle;
import android.view.View;
import bob.eve.comm.lib.layout.tab.NavigationTabStrip;
import bob.eve.comm.lib.layout.viewpager.ParallaxViewPager;
import bob.eve.mvp.base.AbsEveBaseFragment;
import bob.eve.mvp.base.AbsEveEasyFragment;
import bob.eve.walle.R;
import bob.eve.walle.ui.adapter.EveEasyFragmentAdapter;
import bob.eve.walle.ui.fragment.MovieFromDoubanTop250Fragment;
import bob.eve.walle.ui.fragment.MovieFromDoubanUSBoxFragment;
import bob.eve.walle.ui.fragment.MovieFromGankFragment;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class MovieTabFragment extends AbsEveEasyFragment {
	public static final String MOVIE_TYPE_KEY = "type_key";
	public static final int DOUBAN_MOVIE_TOP250_TYPE = 1;
	public static final int DOUBAN_MOVIE_USBOX_TYPE = 2;
	public static final int GANK_MOVIE_FREETIME_TYPE = 3;
	public static final String DOUBAN_MOVIE_TOP250 = "top250";
	public static final String DOUBAN_MOVIE_USBOX = "usbox";
	public static final String GANK_MOVIE_FREETIME = "休息视频";

	@BindView(R.id.parallaxViewPager)
	ParallaxViewPager mParallaxViewPager;
	@BindView(R.id.navigationTabStrip)
	NavigationTabStrip mNavigationTabStrip;

	private EveEasyFragmentAdapter adapter;
	private List<AbsEveBaseFragment> fragments = new ArrayList<>();

	public static MovieTabFragment newInstance() {
		Bundle args = new Bundle();
		MovieTabFragment fragment = new MovieTabFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int layoutResID() {
		return R.layout.fragment_movie_tab_layout;
	}

	@Override
	public void attachView() {

	}

	@Override
	public void initView(View view) {
		fragments.add(MovieFromDoubanTop250Fragment.newInstance(DOUBAN_MOVIE_TOP250));
		fragments.add(MovieFromGankFragment.newInstance(GANK_MOVIE_FREETIME));
		fragments.add(MovieFromDoubanUSBoxFragment.newInstance(DOUBAN_MOVIE_USBOX));

		adapter = new EveEasyFragmentAdapter(getChildFragmentManager(), fragments);
	}

	@Override
	public void initLazyView(View view) {
		mParallaxViewPager.setAdapter(adapter);
		mNavigationTabStrip.setViewPager(mParallaxViewPager);
		mNavigationTabStrip.setmStripPadding(10);
	}
}
