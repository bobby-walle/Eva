/*
 * Create by BobEve on 17-12-14 上午11:43
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 上午11:42
 */

package bob.eve.walle.mvp.service;

import bob.eve.walle.mvp.entity.Pm25InAQIDetailsEntity;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bob on 17/12/12.
 */

public interface Pm25InService {
	/**
	 * 获取一个城市所有监测点的AQI数据（含详情）
	 * Get 	http://www.pm25.in/api/querys/aqi_details.json
	 * city：必选
	 * avg：可选
	 * stations：可选
	 *
	 * 参数说明:
	 * city：城市名称
	 * avg：是否返回一个城市所有监测点数据均值的标识
	 * stations：是否只返回一个城市均值的标识
	 */

	/**
	 * @param city
	 * 		查询城市名称，可以汉字可拼音，建议拼音(汉字需要encode)
	 */
	@GET("http://www.pm25.in/api/querys/aqi_details.json")
	Observable<List<Pm25InAQIDetailsEntity>> getAQIDetailsForCity(@Query("city") String city,
																																@Query("token") String token);

	/**
	 * @param city
	 * 		查询城市名称，可以汉字可拼音，建议拼音(汉字需要encode)
	 * @param avg
	 * 		是否返回一个城市所有监测点数据均值的标识,默认为true返回
	 * @param stations
	 * 		是否只返回一个城市均值的标识,默认为true返回
	 */
	@GET("http://www.pm25.in/api/querys/aqi_details.json")
	Observable<List<Pm25InAQIDetailsEntity>> getAQIDetailsForCity(@Query("city") String city,
																																@Query("token") String token,
																																@Query("avg") boolean avg,
																																@Query("stations")
																																		boolean stations);
}
