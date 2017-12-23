/*
 * Create by BobEve on 17-12-18 上午11:45
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:45
 */

package bob.eve.walle.mvp.model.bean.zhihu;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuHot {
	private int newsId;
	private String url;
	private String thumbnail;
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

	@Override
	public String toString() {
		return "ZhihuNews{" + "newsId=" + newsId + ", url='" + url + '\'' + ", thumbnail='" +
					 thumbnail + '\'' + ", title='" + title + '\'' + '}';
	}
}
