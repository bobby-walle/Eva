/*
 * Create by BobEve on 17-12-18 上午10:22
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午10:22
 */

package bob.eve.walle.mvp.service;

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
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Bob on 17/12/18.
 */

public interface ZhihuPagerService {
	String HOST = "http://news-at.zhihu.com/api/4/";

	/**
	 * 主题
	 */
	@GET("http://news-at.zhihu.com/api/4/themes")
	Observable<ZhihuThemesEntity> getThemes();

	/**
	 * 主题详情
	 */
	@GET("http://news-at.zhihu.com/api/4/theme/{id}")
	Observable<ZhihuThemeListEntity> getThemeList(@Path("id") int id);

	/**
	 * 专栏
	 */
	@GET("http://news-at.zhihu.com/api/4/sections")
	Observable<ZhihuSectionsEntity> getSections();

	/**
	 * 专栏详情
	 */
	@GET("http://news-at.zhihu.com/api/4/section/{id}")
	Observable<ZhihuSectionListEntity> getSectionList(@Path("id") int id);

	/**
	 * 热门
	 */
	@GET("http://news-at.zhihu.com/api/4/news/hot")
	Observable<ZhihuHotsEntity> getHots();

	/**
	 * 最新
	 */
	@GET("http://news-at.zhihu.com/api/4/news/latest")
	Observable<ZhihuLatestsEntity> getLatests();

	/**
	 * 日报详情
	 */
	@GET("http://news-at.zhihu.com/api/4/news/{id}")
	Observable<ZhihuDetailEntity> getDetail(@Path("id") int id);

	/**
	 * 日报的额外信息
	 */
	@GET("http://news-at.zhihu.com/api/4/story-extra/{id}")
	Observable<ZhihuDetailExtraEntity> getDetailExtra(@Path("id") int id);

	/**
	 * 日报的长评论
	 */
	@GET("http://news-at.zhihu.com/api/4/story/{id}/long-comments")
	Observable<ZhihuCommentEntity> getLongComments(@Path("id") int id);

	/**
	 * 日报的短评论
	 */
	@GET("http://news-at.zhihu.com/api/4/story/{id}/short-comments")
	Observable<ZhihuCommentEntity> getShortComments(@Path("id") int id);
}
