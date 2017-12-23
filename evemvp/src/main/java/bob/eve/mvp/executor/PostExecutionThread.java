/*
 * Create by BobEve on 17-12-10 下午11:30
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-6 下午12:21
 */
package bob.eve.mvp.executor;

import io.reactivex.Scheduler;

public interface PostExecutionThread {
	Scheduler getScheduler();
}
