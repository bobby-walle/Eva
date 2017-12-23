/*
 * Create by BobEve on 17-12-18 下午11:06
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午11:06
 */

package bob.eve.walle.mvp.entity.tian;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class TianGirlEntity {

	/**
	 * code : 200
	 * msg : success
	 * newslist : [{"ctime":"2016-03-06 14:11","title":"性感黛欣霓内衣写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_4e1ed310e8b3553d266bd619949ec01c3-760x500.jpg","url":"http://m.xxxiao.com/435"},{"ctime":"2016-03-06
	 * 14:11","title":"巨乳杉原杏璃 Anri Sugihara 写真集 Gravure Idols &#038; Misty
	 * C","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_d458e312c6ff6ca3126749ecd922dbf6-760x500.jpg","url":"http://m.xxxiao.com/1644"},{"ctime":"2016-03-06
	 * 14:11","title":"刘雨欣美女桌面","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_2411c2dfab27e4411a27c16f4f87dd22-760x500.jpg","url":"http://m.xxxiao.com/1811"},{"ctime":"2016-03-06
	 * 14:11","title":"美女壁纸刘亦菲高清桌面","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_d6070ae4aa5f54ab6b544b5ad0c05e92-760x500.jpg","url":"http://m.xxxiao.com/1793"},{"ctime":"2016-03-06
	 * 14:11","title":"范冰冰高清壁纸图片","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_c319e31fd34fb215d17644f5b58a7734-760x500.jpg","url":"http://m.xxxiao.com/1803"},{"ctime":"2016-03-06
	 * 14:11","title":"Beautyleg &#8211; Arvi 私房美腿写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/05/m.xxxiao.com_e7e731faf790487ccaf90d11774fae6b-760x500.jpg","url":"http://m.xxxiao.com/1353"},{"ctime":"2016-03-06
	 * 14:11","title":"韩国性感车模制服展场靓丽图片","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_8000d44d92b4ea5aba46b13bd938e0e48-760x500.jpg","url":"http://m.xxxiao.com/892"},{"ctime":"2016-03-06
	 * 14:11","title":"美女泷泽萝拉性感壁纸图片","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_7b09f0aa22aff3b6cfbad8ceb9abecbb-760x500.jpg","url":"http://m.xxxiao.com/2099"},{"ctime":"2016-03-06
	 * 14:11","title":"王馨瑶性感写真壁纸","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_6bb61e3b7bce0931da574d19d1d82c884-760x500.jpg","url":"http://m.xxxiao.com/308"},{"ctime":"2016-03-06
	 * 14:11","title":"美少女韩雨嘉可爱私拍","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_1c3cc572a80ccc3343062e7ad6c51180-760x500.jpg","url":"http://m.xxxiao.com/2010"}]
	 */

	@SerializedName("code")
	private int code;
	@SerializedName("msg")
	private String msg;
	@SerializedName("newslist")
	private List<NewslistBean> newslist;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<NewslistBean> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<NewslistBean> newslist) {
		this.newslist = newslist;
	}

	public static class NewslistBean {
		/**
		 * ctime : 2016-03-06 14:11
		 * title : 性感黛欣霓内衣写真
		 * description : 美女图片
		 * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_4e1ed310e8b3553d266bd619949ec01c3-760x500.jpg
		 * url : http://m.xxxiao.com/435
		 */

		@SerializedName("ctime")
		private String ctime;
		@SerializedName("title")
		private String title;
		@SerializedName("description")
		private String description;
		@SerializedName("picUrl")
		private String picUrl;
		@SerializedName("url")
		private String url;

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

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
}
