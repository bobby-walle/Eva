/*
 * Create by BobEve on 17-12-18 上午1:58
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午1:58
 */

package bob.eve.walle.mvp.service;

import bob.eve.walle.mvp.entity.gank.GankISearchItemEntity;
import bob.eve.walle.mvp.entity.gank.GankItemEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Bob on 17/12/18.
 */

public interface GankioService {
	String HOST = "http://gank.io/api/";
	
	/**
	 * category: all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
	 */
	@GET("http://gank.io/api/data/{category}/{num}/{page}")
	Observable<GankItemEntity> getGanksWithCategory(@Path("category") String category,
																									@Path("num") int num, @Path("page") int page);

	/**
	 * xxxx/xx/xx的gank数据
	 */
	@GET("http://gank.io/api/data/day/{year}/{month}/{day}")
	Observable<GankItemEntity> getGanksWithDate(@Path("year") int num, @Path("month") int page,
																							@Path("day") int day);

	/**
	 * 随机妹纸图
	 */
	@GET("http://gank.io/api/random/data/福利/{num}")
	Observable<GankItemEntity> getRandomGirls(@Path("num") int num);

	/**
	 * 搜索
	 */
	@GET("http://gank.io/api/search/query/{query}/category/{category}/count/{count}/page/{page}")
	Observable<GankISearchItemEntity> getSearch(@Path("query") String query,
																							@Path("category") String category,
																							@Path("count") int num, @Path("page") int page);
}
