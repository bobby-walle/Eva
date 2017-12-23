/*
 * Create by BobEve on 17-12-14 下午4:49
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 上午11:43
 */

package bob.eve.walle.mvp.cache;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bob on 17/12/12.
 */

public interface CityListCacheService {
	String CITYLIST_BASE_PATH = "http://www.weather.com.cn/data/city3jdata";

	String PROVINCE = "http://www.weather.com.cn/data/city3jdata/china.html";
	String CITY = "http://www.weather.com.cn/data/city3jdata/provshi/10120.html";
	String COUNTY = "http://www.weather.com.cn/data/city3jdata/station/1012002.html";

	@LifeCache(duration = 20, timeUnit = TimeUnit.SECONDS)
	Observable<Reply<String>> getProvices(Observable<String> provices, DynamicKey dk,
																				EvictProvider ep);

	@LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<String>> getCities(Observable<String> provices, DynamicKey dk, EvictProvider ep);

	@LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<String>> getCounties(Observable<String> provices, DynamicKey dk,
																				EvictProvider ep);

}

