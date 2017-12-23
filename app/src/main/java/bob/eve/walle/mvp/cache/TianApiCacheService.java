/*
 * Create by BobEve on 17-12-18 下午11:12
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午11:11
 */

package bob.eve.walle.mvp.cache;

import bob.eve.walle.mvp.entity.tian.TianGirlEntity;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bob on 17/12/18.
 */

public interface TianApiCacheService {
	// http://api.tianapi.com/meinv/?key=APIKEY&num=10

	@LifeCache(duration = 12, timeUnit = TimeUnit.HOURS)
	Observable<Reply<TianGirlEntity>> getTianGirls(Observable<TianGirlEntity> provices, DynamicKey dk,
																								 EvictDynamicKey ek);
}
