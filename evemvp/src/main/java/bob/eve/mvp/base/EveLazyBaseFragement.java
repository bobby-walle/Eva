/*
 * Create by BobEve on 17-12-11 下午10:00
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:00
 */

package bob.eve.mvp.base;

import android.os.Bundle;

/**
 * Created by Bob on 17/12/11.
 */

public abstract class EveLazyBaseFragement extends AbsEveBaseFragment {
	private boolean isPrepared = false;
	private boolean isFirstVisible = false;
	private boolean isFirstInvisible = false;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initPrepare();
	}

	private synchronized void initPrepare() {
		if (isPrepared) {
			lazeFirstVisible();
		} else {
			isPrepared = true;
		}
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser) {
			if (isFirstVisible) {
				isFirstVisible = false;
				initPrepare();
			} else {
				lazeVisible();
			}
		} else {
			if (isFirstInvisible) {
				isFirstInvisible = false;
				lazeFirstInvisible();
			} else {
				lazeInvisible();
			}
		}
	}

	protected abstract void lazeFirstVisible();

	protected abstract void lazeVisible();

	protected abstract void lazeInvisible();

	private void lazeFirstInvisible() {
	}
}

