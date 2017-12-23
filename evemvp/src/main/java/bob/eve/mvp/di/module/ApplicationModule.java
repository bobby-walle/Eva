/*
 * Create by BobEve on 17-12-11 下午10:49
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:49
 */

package bob.eve.mvp.di.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Bob on 17/12/11.
 */

@Module
public class ApplicationModule {
	private Application application;

	public ApplicationModule(Application application) {
		this.application = application;
	}

	@Singleton
	@Provides
	public Application provideApplication() {
		return application;
	}
}
