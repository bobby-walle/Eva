/*
 * Create by BobEve on 17-12-11 下午2:02
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午2:02
 */

package bob.eve.mvp.model;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Bob on 17/12/10.
 */

public interface IModel<T, PARAMS> {

	//	Observable<T> buildModelDataObservable(P params);

	void execute(DisposableObserver<T> observer, PARAMS params);

	void addDisposable(Disposable disposable);

	void dispose();
}
