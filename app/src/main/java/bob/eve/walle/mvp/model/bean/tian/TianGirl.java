/*
 * Create by BobEve on 17-12-18 下午11:09
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午11:09
 */

package bob.eve.walle.mvp.model.bean.tian;

/**
 * Created by Bob on 17/12/18.
 */

public class TianGirl {
	/**
	 * ctime : 2016-03-06 14:11
	 * title : 性感黛欣霓内衣写真
	 * description : 美女图片
	 * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_4e1ed310e8b3553d266bd619949ec01c3-760x500.jpg
	 * url : http://m.xxxiao.com/435
	 */

	private String ctime;
	private String title;
	private String description;
	private String picUrl;
	private int height;

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "TianGirl{" + "ctime='" + ctime + '\'' + ", title='" + title + '\'' + ", description='" +
					 description + '\'' + ", picUrl='" + picUrl + '\'' + '}';
	}
}
