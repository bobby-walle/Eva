/*
 * Create by BobEve on 17-12-11 下午9:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午9:01
 */

package bob.eve.mvp.base;

import bob.eve.mvp.presenter.IPresenter;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/11.
 */

public abstract class AbsEveBaseFragment<P extends IPresenter> extends AbsEveEasyFragment {

	@Inject
	protected P mPresenter;

	@Override
	public void onDestroyView() {
		if (mPresenter != null) {
			mPresenter.destroy();
		}
		super.onDestroyView();
	}
}
