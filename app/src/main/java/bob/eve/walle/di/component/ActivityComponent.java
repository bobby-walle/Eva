/*
 * Create by BobEve on 17-12-12 下午11:36
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午11:36
 */

package bob.eve.walle.di.component;

import bob.eve.mvp.di.component.AppComponent;
import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.walle.di.module.ActivityModule;
import bob.eve.walle.ui.activity.EveWebActivity;
import bob.eve.walle.ui.activity.MainActivity;
import dagger.Component;

/**
 * Created by Bob on 17/12/12.
 */

@PreActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

	void inject(MainActivity mainActivity);

	void inject(EveWebActivity eveWebActivity);
}
