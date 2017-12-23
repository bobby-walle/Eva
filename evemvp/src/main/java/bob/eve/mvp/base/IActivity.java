/*
 * Create by BobEve on 17-12-11 下午7:37
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午7:37
 */

package bob.eve.mvp.base;

import bob.eve.mvp.di.component.AppComponent;

/**
 * Created by Bob on 17/12/11.
 */

public interface IActivity<C> {
	void injectComponent(AppComponent appComponent);

	C getComponent();

	int layoutResID();

	void initView();
}
