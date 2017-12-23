/*
 * Create by BobEve on 17-12-14 上午11:43
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 上午11:43
 */

package bob.eve.walle.mvp.cache;

import bob.eve.walle.mvp.entity.Pm25InAQIDetailsEntity;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bob on 17/12/12.
 */

public interface Pm25InCacheService {
	/**
	 * @param source
	 * 		网络请求数据源Observable
	 * @param dynamicKey
	 * 		缓存key
	 * @param evictProvider
	 * 		是否更新{@link EvictProvider}
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<List<Pm25InAQIDetailsEntity>>> getAQIDetailsForCity(
			Observable<List<Pm25InAQIDetailsEntity>> source, DynamicKey dynamicKey,
			EvictProvider evictProvider);
}
