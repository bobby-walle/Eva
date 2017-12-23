/*
 * Create by BobEve on 17-12-12 下午11:36
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午11:36
 */

package bob.eve.pm.di.module;

import android.app.Activity;
import android.app.Application;
import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.pm.config.ImplPreferencesHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by Bob on 17/12/12.
 */

@Module
public class ActivityModule {
	private Activity mActivity;

	public ActivityModule(Activity activity) {
		this.mActivity = activity;
	}

	@Provides
	@PreActivity
	public Activity provideActivity() {
		return mActivity;
	}

}

