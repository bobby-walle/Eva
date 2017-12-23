/*
 * Create by BobEve on 17-12-13 下午10:25
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午10:25
 */

package bob.eve.walle.mvp.service;

import bob.eve.walle.mvp.entity.SojsonWeatherEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bob on 17/12/13.
 */

public interface SojsonWeatherService {
	// params city=北京
	String SOJSON_WEATHER_BASE_URL = "http://www.sojson.com/open/api/weather/json.shtml";

	/**
	 * @param city
	 * 		eg.北京 注意需要汉字
	 */
	@GET("http://www.sojson.com/open/api/weather/json.shtml")
	Observable<SojsonWeatherEntity> getForecastWeathersFromSojson(@Query("city") String city);
}
