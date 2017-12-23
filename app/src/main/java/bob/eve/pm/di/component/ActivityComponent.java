/*
 * Create by BobEve on 17-12-12 下午11:36
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午11:36
 */

package bob.eve.pm.di.component;

import bob.eve.mvp.di.component.AppComponent;
import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.pm.config.ImplPreferencesHelper;
import bob.eve.pm.di.module.ActivityModule;
import bob.eve.pm.ui.activity.MainActivity;
import bob.eve.pm.ui.activity.TencentWebActivity;
import dagger.Component;

/**
 * Created by Bob on 17/12/12.
 */

@PreActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

	void inject(MainActivity mainActivity);

	void inject(TencentWebActivity tencentWebActivity);
}
