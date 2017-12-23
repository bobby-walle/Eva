/*
 * Create by BobEve on 17-12-19 下午3:35
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午4:28
 */

package bob.eve.mvp.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import bob.eve.comm.lib.util.Preconditions;
import bob.eve.mvp.base.proxy.ApplicationProxy;
import bob.eve.mvp.di.component.AppComponent;

/**
 * Created by Bob on 17/12/12.
 */

public class EveBaseApplication extends Application implements IApplication {
	protected ApplicationProxy mApplicationProxy;

	/**
	 * {@link ContextWrapper#getBaseContext()}获得{@link Context}的实现类ContextImpl，
	 * mBse在{@link ContextWrapper#attachBaseContext(Context base)}赋值
	 * 在赋值前newApplication创建了Application
	 *
	 * static public Application newApplication(Class<?> clazz, Context context)
	 * * throws InstantiationException, IllegalAccessException,ClassNotFoundException {
	 * * * Application app = (Application)clazz.newInstance();
	 * * * app.attach(context);
	 * * * return app;
	 * }
	 *
	 * final void attach(Context context) {
	 * * * attachBaseContext(context);
	 * * * mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
	 * }
	 *
	 * so Application 可以开始使用了,可以配置组件参数初始化
	 */
	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
//		MultiDex.install(this);

	}

	@Override
	public AppComponent getAppComponent() {
		Preconditions.checkNotNull(mApplicationProxy, "ApplicationProxy can not be null.");
		return mApplicationProxy.getAppComponent();
	}
}
