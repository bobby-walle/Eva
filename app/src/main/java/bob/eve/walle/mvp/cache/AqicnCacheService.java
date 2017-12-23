/*
 * Create by BobEve on 17-12-14 下午12:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午12:00
 */

package bob.eve.walle.mvp.cache;

import bob.eve.walle.mvp.entity.AqicnStationsEntiry;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bob on 17/12/13.
 *
 * 方法名 + $d$d$d$" + DynamicKey.dynamicKey + "$g$g$g$" + DynamicKeyGroup.group
 */

public interface AqicnCacheService {
	//	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	//	Observable<Reply<AqicnAQIDetailsEntity>> getAQIDetailsForCity(
	//			Observable<AqicnAQIDetailsEntity> source, DynamicKey dynamicKey, EvictProvider evictProvider);

	/**
	 * 一月更新一次观察点信息
	 */
	@LifeCache(duration = 30, timeUnit = TimeUnit.DAYS)
	Observable<Reply<AqicnStationsEntiry>> getAQIStationsForCity(
			Observable<AqicnStationsEntiry> source, DynamicKey dynamicKey, EvictProvider evictProvider);
}
