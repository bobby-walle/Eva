/*
 * Create by BobEve on 17-12-19 下午1:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午1:01
 */

package bob.eve.pm.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import bob.eve.mvp.base.AbsEveBaseFragment;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public class EveEasyFragmentAdapter extends FragmentPagerAdapter {

	private List<AbsEveBaseFragment> mFragments;

	public EveEasyFragmentAdapter(FragmentManager fm, List<AbsEveBaseFragment> fragments) {
		super(fm);
		if (fragments == null) {
			fragments = Collections.emptyList();
		}

		this.mFragments = fragments;
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
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//		super.destroyItem(container, position, object);
	}
}
