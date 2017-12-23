/*
 * Create by BobEve on 17-12-18 上午11:40
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:40
 */

package bob.eve.walle.mvp.model.bean.zhihu;

import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuThemeList {
	private String description;
	private String background;
	private int color;
	private String name;
	private String image;
	private String imageSource;
	private List<ZhihuStory> stories;
	private List<ZhihuEditor> editors;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public List<ZhihuStory> getStories() {
		return stories;
	}

	public void setStories(List<ZhihuStory> stories) {
		this.stories = stories;
	}

	public List<ZhihuEditor> getEditors() {
		return editors;
	}

	public void setEditors(List<ZhihuEditor> editors) {
		this.editors = editors;
	}

	@Override
	public String toString() {
		return "ZhihuThemeList{" + "description='" + description + '\'' + ", background='" +
					 background + '\'' + ", color=" + color + ", name='" + name + '\'' + ", image='" + image +
					 '\'' + ", imageSource='" + imageSource + '\'' + ", stories=" + stories + ", editors=" +
					 editors + '}';
	}
}
