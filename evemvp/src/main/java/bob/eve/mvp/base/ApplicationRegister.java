/*
 * Create by BobEve on 17-12-11 下午4:37
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午4:37
 */

package bob.eve.mvp.base;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Bob on 17/12/11.
 */

@Singleton
public class ApplicationRegister
		implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
	private EveActivityManager eveActivityManager;
	private Application application;

	@Inject
	public ApplicationRegister(EveActivityManager eveActivityManager, Application application) {
		this.eveActivityManager = eveActivityManager;
		this.application = application;
	}

	@Override
	public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
		if (activity != null && activity instanceof IActivity) {
			// 注入Component
			((IActivity) activity).injectComponent(((IApplication) application).getAppComponent());
		}
	}

	@Override
	public void onActivityStarted(Activity activity) {

	}

	@Override
	public void onActivityResumed(Activity activity) {

	}

	@Override
	public void onActivityPaused(Activity activity) {

	}

	@Override
	public void onActivityStopped(Activity activity) {

	}

	@Override
	public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

	}

	@Override
	public void onActivityDestroyed(Activity activity) {

	}

	@Override
	public void onTrimMemory(int level) {

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {

	}

	@Override
	public void onLowMemory() {

	}
}
