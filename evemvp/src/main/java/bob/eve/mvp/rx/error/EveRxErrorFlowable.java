/*
 * Create by BobEve on 17-12-11 下午10:32
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:31
 */

package bob.eve.mvp.rx.error;

import io.reactivex.annotations.NonNull;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Bob on 17/12/11.
 */

public abstract class EveRxErrorFlowable<T> extends DisposableSubscriber<T> {
	private EveRxErrorFactory mErrorFactory;

	public EveRxErrorFlowable(EveRxErrorHandler errorHandler) {
		this.mErrorFactory = errorHandler.getErrorFactory();
	}

	@Override
	public void onComplete() {

	}

	/**
	 * 如果不调用supper，则子类自行处理错误
	 */
	@Override
	public void onError(@NonNull Throwable t) {
		t.printStackTrace();
		mErrorFactory.onError(t);
	}
}
