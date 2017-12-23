/*
 * Create by BobEve on 17-12-18 下午10:41
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午10:41
 */

package bob.eve.walle.mvp.entity.gank;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class GankItemEntity {

	/**
	 * error : false
	 * results : [{"_id":"5a2e4011421aa90fe2f02cd1","createdAt":"2017-12-11T16:21:37.459Z","desc":"我打赌你一定没搞明白的Activity启动模式","publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488588&idx=1&sn=3f7c59654835ec8d560610ba97d10fc0","used":true,"who":"陈宇明"},{"_id":"5a2e6a38421aa90fe72536b0","createdAt":"2017-12-11T19:21:28.577Z","desc":"safe
	 * adb：在多设备时更方便地操作 adb，支持批量操作。","images":["http://img.gank.io/27c7d4a1-9c3e-42ed-9a21-051cd9f77798"],"publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"https://github.com/linroid/sadb","used":true,"who":"drakeet"},{"_id":"5a2e80d4421aa90fe50c0272","createdAt":"2017-12-11T20:57:56.667Z","desc":"图解ConcurretHashMap","images":["http://img.gank.io/d00aec87-7573-45a0-87bc-f3046ad442d4"],"publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"http://rkhcy.github.io/2017/12/06/%E5%9B%BE%E8%A7%A3ConcurrentHashMap/","used":true,"who":"HuYounger"},{"_id":"5a2e9564421aa90fef203598","createdAt":"2017-12-11T22:25:40.242Z","desc":"Kotlin
	 * 实现的 View to View 动画效果库。","images":["http://img.gank.io/646d55a5-6dc8-460b-94f0-8d4fbe0499e7"],"publishedAt":"2017-12-15T08:59:11.361Z","source":"chrome","type":"Android","url":"https://github.com/dev-labs-bg/transitioner","used":true,"who":"代码家"},{"_id":"5a306479421aa90fe2f02cd4","createdAt":"2017-12-13T07:21:29.919Z","desc":"深入简出
	 * RxJava","publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"https://zhuanlan.zhihu.com/p/31955751","used":true,"who":"nekocode"},{"_id":"5a30a14b421aa90fe72536b6","createdAt":"2017-12-13T11:40:59.217Z","desc":"Understanding
	 * Types Of Observables In RxJava","publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"https://blog.mindorks.com/understanding-types-of-observables-in-rxjava-6c3a2d0819c8","used":true,"who":"AMIT
	 * SHEKHAR"},{"_id":"5a30a450421aa90fe50c0277","createdAt":"2017-12-13T11:53:52.581Z","desc":"彻底搞懂Java内存泄露","publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s/hw5d0FJXzaDZPN-vRPzjSA","used":true,"who":"D_clock"},{"_id":"5a31fdb4421aa90fe50c027d","createdAt":"2017-12-14T12:27:32.891Z","desc":"改造
	 * Android 官方架构组件 ViewModel","images":["http://img.gank.io/c3147192-be3c-4080-9347-bff52a41c086"],"publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"https://github.com/JessYanCoding/LifecycleModel","used":true,"who":"jess"},{"_id":"5a289393421aa90fe2f02cbb","createdAt":"2017-12-07T09:04:19.514Z","desc":"一篇文章告诉你FFmpeg环境的搭建和编译","publishedAt":"2017-12-11T08:43:39.682Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=100001398&idx=1&sn=e2f10368a6146669b483c249e13b3fee&chksm=6b476ae85c30e3fe509ec489028d071c199de24a0660e047b87980ef5ba0f216e7d69893f8a8#rd","used":true,"who":"codeGoogler"},{"_id":"5a2b5b1d421aa90fe50c026d","createdAt":"2017-12-09T11:40:13.338Z","desc":"ToastCompat:
	 * An Android library to HOOK and FIX Toast BadTokenException","images":["http://img.gank.io/31bc3e71-69ea-48ad-b282-2ea34b57bde2"],"publishedAt":"2017-12-11T08:43:39.682Z","source":"web","type":"Android","url":"https://github.com/drakeet/ToastCompat","used":true,"who":"drakeet"}]
	 */

	@SerializedName("error")
	private boolean error;
	@SerializedName("results")
	private List<ResultsBean> results;

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
		 * _id : 5a2e4011421aa90fe2f02cd1
		 * createdAt : 2017-12-11T16:21:37.459Z
		 * desc : 我打赌你一定没搞明白的Activity启动模式
		 * publishedAt : 2017-12-15T08:59:11.361Z
		 * source : web
		 * type : Android
		 * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488588&idx=1&sn=3f7c59654835ec8d560610ba97d10fc0
		 * used : true
		 * who : 陈宇明
		 * images : ["http://img.gank.io/27c7d4a1-9c3e-42ed-9a21-051cd9f77798"]
		 */

		@SerializedName("_id")
		private String id;
		@SerializedName("createdAt")
		private String createdAt;
		@SerializedName("desc")
		private String desc;
		@SerializedName("publishedAt")
		private String publishedAt;
		@SerializedName("source")
		private String source;
		@SerializedName("type")
		private String type;
		@SerializedName("url")
		private String url;
		@SerializedName("used")
		private boolean used;
		@SerializedName("who")
		private String who;
		@SerializedName("images")
		private List<String> images;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getPublishedAt() {
			return publishedAt;
		}

		public void setPublishedAt(String publishedAt) {
			this.publishedAt = publishedAt;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
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

		public boolean isUsed() {
			return used;
		}

		public void setUsed(boolean used) {
			this.used = used;
		}

		public String getWho() {
			return who;
		}

		public void setWho(String who) {
			this.who = who;
		}

		public List<String> getImages() {
			return images;
		}

		public void setImages(List<String> images) {
			this.images = images;
		}
	}
}
