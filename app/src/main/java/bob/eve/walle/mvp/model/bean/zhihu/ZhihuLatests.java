/*
 * Create by BobEve on 17-12-18 上午11:43
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:43
 */

package bob.eve.walle.mvp.model.bean.zhihu;

import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuLatests {
	private String date;
	private List<ZhihuStory> stories;
	private List<ZhihuStory> topStories;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<ZhihuStory> getStories() {
		return stories;
	}

	public void setStories(List<ZhihuStory> stories) {
		this.stories = stories;
	}

	public List<ZhihuStory> getTopStories() {
		return topStories;
	}

	public void setTopStories(List<ZhihuStory> topStories) {
		this.topStories = topStories;
	}

	@Override
	public String toString() {
		return "ZhihuLatests{" + "date='" + date + '\'' + ", stories=" + stories + ", topStories=" +
					 topStories + '}';
	}
}
