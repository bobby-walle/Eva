/*
 * Create by BobEve on 17-12-13 下午4:41
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午4:41
 */

package bob.eve.walle.mvp.service;

import bob.eve.walle.mvp.entity.AqicnAQIDetailsEntity;
import bob.eve.walle.mvp.entity.AqicnStationsEntiry;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bob on 17/12/13.
 */

public interface AqicnService {
	// https://api.waqi.info/feed/geo:40.09;116.174/?token=21acde2c4ac1fc1f47d4cbeb752e6bc000ea171d 经纬度获取

	// https://api.waqi.info/map/bounds/?latlng=39.379436,116.091230,40.235643,116.784382&token=demo 经纬度范围获取

	// https://api.waqi.info/search/?token=21acde2c4ac1fc1f47d4cbeb752e6bc000ea171d&keyword=beijing 全北京所有观察点数据，但是不能单独获取某一个观察点数据，可以全部获取进行地区匹配显示各观察点数据

	/**
	 * 通过百度定位获取lat&lng
	 *
	 * @param lat
	 * 		latitude 纬度
	 * @param lng
	 * 		longitude 经度
	 */
	@GET("https://api.waqi.info/feed/geo:{lat};{lng}/")
	Observable<AqicnAQIDetailsEntity> getAQIDetailsForCity(@Path("lat") double lat,
																												 @Path("lng") double lng,
																												 @Query("token") String token);

	/**
	 * @param city
	 * 		查询城市所有观察点，拼音
	 */
	@GET("https://api.waqi.info/search/")
	Observable<AqicnStationsEntiry> getAQIStationsForCity(@Query("keyword") String city,
																												@Query("token") String token);
}
