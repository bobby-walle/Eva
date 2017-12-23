/*
 * Create by BobEve on 17-12-18 上午11:05
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:05
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuLatestsEntity {

	/**
	 * date : 20171218
	 * stories : [{"images":["https://pic3.zhimg.com/v2-acc2235bdec7da0d83f1414172c359c6.jpg"],"type":0,"id":9660803,"ga_prefix":"121810","title":"几个现象要是出现在你的公司，你可能得考虑一下离职了"},{"images":["https://pic4.zhimg.com/v2-50fa39d2edd1403080f691acfc1edd6b.jpg"],"type":0,"id":9661207,"ga_prefix":"121809","title":"中国人为什么越来越不爱吃方便面了？"},{"images":["https://pic4.zhimg.com/v2-9973f8474ad1b690358d9b21818ebb6b.jpg"],"type":0,"id":9661206,"ga_prefix":"121808","title":"找手机、找钥匙、找公交卡\u2026\u2026这期间大脑里发生了什么？"},{"images":["https://pic4.zhimg.com/v2-d740c97ef23b171ac1c5f2dc3befe877.jpg"],"type":0,"id":9661512,"ga_prefix":"121807","title":"从 2014 年开始掀起的中国电动车创业浪潮，终于有人交出了第一份作品"},{"title":"「演员诞生」的背后，是当代中国演员图鉴","ga_prefix":"121807","images":["https://pic1.zhimg.com/v2-7207f45a331827409ef077f429cc36a8.jpg"],"multipic":true,"type":0,"id":9661490},{"images":["https://pic1.zhimg.com/v2-7342b1b060b9bb07237c3e3a3284e67c.jpg"],"type":0,"id":9661164,"ga_prefix":"121807","title":"为什么上一辈人很喜欢在桌上垫一层玻璃，下面压几张照片？"},{"images":["https://pic2.zhimg.com/v2-f3f011929eb585ddab506b37c4de00dd.jpg"],"type":0,"id":9661439,"ga_prefix":"121806","title":"瞎扯 · 如何正确地吐槽"}]
	 * top_stories : [{"image":"https://pic1.zhimg.com/v2-244f8abd7069297d7809dd14e8d1af3c.jpg","type":0,"id":9661512,"ga_prefix":"121807","title":"从 2014 年开始掀起的中国电动车创业浪潮，终于有人交出了第一份作品"},{"image":"https://pic1.zhimg.com/v2-f0deae119d8ab1a77694e71f84568894.jpg","type":0,"id":9661490,"ga_prefix":"121807","title":"「演员诞生」的背后，是当代中国演员图鉴"},{"image":"https://pic4.zhimg.com/v2-946ffb65105e3b2184ff738f03aadf37.jpg","type":0,"id":9661358,"ga_prefix":"121715","title":"没发生什么，但生活的琐碎已经快让我没力气了"},{"image":"https://pic3.zhimg.com/v2-dc8630452231602c2957d7bddb888a06.jpg","type":0,"id":9661323,"ga_prefix":"121617","title":"《芳华》是冯小刚继《我不是潘金莲》之后，又一部带着强烈作者风格的电影"},{"image":"https://pic2.zhimg.com/v2-86e87f66fc24c8b889ddf098d7526d35.jpg","type":0,"id":9661306,"ga_prefix":"121708","title":"本周热门精选 · 带着身份行走"}]
	 */

	@SerializedName("date")
	private String date;
	@SerializedName("stories")
	private List<StoriesBean> stories;
	@SerializedName("top_stories")
	private List<TopStoriesBean> topStories;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<StoriesBean> getStories() {
		return stories;
	}

	public void setStories(List<StoriesBean> stories) {
		this.stories = stories;
	}

	public List<TopStoriesBean> getTopStories() {
		return topStories;
	}

	public void setTopStories(List<TopStoriesBean> topStories) {
		this.topStories = topStories;
	}

	public static class StoriesBean {
		/**
		 * images : ["https://pic3.zhimg.com/v2-acc2235bdec7da0d83f1414172c359c6.jpg"]
		 * type : 0
		 * id : 9660803
		 * ga_prefix : 121810
		 * title : 几个现象要是出现在你的公司，你可能得考虑一下离职了
		 * multipic : true
		 */

		@SerializedName("type")
		private int type;
		@SerializedName("id")
		private int id;
		@SerializedName("ga_prefix")
		private String gaPrefix;
		@SerializedName("title")
		private String title;
		@SerializedName("multipic")
		private boolean multipic;
		@SerializedName("images")
		private List<String> images;

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
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

	public static class TopStoriesBean {
		/**
		 * image : https://pic1.zhimg.com/v2-244f8abd7069297d7809dd14e8d1af3c.jpg
		 * type : 0
		 * id : 9661512
		 * ga_prefix : 121807
		 * title : 从 2014 年开始掀起的中国电动车创业浪潮，终于有人交出了第一份作品
		 */

		@SerializedName("image")
		private String image;
		@SerializedName("type")
		private int type;
		@SerializedName("id")
		private int id;
		@SerializedName("ga_prefix")
		private String gaPrefix;
		@SerializedName("title")
		private String title;

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}
