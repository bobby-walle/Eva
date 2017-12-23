/*
 * Create by BobEve on 17-12-14 上午11:42
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 上午11:36
 */

package bob.eve.walle.mvp.cache;

import bob.eve.walle.mvp.entity.SojsonWeatherEntity;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bob on 17/12/13.
 */

public interface SojsonWeatherCacheService {

	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<SojsonWeatherEntity>> getForecastWeathersFromSojson(
			Observable<SojsonWeatherEntity> provices, DynamicKey dk, EvictProvider ep);
}
