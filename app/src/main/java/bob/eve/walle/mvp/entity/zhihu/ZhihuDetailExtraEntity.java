/*
 * Create by BobEve on 17-12-18 上午10:50
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午9:52
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bob on 17/12/18.
 */
public class ZhihuDetailExtraEntity {

	/**
	 * long_comments : 0
	 * popularity : 161
	 * short_comments : 19
	 * comments : 19
	 */

	@SerializedName("long_comments")
	private int long_comments;
	@SerializedName("popularity")
	private int popularity;
	@SerializedName("short_comments")
	private int short_comments;
	@SerializedName("comments")
	private int comments;

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
}
