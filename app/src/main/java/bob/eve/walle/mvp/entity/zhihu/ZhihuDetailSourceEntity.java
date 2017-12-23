/*
 * Create by BobEve on 17-12-18 上午10:47
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午10:47
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bob on 17/12/18.
 *
 * 当前知乎页面来源信息，比如主题 or 专栏
 */

public class ZhihuDetailSourceEntity {
	/**
	 * "thumbnail": "http://pic3.zhimg.com/00eba01080138a5ac861d581a64ff9bd.jpg",
	 * "id": 3,
	 * "name": "电影日报"
	 */

	@SerializedName("thumbnail")
	private String thumbnail;
	@SerializedName("name")
	private String name;
	@SerializedName("id")
	private int id;

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
