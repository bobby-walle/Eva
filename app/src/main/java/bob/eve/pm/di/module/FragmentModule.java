/*
 * Create by BobEve on 17-12-19 下午3:52
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午3:52
 */

package bob.eve.pm.di.module;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.pm.config.ImplPreferencesHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by Bob on 17/12/19.
 */
@Module
public class FragmentModule {

	private Fragment fragment;

	public FragmentModule(Fragment fragment) {
		this.fragment = fragment;
	}

	@Provides
	@PreFragment
	public Activity provideActivity() {
		return fragment.getActivity();
	}

}
