/*
 * Create by BobEve on 17-12-18 上午11:42
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:42
 */

package bob.eve.walle.mvp.model.bean.zhihu;

import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuSectionList {
	private int timestamp;
	private String name;
	private List<ZhihuStory> stories;

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ZhihuStory> getStories() {
		return stories;
	}

	public void setStories(List<ZhihuStory> stories) {
		this.stories = stories;
	}

	@Override
	public String toString() {
		return "ZhihuSectionList{" + "timestamp=" + timestamp + ", name='" + name + '\'' +
					 ", stories=" + stories + '}';
	}
}
