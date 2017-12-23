/*
 * Create by BobEve on 17-12-19 上午10:09
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午10:09
 */

package bob.eve.walle.mvp.model.gank;

/**
 * Created by Bob on 17/12/19.
 */

public interface GankCategoryType {
	/**
	 * category: all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
	 */

	String GANK_CATEGORY_ALL = "all";
	int GANK_CATEGORY_ALL_TYPE = 1;

	String GANK_CATEGORY_MOVIE = "休息视频";
	int GANK_CATEGORY_MOVIE_TYPE = 4;

	String GANK_CATEGORY_GIRLS = "福利";
	int GANK_CATEGORY_GIRLS_TYPE = 5;

	String GANK_CATEGORY_RECOMMEND = "瞎推荐";
	int GANK_CATEGORY_RECOMMEND_TYPE = 8;

	String GANK_CATEGORY_APP = "App";
	int GANK_CATEGORY_APP_TYPE = 9;
}
