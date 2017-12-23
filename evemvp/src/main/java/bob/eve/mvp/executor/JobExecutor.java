/*
 * Create by BobEve on 17-12-10 下午11:31
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-6 下午12:21
 */
package bob.eve.mvp.executor;

import android.support.annotation.NonNull;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Decorated {@link java.util.concurrent.ThreadPoolExecutor}
 */
@Singleton
public class JobExecutor implements ThreadExecutor {
	private final ThreadPoolExecutor threadPoolExecutor;

	@Inject
	JobExecutor() {
		this.threadPoolExecutor =
				new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5),
															 new JobThreadFactory());
	}

	@Override
	public void execute(@NonNull Runnable runnable) {
		this.threadPoolExecutor.execute(runnable);
	}

	private static class JobThreadFactory implements ThreadFactory {
		private int counter = 0;

		@Override
		public Thread newThread(@NonNull Runnable runnable) {
			return new Thread(runnable, "android_" + counter++);
		}
	}
}
