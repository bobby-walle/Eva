/*
 * Create by BobEve on 17-12-9 下午3:06
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午2:54
 */

package bob.eve.repository;

import android.app.Application;
import android.content.Context;
import bob.eve.comm.lib.util.Preconditions;
import bob.eve.repository.cache.IEveCache;
import bob.eve.repository.cache.IEveCacheType;
import dagger.Lazy;
import io.rx_cache2.internal.RxCache;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by Bob on 17/12/9.
 */

@Singleton
public class EveRepositoryManager implements IEveRepositoryManager {

	private Lazy<Retrofit> retrofitLazy;
	private Lazy<RxCache> rxCacheLazy;
	private IEveCache<String, Object> retorfitCache;
	private IEveCache<String, Object> rxCacheCache;
	private IEveCache.Factory cacheFactory;
	private Application application;

	private final Object retrofitCacheLock = new Object();
	private final Object rxCacheCacheLock = new Object();

	@Inject
	public EveRepositoryManager(Lazy<Retrofit> retrofitLazy, Lazy<RxCache> rxCacheLazy,
															IEveCache.Factory cacheFactory, Application application) {
		this.retrofitLazy = retrofitLazy;
		this.rxCacheLazy = rxCacheLazy;
		this.cacheFactory = cacheFactory;
		this.application = application;

		Preconditions.checkNotNull(retrofitLazy, "Cannot null with retrofitLazy");
		Preconditions.checkNotNull(rxCacheLazy, "Cannot null with rxCacheLazy");
		Preconditions.checkNotNull(cacheFactory, "Cannot null with cacheFactory");
		Preconditions.checkNotNull(application, "Cannot null with application");
	}

	@Override
	public <T> T obtainRetrofitService(Class<T> service) {
		if (retorfitCache == null) {
			retorfitCache = cacheFactory.build(IEveCacheType.RETROFIT_SERVICE_CACHE);
		}
		Preconditions.checkNotNull(retorfitCache,
															 "Cannot return null from a IEveCache.Factory#build(int) method");
		T retrofitService;

		synchronized (retrofitCacheLock) {
			retrofitService = (T) retorfitCache.get(service.getCanonicalName());
			if (retrofitService == null) {
				retrofitService = retrofitLazy.get()
																			.create(service);
				retorfitCache.put(service.getCanonicalName(), retrofitService);
			}
		}

		return retrofitService;
	}

	@Override
	public <T> T obtainCacheService(Class<T> service) {
		if (rxCacheCache == null) {
			rxCacheCache = cacheFactory.build(IEveCacheType.CACHE_SERVICE_CACHE);
		}
		Preconditions.checkNotNull(rxCacheCache,
															 "Cannot return null from a IEveCache.Factory#build(int) method");

		T rxCacheService;
		synchronized (rxCacheCacheLock) {
			rxCacheService = (T) rxCacheCache.get(service.getCanonicalName());
			if (rxCacheService == null) {
				rxCacheService = rxCacheLazy.get()
																		.using(service);
				rxCacheCache.put(service.getCanonicalName(), rxCacheService);
			}
		}
		return rxCacheService;
	}

	@Override
	public void clearCache() {
		rxCacheLazy.get()
							 .evictAll();
	}

	@Override
	public Context getContext() {
		return application;
	}
}
