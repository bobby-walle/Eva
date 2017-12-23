/*
 * Create by BobEve on 17-12-18 上午11:04
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:04
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuHotsEntity {

	@SerializedName("recent")
	private List<RecentBean> recent;

	public List<RecentBean> getRecent() {
		return recent;
	}

	public void setRecent(List<RecentBean> recent) {
		this.recent = recent;
	}

	public static class RecentBean {
		/**
		 * news_id : 9661007
		 * url : http://news-at.zhihu.com/api/2/news/9661007
		 * thumbnail : https://pic2.zhimg.com/v2-8ea13abd6586dc98c9384bf138afef55.jpg
		 * title : 瞎扯 · 如何正确地吐槽
		 */

		@SerializedName("news_id")
		private int newsId;
		@SerializedName("url")
		private String url;
		@SerializedName("thumbnail")
		private String thumbnail;
		@SerializedName("title")
		private String title;

		public int getNewsId() {
			return newsId;
		}

		public void setNewsId(int newsId) {
			this.newsId = newsId;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}
