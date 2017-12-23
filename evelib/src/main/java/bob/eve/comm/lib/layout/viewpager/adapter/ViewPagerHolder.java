/*
 * Create by BobEve on 17-12-19 下午12:44
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午11:40
 */

package bob.eve.comm.lib.layout.viewpager.adapter;

import android.content.Context;
import android.view.View;

/**
 * Created by Bob on 17/12/19.
 */

public interface ViewPagerHolder<T> {
	/**
	 * 创建Item View
	 */
	View createView(Context context);

	/**
	 * 绑定数据
	 */
	void onBindData(Context context, View view, int position, T data);
}
