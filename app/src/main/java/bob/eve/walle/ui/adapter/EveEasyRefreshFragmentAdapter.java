/*
 * Create by BobEve on 17-12-19 下午12:59
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午12:59
 */

package bob.eve.walle.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import bob.eve.mvp.base.AbsEveEasyFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public class EveEasyRefreshFragmentAdapter extends FragmentPagerAdapter {

	private List<AbsEveEasyFragment> mFragments;
	private FragmentManager fragmentManager;
	private List<String> tags;

	public EveEasyRefreshFragmentAdapter(FragmentManager fm, List<AbsEveEasyFragment> fragments) {
		super(fm);
		this.tags = new ArrayList<>();
		this.fragmentManager = fm;
		this.mFragments = fragments;
	}

	public void setNewFragments(List<AbsEveEasyFragment> fragments) {
		if (this.tags != null) {
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			for (int i = 0; i < tags.size(); i++) {
				fragmentTransaction.remove(fragmentManager.findFragmentByTag(tags.get(i)));
			}
			fragmentTransaction.commit();
			fragmentManager.executePendingTransactions();
			tags.clear();
		}
		this.mFragments = fragments;
		notifyDataSetChanged();
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		tags.add(makeFragmentName(container.getId(), getItemId(position)));
		Fragment fragment = (Fragment) super.instantiateItem(container, position);
		this.fragmentManager.beginTransaction()
												.show(fragment)
												.commit();
		return fragment;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		Fragment fragment = mFragments.get(position);
		fragmentManager.beginTransaction()
									 .hide(fragment)
									 .commit();
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	private static String makeFragmentName(int viewId, long id) {
		return "android:switcher:" + viewId + ":" + id;
	}
}
