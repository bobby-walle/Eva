/*
 * Create by BobEve on 17-12-22 下午6:22
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-22 下午6:07
 */

package bob.eve.pm.ui.activity;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import bob.eve.mvp.base.AbsEveBaseActivity;
import bob.eve.mvp.di.component.AppComponent;
import bob.eve.mvp.view.IView;
import bob.eve.pm.R;
import bob.eve.pm.config.ImplPreferencesHelper;
import bob.eve.pm.di.component.ActivityComponent;
import bob.eve.pm.di.component.DaggerActivityComponent;
import bob.eve.pm.mvp.presenter.MainPresenter;
import bob.eve.pm.ui.activity.slide.DrawerAdapter;
import bob.eve.pm.ui.activity.slide.DrawerItem;
import bob.eve.pm.ui.activity.slide.SimpleItem;
import bob.eve.pm.ui.activity.slide.SpaceItem;
import bob.eve.pm.ui.fragment.AboutFragment;
import bob.eve.pm.ui.fragment.SettingFragment;
import bob.eve.pm.ui.fragment.tab.HiGirlTabFragment;
import bob.eve.pm.ui.fragment.tab.ITCircleTabFragment;
import bob.eve.pm.ui.fragment.tab.MovieTabFragment;
import bob.eve.pm.ui.fragment.tab.ReadTabFragment;
import butterknife.BindView;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.Arrays;
import javax.inject.Inject;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends AbsEveBaseActivity<MainPresenter, ActivityComponent>
		implements DrawerAdapter.OnItemSelectedListener, IView {
	private static final int SLIDE_FRAGMENGT_COUNT = 6;
	private static final int SLIDE_MENU_CODE = 0;
	private static final int SLIDE_MENU_MOVIE = 1;
	private static final int SLIDE_MENU_GIRL = 2;
	private static final int SLIDE_MENU_READ = 3;
	private static final int SLIDE_MENU_SETTING = 4;
	private static final int SLIDE_MENU_ABOUT = 5;

	private SupportFragment[] mFragments = new SupportFragment[SLIDE_FRAGMENGT_COUNT];
	private String[] screenTitles;
	private Drawable[] screenIcons;

	@Inject
	ImplPreferencesHelper preferencesHelper;

	private SlidingRootNav slidingRootNav;
	@BindView(R.id.toolbar)
	public Toolbar mToolbar;
	private DrawerAdapter adapter;
	private int curPosition = 0;

	@Override
	public void injectComponent(AppComponent appComponent) {
		DaggerActivityComponent.builder()
													 .appComponent(appComponent)
													 .build()
													 .inject(this);
	}

	@Override
	public ActivityComponent getComponent() {
		return null;
	}

	@Override
	public int layoutResID() {
		return R.layout.activity_main;
	}

	@Override
	public void initView() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final int position = preferencesHelper.getFragmentIndex();

		setToolBar(mToolbar, "Eve");
		initTabFragment();
		initSlide(savedInstanceState, mToolbar);

		if (position != 0 && adapter != null) {
			adapter.setSelected(position);
			preferencesHelper.setFragmentIndex(0);
		}
	}

	private void initTabFragment() {
		SupportFragment itCircleTabFragment = findFragment(ITCircleTabFragment.class);
		if (itCircleTabFragment == null) {
			mFragments[SLIDE_MENU_CODE] = ITCircleTabFragment.newInstance();
			mFragments[SLIDE_MENU_MOVIE] = MovieTabFragment.newInstance();
			mFragments[SLIDE_MENU_GIRL] = HiGirlTabFragment.newInstance();
			mFragments[SLIDE_MENU_READ] = ReadTabFragment.newInstance();
			mFragments[SLIDE_MENU_SETTING] = SettingFragment.newInstance();
			mFragments[SLIDE_MENU_ABOUT] = AboutFragment.newInstance();

			loadMultipleRootFragment(R.id.container, SLIDE_MENU_CODE, mFragments[SLIDE_MENU_CODE],
															 mFragments[SLIDE_MENU_MOVIE], mFragments[SLIDE_MENU_GIRL],
															 mFragments[SLIDE_MENU_READ], mFragments[SLIDE_MENU_SETTING],
															 mFragments[SLIDE_MENU_ABOUT]);
		} else {
			mFragments[SLIDE_MENU_CODE] = itCircleTabFragment;
			mFragments[SLIDE_MENU_MOVIE] = findFragment(MovieTabFragment.class);
			mFragments[SLIDE_MENU_GIRL] = findFragment(HiGirlTabFragment.class);
			mFragments[SLIDE_MENU_READ] = findFragment(ReadTabFragment.class);
			mFragments[SLIDE_MENU_SETTING] = findFragment(SettingFragment.class);
			mFragments[SLIDE_MENU_ABOUT] = findFragment(AboutFragment.class);
		}
	}

	private void initSlide(Bundle savedInstanceState, Toolbar toolbar) {
		slidingRootNav = new SlidingRootNavBuilder(this).withToolbarMenuToggle(toolbar)
																										.withMenuOpened(false)
																										.withContentClickableWhenMenuOpened(false)
																										.withSavedState(savedInstanceState)
																										.withToolbarMenuToggle(toolbar)
																										.withMenuLayout(R.layout.menu_slide_left_layout)
																										.inject();

		screenIcons = loadScreenIcons();
		screenTitles = loadScreenTitles();

		adapter = new DrawerAdapter(Arrays.asList(createItemFor(SLIDE_MENU_CODE).setChecked(true),
																							createItemFor(SLIDE_MENU_MOVIE),
																							createItemFor(SLIDE_MENU_GIRL), new SpaceItem(38)
																							//createItemFor(SLIDE_MENU_READ) 暂时关闭阅读模块
				, createItemFor(SLIDE_MENU_SETTING), createItemFor(SLIDE_MENU_ABOUT)));
		adapter.setListener(this);

		RecyclerView list = findViewById(R.id.menu_rv);
		list.setNestedScrollingEnabled(false);
		list.setLayoutManager(new LinearLayoutManager(this));
		list.setAdapter(adapter);

		adapter.setSelected(SLIDE_MENU_CODE);
	}

	private Fragment creatAboutFragment() {
		//		LibsSupportFragment fragment =
		new LibsBuilder().withLibraries(LIBRARIES)
										 .withAutoDetect(false)
										 .withLicenseShown(true)
										 .withVersionShown(true)
										 .withActivityTitle("关于")
										 .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
										 .start(MainActivity.this);
		//												 .supportFragment();
		return null;
	}

	private String[] LIBRARIES = new String[] {
			"butterknife", "gson", "sliding-root-nav", "okhttp", "recyclerview_v7", "smartrefresh",
			"folding-cell", "crashreport", "cardview", "recyclerview", "photoview", "dagger", "RxCache",
			"rxjava", "rxandroid"
	};

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void attachView() {

	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public void onItemSelected(int position) {
		if (slidingRootNav != null && slidingRootNav.isMenuOpened()) {
			slidingRootNav.closeMenu();
		}

		if (position == SLIDE_MENU_ABOUT) {
			creatAboutFragment();
			adapter.setSelected(curPosition);
		} else {
			mToolbar.setTitle(screenTitles[position]);
			showHideFragment(mFragments[position]);
			curPosition = position;
		}
	}

	@ColorInt
	private int color(@ColorRes int res) {
		return ContextCompat.getColor(this, res);
	}

	@Override
	public void start() {

	}

	@Override
	public void complete() {

	}

	@Override
	public void error(Throwable error) {

	}

	private DrawerItem createItemFor(int position) {
		return new SimpleItem(screenIcons[position], screenTitles[position]).withIconTint(
				color(R.color.textColorSecondary))
																																				.withTextTint(color(
																																						R.color.textColorPrimary))
																																				.withSelectedIconTint(color(
																																						R.color.colorAccent))
																																				.withSelectedTextTint(color(
																																						R.color.colorAccent));
	}

	private String[] loadScreenTitles() {
		return getResources().getStringArray(R.array.ld_activityScreenTitles);
	}

	private Drawable[] loadScreenIcons() {
		TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
		Drawable[] icons = new Drawable[ta.length()];
		for (int i = 0; i < ta.length(); i++) {
			int id = ta.getResourceId(i, 0);
			if (id != 0) {
				icons[i] = ContextCompat.getDrawable(this, id);
			}
		}
		ta.recycle();
		return icons;
	}

	public void changeDayNight(boolean isNight) {
		preferencesHelper.setFragmentIndex(curPosition);
		preferencesHelper.setNightModeState(isNight);
		useNightMode(isNight);
	}
}
