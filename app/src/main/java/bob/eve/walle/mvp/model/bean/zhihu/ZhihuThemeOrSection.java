/*
 * Create by BobEve on 17-12-18 上午11:23
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:23
 */

package bob.eve.walle.mvp.model.bean.zhihu;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuThemeOrSection {
	/**
	 * color : 15007
	 * thumbnail : http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg
	 * description : 了解自己和别人，了解彼此的欲望和局限。
	 * id : 13
	 * name : 日常心理学
	 */

	private int color;
	private String thumbnail;
	private String description;
	private int id;
	private String name;

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ZhihuTheme{" + "color=" + color + ", thumbnail='" + thumbnail + '\'' +
					 ", description='" + description + '\'' + ", id=" + id + ", name='" + name + '\'' + '}';
	}
}
