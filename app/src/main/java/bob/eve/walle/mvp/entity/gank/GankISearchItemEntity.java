/*
 * Create by BobEve on 17-12-18 下午10:42
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午10:42
 */

package bob.eve.walle.mvp.entity.gank;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class GankISearchItemEntity {

	/**
	 * count : 10
	 * error : false
	 * results : [{"desc":"还在用ListView？","ganhuo_id":"57334c9d67765903fb61c418","publishedAt":"2016-05-12T12:04:43.857000","readability":"","type":"Android","url":"http://www.jianshu.com/p/a92955be0a3e","who":"陈宇明"},{"desc":"listview的折叠效果","ganhuo_id":"56cc6d1d421aa95caa7076fa","publishedAt":"2015-07-17T03:43:22.395000","readability":"","type":"Android","url":"https://github.com/dodola/ListItemFold","who":"Jason"},{"desc":"Android
	 * Data Binding Adapter for ListView and RecyclerView.","ganhuo_id":"56cc6d23421aa95caa707ac9","publishedAt":"2015-07-21T04:10:11.904000","readability":"","type":"Android","url":"https://github.com/evant/binding-collection-adapter","who":"mthli"},{"desc":"在ListView中实现日历视图","ganhuo_id":"573d2a896776591c9fd0cd77","publishedAt":"2016-05-19T12:09:29.617000","readability":"","type":"Android","url":"https://github.com/traex/CalendarListview","who":"大熊"},{"desc":"给scrollview、listview、recycleview添加header与footer","ganhuo_id":"56cc6d23421aa95caa707ab2","publishedAt":"2015-07-02T03:50:48.024000","readability":"","type":"Android","url":"https://github.com/lawloretienne/QuickReturn","who":"Jason"},{"desc":"过滤出多重选择的ListView","ganhuo_id":"56cc6d23421aa95caa707be6","publishedAt":"2015-08-10T04:09:39.936000","readability":"","type":"Android","url":"https://github.com/pchauhan/FilterSelectorListView","who":"Jason"},{"desc":"YLListView仿IOS弹簧效果的ListView","ganhuo_id":"56cc6d29421aa95caa70827e","publishedAt":"2016-02-29T12:19:00.015000","readability":"","type":"Android","url":"https://github.com/yll2wcf/YLListView","who":"Jason"},{"desc":"滑动listview的顶部菜单动画效果","ganhuo_id":"56cc6d26421aa95caa707d66","publishedAt":"2015-09-25T03:35:19.842000","readability":"","type":"Android","url":"https://github.com/xuechinahb/AnimatorMenu","who":"Jason"},{"desc":"一个滋瓷
	 * Android RecyclerView, ListView, GridView, ScrollView ...的scroll","ganhuo_id":"56cc6d26421aa95caa707fa2","publishedAt":"2015-12-10T04:13:03.804000","readability":"","type":"Android","url":"https://github.com/EverythingMe/overscroll-decor","who":"有时放纵"},{"desc":"下拉刷新上拉加载更多
	 * 支持listview recyclerview gridview","ganhuo_id":"56cc6d29421aa95caa708172","publishedAt":"2016-01-15T04:30:14.281000","readability":"","type":"Android","url":"https://github.com/Chanven/CommonPullToRefresh","who":"Jason"}]
	 */

	@SerializedName("count")
	private int count;
	@SerializedName("error")
	private boolean error;
	@SerializedName("results")
	private List<ResultsBean> results;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<ResultsBean> getResults() {
		return results;
	}

	public void setResults(List<ResultsBean> results) {
		this.results = results;
	}

	public static class ResultsBean {
		/**
		 * desc : 还在用ListView？
		 * ganhuo_id : 57334c9d67765903fb61c418
		 * publishedAt : 2016-05-12T12:04:43.857000
		 * readability :
		 * type : Android
		 * url : http://www.jianshu.com/p/a92955be0a3e
		 * who : 陈宇明
		 */

		@SerializedName("desc")
		private String desc;
		@SerializedName("ganhuo_id")
		private String ganhuoId;
		@SerializedName("publishedAt")
		private String publishedAt;
		@SerializedName("readability")
		private String readability;
		@SerializedName("type")
		private String type;
		@SerializedName("url")
		private String url;
		@SerializedName("who")
		private String who;

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getGanhuoId() {
			return ganhuoId;
		}

		public void setGanhuoId(String ganhuoId) {
			this.ganhuoId = ganhuoId;
		}

		public String getPublishedAt() {
			return publishedAt;
		}

		public void setPublishedAt(String publishedAt) {
			this.publishedAt = publishedAt;
		}

		public String getReadability() {
			return readability;
		}

		public void setReadability(String readability) {
			this.readability = readability;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getWho() {
			return who;
		}

		public void setWho(String who) {
			this.who = who;
		}
	}
}
