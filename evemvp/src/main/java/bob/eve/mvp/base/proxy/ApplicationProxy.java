/*
 * Create by BobEve on 17-12-11 下午5:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午4:57
 */

package bob.eve.mvp.base.proxy;

import android.app.Application;
import android.content.Context;
import bob.eve.comm.lib.configuration.IApplicationLifecycle;
import bob.eve.comm.lib.util.Preconditions;
import bob.eve.mvp.base.ApplicationRegister;
import bob.eve.mvp.base.IApplication;
import bob.eve.mvp.di.component.AppComponent;
import bob.eve.mvp.di.component.DaggerAppComponent;
import bob.eve.mvp.di.module.ApplicationModule;
import bob.eve.repository.di.module.EveRepositoryConfig;
import bob.eve.repository.di.module.EveRepositoryConfigModule;
import bob.eve.repository.di.module.EveRepositoryModule;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/11.
 */

public class ApplicationProxy implements IApplication, IApplicationLifecycle {
	private AppComponent appComponent;

	@Inject
	ApplicationRegister register;

	@Override
	public void onCreate(Application application) {
		configCommom(application);
		DaggerAppComponent.Builder builder = DaggerAppComponent.builder();
		builder.applicationModule(new ApplicationModule(application));
		builder.eveRepositoryModule(new EveRepositoryModule());
		//		configModules(application, builder);
		EveRepositoryConfigModule.Builder configBuilder = EveRepositoryConfigModule.builder();
		EveRepositoryConfig config = new EveRepositoryConfig();
		config.applyOptions(application, configBuilder);
		builder.eveRepositoryConfigModule(configBuilder.build());

		appComponent = builder.build();
		Preconditions.checkNotNull(appComponent, "Dagger AppComponent can not be null,");
		appComponent.inject(this);

		//		BGASwipeBackHelper.init(application, null);
		application.registerActivityLifecycleCallbacks(register);
		application.registerComponentCallbacks(register);
	}

	//	protected abstract DaggerAppComponent.Builder configModules(Application application,
	//																															DaggerAppComponent.Builder daggerBuilder);

	protected void configCommom(Application application) {

	}

	@Override
	public AppComponent getAppComponent() {
		Preconditions.checkNotNull(appComponent, "Dagger AppComponent can not be null,");
		return appComponent;
	}

	@Override
	public void attachBaseContext(Context base) {

	}

	@Override
	public void onTerminate(Application application) {

	}
}
