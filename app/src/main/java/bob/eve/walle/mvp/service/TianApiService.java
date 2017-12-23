/*
 * Create by BobEve on 17-12-18 下午11:06
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午11:06
 */

package bob.eve.walle.mvp.service;

import bob.eve.walle.mvp.entity.tian.TianGirlEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bob on 17/12/18.
 */

public interface TianApiService {
	// http://api.tianapi.com/meinv/?key=APIKEY&num=10

	@GET("http://api.tianapi.com/meinv/")
	Observable<TianGirlEntity> getTianGirls(@Query("key") String key, @Query("num") int num,
																					@Query("page") int page);
}
