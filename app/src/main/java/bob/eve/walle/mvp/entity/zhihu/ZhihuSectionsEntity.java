/*
 * Create by BobEve on 17-12-18 上午11:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:01
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuSectionsEntity {

	@SerializedName("data")
	private List<DataBean> data;

	public List<DataBean> getData() {
		return data;
	}

	public void setData(List<DataBean> data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * description : 看别人的经历，理解自己的生活
		 * id : 1
		 * name : 深夜惊奇
		 * thumbnail : http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg
		 */

		@SerializedName("description")
		private String description;
		@SerializedName("id")
		private int id;
		@SerializedName("name")
		private String name;
		@SerializedName("thumbnail")
		private String thumbnail;

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

		public String getThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}
	}
}
