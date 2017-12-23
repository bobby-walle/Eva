/*
 * Create by BobEve on 17-12-18 下午12:04
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午12:04
 */

package bob.eve.walle.mvp.model.bean.zhihu;

import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuDetail {
	private String imageSource;
	private String title;
	private String image;
	private String shareUrl;
	private int id;
	private String gaPrefix;
	private int type;
	private List<String> images;

	private String body;
	private List<String> js;
	private List<String> css;

	private int long_comments;
	private int popularity;
	private int short_comments;
	private int comments;

	/* 详情页来源，可能没有 */
	private String sourceThumbnail;
	private String sourceName;
	private int sourceId;

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGaPrefix() {
		return gaPrefix;
	}

	public void setGaPrefix(String gaPrefix) {
		this.gaPrefix = gaPrefix;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getJs() {
		return js;
	}

	public void setJs(List<String> js) {
		this.js = js;
	}

	public List<String> getCss() {
		return css;
	}

	public void setCss(List<String> css) {
		this.css = css;
	}

	public int getLong_comments() {
		return long_comments;
	}

	public void setLong_comments(int long_comments) {
		this.long_comments = long_comments;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getShort_comments() {
		return short_comments;
	}

	public void setShort_comments(int short_comments) {
		this.short_comments = short_comments;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getSourceThumbnail() {
		return sourceThumbnail;
	}

	public void setSourceThumbnail(String sourceThumbnail) {
		this.sourceThumbnail = sourceThumbnail;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	@Override
	public String toString() {
		return "ZhihuDetail{" + "imageSource='" + imageSource + '\'' + ", title='" + title + '\'' +
					 ", image='" + image + '\'' + ", shareUrl='" + shareUrl + '\'' + ", id=" + id +
					 ", gaPrefix='" + gaPrefix + '\'' + ", type=" + type + ", images=" + images + ", body='" +
					 body + '\'' + ", js=" + js + ", css=" + css + ", long_comments=" + long_comments +
					 ", popularity=" + popularity + ", short_comments=" + short_comments + ", comments=" +
					 comments + ", sourceThumbnail='" + sourceThumbnail + '\'' + ", sourceName='" +
					 sourceName + '\'' + ", sourceId=" + sourceId + '}';
	}
}
