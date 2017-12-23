/*
 * Create by BobEve on 17-12-18 下午6:42
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午9:09
 */

package bob.eve.mvp.base;

import android.app.Application;
import android.view.View;

/**
 * Created by Bob on 17/12/11.
 */

public interface IFragment {

	int layoutResID();

	void attachView();

	/**
	 * toolbar 或者无动画
	 */
	void initView(View view);

	/**
	 * 设置Adapter 尺寸改变等
	 */
	void initLazyView(View view);

	Application application();
}
