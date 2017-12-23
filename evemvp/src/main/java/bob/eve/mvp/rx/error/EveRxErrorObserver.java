/*
 * Create by BobEve on 17-12-11 下午10:17
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:17
 */

package bob.eve.mvp.rx.error;

import bob.eve.mvp.view.IView;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Bob on 17/12/11.
 */

public abstract class EveRxErrorObserver<T> extends DisposableObserver<T> {
	private IView view;

	public EveRxErrorObserver(IView view) {
		this.view = view;
	}

	@Override
	protected void onStart() {
		if (view != null) {
			view.start();
		}
	}

	@Override
	public void onComplete() {
		if (view != null) {
			view.complete();
		}
	}

	@Override
	public void onError(Throwable e) {
		if (view != null) {
			view.error(e);
		}
	}
}
