/*
 * Create by BobEve on 17-12-19 上午12:06
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午12:06
 */

package bob.eve.walle.mvp.cache;

import bob.eve.walle.mvp.entity.douban.Top250Entity;
import bob.eve.walle.mvp.entity.douban.USBoxEntity;
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

public interface DouEveCacheService {
	/**
	 * Top250
	 *
	 * /v2/movie/top250
	 *
	 * params
	 * start	start	int	Y	Y	N/A	0
	 * count	count	int	Y	Y	N/A	10
	 */
	@LifeCache(duration = 12, timeUnit = TimeUnit.HOURS)
	Observable<Reply<Top250Entity>> getTop250Movies(Observable<Top250Entity> provices, DynamicKey dk,
																									EvictDynamicKey ek);

	/**
	 * 北美票房榜
	 *
	 * /v2/movie/us_box
	 */
	@LifeCache(duration = 12, timeUnit = TimeUnit.HOURS)
	Observable<Reply<USBoxEntity>> getUSBox(Observable<USBoxEntity> provices, DynamicKey dk,
																					EvictDynamicKey ek);
}
