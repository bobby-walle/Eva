/*
 * Create by BobEve on 17-12-18 下午11:23
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午11:23
 */

package bob.eve.walle.mvp.service;

import bob.eve.walle.mvp.entity.douban.MovieSearchEntity;
import bob.eve.walle.mvp.entity.douban.Top250Entity;
import bob.eve.walle.mvp.entity.douban.USBoxEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bob on 17/12/18.
 */

public interface DouEveService {
	// https://api.douban.com/v2/movie/search?q=周星驰&tag=战争

	/**
	 * 电影条目搜索
	 *
	 * /v2/movie/search?q={text}
	 *
	 * eg.GET /v2/movie/search?q=张艺谋 GET /v2/movie/search?tag=喜剧
	 *
	 * params
	 * q	query string	str	Y	Y	Y	-
	 * tag	tag query string	str	Y	Y	Y	-
	 * start	start	int	Y	Y	Y	0
	 * count	count	int	Y	Y	Y	20
	 */

	@GET("https://api.douban.com/v2/movie/search")
	Observable<MovieSearchEntity> searchMovieFromDouban(@Query("q") String q,
																											@Query("tag") String tag,
																											@Query("start") int start,
																											@Query("count") int count);

	/**
	 * Top250
	 *
	 * /v2/movie/top250
	 *
	 * params
	 * start	start	int	Y	Y	N/A	0
	 * count	count	int	Y	Y	N/A	10
	 */
	@GET("https://api.douban.com/v2/movie/top250")
	Observable<Top250Entity> getTop250Movies(@Query("start") int start);

	/**
	 * 北美票房榜
	 *
	 * /v2/movie/us_box
	 */
	@GET("https://api.douban.com/v2/movie/us_box")
	Observable<USBoxEntity> getUSBox();
}
