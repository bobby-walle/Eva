/*
 * Create by BobEve on 17-12-9 下午3:04
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午3:01
 */

package bob.eve.repository;

import android.content.Context;

/**
 * Created by Bob on 17/12/9.
 */

public interface IEveRepositoryManager {
	<T> T obtainRetrofitService(Class<T> service);

	<T> T obtainCacheService(Class<T> service);

	void clearCache();

	Context getContext();
}
