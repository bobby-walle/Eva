/*
 * Create by BobEve on 17-12-22 下午8:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 下午8:37
 */

package bob.eve.walle.mvp.presenter;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.view.IView;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/21.
 */

@PreFragment
public class SettingPresenter implements IPresenter {

	@Inject
	public SettingPresenter() {
	}

	@Override
	public void resume() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void attach(IView view) {

	}

	@Override
	public void detach() {

	}

	@Override
	public boolean isAttach() {
		return false;
	}
}
