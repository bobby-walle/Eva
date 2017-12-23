/*
 * Create by BobEve on 17-12-18 上午11:49
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:17
 */

package bob.eve.walle.mvp.cache;

import bob.eve.walle.mvp.entity.zhihu.ZhihuCommentEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuDetailEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuDetailExtraEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuHotsEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuLatestsEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuSectionListEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuSectionsEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuThemeListEntity;
import bob.eve.walle.mvp.entity.zhihu.ZhihuThemesEntity;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bob on 17/12/18.
 */

public interface ZhihuPagerCacheService {
	/**
	 * 主题日报
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuThemesEntity>> getThemes(Observable<ZhihuThemesEntity> provices,
																								 DynamicKey dk, EvictProvider ep);

	/**
	 * 主题日报详情
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuThemeListEntity>> getThemeList(Observable<ZhihuThemeListEntity> provices,
																											 DynamicKey dk, EvictProvider ep);

	/**
	 * 专栏日报
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuSectionsEntity>> getSections(Observable<ZhihuSectionsEntity> provices,
																										 DynamicKey dk, EvictProvider ep);

	/**
	 * 专栏日报详情
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuSectionListEntity>> getSectionList(
			Observable<ZhihuSectionListEntity> provices, DynamicKey dk, EvictProvider ep);

	/**
	 * 热门日报
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuHotsEntity>> getHots(Observable<ZhihuHotsEntity> provices, DynamicKey dk,
																						 EvictProvider ep);

	/**
	 * 最新日报
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuLatestsEntity>> getLatests(Observable<ZhihuLatestsEntity> provices,
																									 DynamicKey dk, EvictProvider ep);

	/**
	 * 日报详情
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuDetailEntity>> getDetail(Observable<ZhihuDetailEntity> provices,
																								 DynamicKey dk, EvictProvider ep);

	/**
	 * 日报的额外信息
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuDetailExtraEntity>> getDetailExtra(
			Observable<ZhihuDetailExtraEntity> provices, DynamicKey dk, EvictProvider ep);

	/**
	 * 日报的长评论
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuCommentEntity>> getLongComments(Observable<ZhihuCommentEntity> provices,
																												DynamicKey dk, EvictProvider ep);

	/**
	 * 日报的短评论
	 */
	@LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
	Observable<Reply<ZhihuCommentEntity>> getShortComments(Observable<ZhihuCommentEntity> provices,
																												 DynamicKey dk, EvictProvider ep);
}
