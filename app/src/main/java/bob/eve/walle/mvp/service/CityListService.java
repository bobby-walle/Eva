/*
 * Create by BobEve on 17-12-12 下午7:31
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午7:31
 */

package bob.eve.walle.mvp.service;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Bob on 17/12/12.
 */

public interface CityListService {
	String CITYLIST_BASE_PATH = "http://www.weather.com.cn/data/city3jdata";

	String PROVINCE = "http://www.weather.com.cn/data/city3jdata/china.html";
	String CITY = "http://www.weather.com.cn/data/city3jdata/provshi/10120.html";
	String COUNTY = "http://www.weather.com.cn/data/city3jdata/station/1012002.html";

	@GET("china.html")
	Observable<String> getProvices();

	@GET("provshi/{id}.html")
	Observable<String> getCities(@Path("id") String id);

	@GET("station/{id}.html")
	Observable<String> getCounties(@Path("id") String id);
}

