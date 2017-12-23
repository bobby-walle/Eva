/*
 * Create by BobEve on 17-12-19 下午12:44
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午12:42
 */

package bob.eve.comm.lib.layout.viewpager.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import bob.eve.comm.lib.util.Preconditions;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public class EveCommonViewPagerAdapter<T> extends PagerAdapter {
	private List<T> datas;
	private ViewPagerHolderCreator creator;

	public EveCommonViewPagerAdapter(List<T> datas, ViewPagerHolderCreator creator) {
		Preconditions.checkNotNull(creator, "ViewPagerHolderCreator can not be null");
		this.datas = datas;
		this.creator = creator;
	}

	@Override
	public int getCount() {
		return datas == null ? 0 : datas.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = getView(container, position);
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	/**
	 * 获取viewPager 页面展示View
	 */
	private View getView(ViewGroup container, int position) {
		View view = null;
		Object o = container.getTag(position);
		if (o != null && o instanceof View) {
			view = (View) o;
		}

		ViewPagerHolder<T> holder;
		if (view == null) {
			//创建Holder
			holder = creator.createViewPagerHolder();
			view = holder.createView(container.getContext());
			container.setTag(position, view);
			view.setTag(holder);
		} else {
			holder = (ViewPagerHolder) view.getTag();
		}

		if (holder != null && datas != null && datas.size() > 0) {
			// 数据绑定
			holder.onBindData(container.getContext(), view, position, datas.get(position));
		}

		return view;
	}
}
