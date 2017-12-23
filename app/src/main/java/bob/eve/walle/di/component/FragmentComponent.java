/*
 * Create by BobEve on 17-12-19 下午3:53
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午3:53
 */

package bob.eve.walle.di.component;

import android.app.Activity;
import bob.eve.mvp.di.component.AppComponent;
import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.walle.di.module.FragmentModule;
import bob.eve.walle.ui.fragment.HiGirlFromGankFragment;
import bob.eve.walle.ui.fragment.HiGirlFromTianFragment;
import bob.eve.walle.ui.fragment.ITCircleFromGankCategoryFragment;
import bob.eve.walle.ui.fragment.MovieFromDoubanTop250Fragment;
import bob.eve.walle.ui.fragment.MovieFromDoubanUSBoxFragment;
import bob.eve.walle.ui.fragment.MovieFromGankFragment;
import bob.eve.walle.ui.fragment.SettingFragment;
import dagger.Component;

/**
 * Created by Bob on 17/12/19.
 */
@PreFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
	Activity getActivity();

	void inject(ITCircleFromGankCategoryFragment itCircleFromGankCategoryFragment);

	void inject(MovieFromDoubanTop250Fragment movieFromDoubanTop250Fragment);

	void inject(MovieFromGankFragment movieFromGankFragment);

	void inject(MovieFromDoubanUSBoxFragment movieFromDoubanUSBoxFragment);

	void inject(HiGirlFromGankFragment hiGirlFromGankFragment);

	void inject(HiGirlFromTianFragment hiGirlFromTianFragment);

	void inject(SettingFragment settingFragment);
}
