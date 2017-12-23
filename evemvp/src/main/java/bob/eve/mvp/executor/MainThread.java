/*
 * Create by BobEve on 17-12-10 下午11:36
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午11:36
 */

package bob.eve.mvp.executor;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainThread implements PostExecutionThread {

	@Inject
	MainThread() {
	}

	@Override
	public Scheduler getScheduler() {
		return AndroidSchedulers.mainThread();
	}
}