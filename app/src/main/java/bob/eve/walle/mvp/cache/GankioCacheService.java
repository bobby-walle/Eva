/*
 * Create by BobEve on 17-12-18 下午10:58
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午10:54
 */

package bob.eve.walle.mvp.cache;

import bob.eve.walle.mvp.entity.gank.GankItemEntity;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bob on 17/12/18.
 */

public interface GankioCacheService {
	@LifeCache(duration = 12, timeUnit = TimeUnit.HOURS)
	Observable<Reply<GankItemEntity>> getGanksWithCategory(Observable<GankItemEntity> provices,
																												 DynamicKey dk, EvictDynamicKey ek);

	@LifeCache(duration = 12, timeUnit = TimeUnit.HOURS)
	Observable<Reply<GankItemEntity>> getGanksWithDate(Observable<GankItemEntity> provices,
																										 DynamicKey dk, EvictDynamicKey ek);

}