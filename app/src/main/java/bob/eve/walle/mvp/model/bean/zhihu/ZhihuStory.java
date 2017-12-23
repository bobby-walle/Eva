/*
 * Create by BobEve on 17-12-18 上午11:38
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:38
 */

package bob.eve.walle.mvp.model.bean.zhihu;

import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuStory {
	/**
	 * images : ["https://pic4.zhimg.com/v2-c018792e2c5aa68205ac3d50eb5a02fb.jpg"]
	 * date : 20171217
	 * display_date : 12 月 17 日
	 * id : 9661453
	 * title : 女人啊，你可以选择不结婚
	 * multipic : true
	 */

	private String date;
	private String displayDate;
	private int id;
	private String title;
	private boolean multipic;
	private List<String> images;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isMultipic() {
		return multipic;
	}

	public void setMultipic(boolean multipic) {
		this.multipic = multipic;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
}
