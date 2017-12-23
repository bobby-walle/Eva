/*
 * Create by BobEve on 17-12-19 下午3:49
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午3:49
 */

package bob.eve.walle.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import bob.eve.comm.lib.util.Preconditions;
import bob.eve.mvp.base.EveBaseApplication;
import bob.eve.mvp.base.AbsEveBaseFragment;
import bob.eve.mvp.di.component.AppComponent;
import bob.eve.mvp.presenter.IPresenter;
import bob.eve.walle.di.component.DaggerFragmentComponent;
import bob.eve.walle.di.component.FragmentComponent;
import bob.eve.walle.di.module.FragmentModule;

/**
 * Created by Bob on 17/12/19.
 */

public abstract class EveDiBaseFragment<P extends IPresenter> extends AbsEveBaseFragment<P> {

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		applyDi();
		super.onViewCreated(view, savedInstanceState);
	}

	protected void applyDi() {
		FragmentComponent fragmentComponent = DaggerFragmentComponent.builder()
																																 .appComponent(getComponent())
																																 .fragmentModule(
																																		 new FragmentModule(this))
																																 .build();
		inject(fragmentComponent);
	}

	protected abstract void inject(FragmentComponent fragmentComponent);

	protected AppComponent getComponent() {
		//		Application application = mContext.getApplication();
		Preconditions.checkArgument(mContext instanceof EveBaseApplication,
																"Error Application, must be call getApplication() in EveEasyFragment");
		return ((EveBaseApplication) mContext).getAppComponent();
	}
}
