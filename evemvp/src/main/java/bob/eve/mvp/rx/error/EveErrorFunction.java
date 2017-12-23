/*
 * Create by BobEve on 17-12-12 下午12:58
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午12:58
 */

package bob.eve.mvp.rx.error;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Bob on 17/12/12.
 */

public class EveErrorFunction<T> implements Function<Throwable, Observable<T>> {
	//	@Inject
	//	public Application application;

	@Override
	public Observable<T> apply(Throwable throwable) throws Exception {
		return Observable.error(EveErrorMapper.create(null, throwable));
	}
}
