/*
 * Create by BobEve on 17-12-18 上午11:02
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:02
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuSectionListEntity {

	/**
	 * timestamp : 1511874000
	 * stories : [{"images":["https://pic4.zhimg.com/v2-c018792e2c5aa68205ac3d50eb5a02fb.jpg"],"date":"20171217","display_date":"12
	 * 月 17 日","id":9661453,"title":"女人啊，你可以选择不结婚"},{"images":["https://pic3.zhimg.com/v2-39a7264bc4b267591d28b52e54161372.jpg"],"date":"20171216","display_date":"12
	 * 月 16 日","id":9661313,"title":"一个业余电影爱好者对反复观看一部电影的总结和感悟"},{"display_date":"12 月 15
	 * 日","title":"《镜花缘》背后的故事","date":"20171215","images":["https://pic4.zhimg.com/v2-703af9c169ce76d897e37f3c706d152f.jpg"],"multipic":true,"id":9661196},{"images":["https://pic4.zhimg.com/v2-c4998389f13f520442a09ce092603c73.jpg"],"date":"20171214","display_date":"12
	 * 月 14 日","id":9661088,"title":"铁齿铜牙两片嘴，百姓心中有了你"},{"images":["https://pic4.zhimg.com/v2-7fe87765e55003fde73f1eafdf394407.jpg"],"date":"20171213","display_date":"12
	 * 月 13 日","id":9660990,"title":"当年我也曾想活成「钟跃民」的样子"},{"images":["https://pic2.zhimg.com/v2-c9e562148be172e8053e4c8e88a99655.jpg"],"date":"20171212","display_date":"12
	 * 月 12 日","id":9660792,"title":"舞蹈、游泳、雕塑、湖水；\r\n肉体、亲密、禁忌、荷尔蒙"},{"images":["https://pic1.zhimg.com/v2-d3c5065ad702abb82548ff119ae8de84.jpg"],"date":"20171211","display_date":"12
	 * 月 11 日","id":9660655,"title":"工作日下午 3 点的出轨"},{"display_date":"12 月 10
	 * 日","title":"何止少儿不宜，连成人看了都脊背发凉","date":"20171210","images":["https://pic2.zhimg.com/v2-6c54635031f6844a9c65b526dd010009.jpg"],"multipic":true,"id":9660454},{"images":["https://pic3.zhimg.com/v2-e10ac100f2a0775329391f1f2be3aaea.jpg"],"date":"20171209","display_date":"12
	 * 月 9 日","id":9660401,"title":"《武林外传》中为什么白展堂没有和郭芙蓉在一起？"},{"images":["https://pic3.zhimg.com/v2-6649b707f2ef5f9131b0f5108ce26986.jpg"],"date":"20171208","display_date":"12
	 * 月 8 日","id":9660226,"title":"HBO 最长寿的电视剧，却因看过的人数过少不足显示评分"},{"images":["https://pic1.zhimg.com/v2-7fd3883b3597c4e9aaac7a712b0088c4.jpg"],"date":"20171207","display_date":"12
	 * 月 7 日","id":9659984,"title":"90 年代出生的你，还记得这部动画吗？"},{"display_date":"12 月 6
	 * 日","title":"喜欢什么就去干什么，真的适合所有人吗？","date":"20171206","images":["https://pic3.zhimg.com/v2-7445f7b4e7850985cc54655991ccaf7a.jpg"],"multipic":true,"id":9660068},{"display_date":"12
	 * 月 5 日","title":"这是一张能带你回到过去的国产电影清单","date":"20171205","images":["https://pic3.zhimg.com/v2-088c272188c79c890422f7c896153e62.jpg"],"multipic":true,"id":9659863},{"images":["https://pic3.zhimg.com/v2-2031fc4ebcda5f6fd93edda9aee89766.jpg"],"date":"20171204","display_date":"12
	 * 月 4 日","id":9659584,"title":"二十年过去，真正打动人的还是青春"},{"images":["https://pic2.zhimg.com/v2-5ef5dbe8981a163c72362306028ee0cd.jpg"],"date":"20171203","display_date":"12
	 * 月 3 日","id":9659481,"title":"我一直认为昆丁是最让人折服的鬼才，直到看到盖里奇这部处女作"},{"images":["https://pic2.zhimg.com/v2-305ca7e00ee13320df9f57cc33ba4019.jpg"],"date":"20171202","display_date":"12
	 * 月 2 日","id":9659393,"title":"他是人间罕见的天才美少年"},{"display_date":"12 月 1 日","title":"1998
	 * 年的《花木兰》，是迪士尼第一次讲好中国故事","date":"20171201","images":["https://pic1.zhimg.com/v2-fddc06048baac2f671eb651840954818.jpg"],"multipic":true,"id":9659285},{"images":["https://pic4.zhimg.com/v2-e2d348f4458ed44e7377fa1b2ace017b.jpg"],"date":"20171130","display_date":"11
	 * 月 30 日","id":9659189,"title":"一弯新月，一丛冷峰，一片雪地，一滩鲜血，一具女尸"},{"display_date":"11 月 29
	 * 日","title":"88 个钢琴键与无限的可能","date":"20171129","images":["https://pic2.zhimg.com/v2-417d7f4f9ef84ccc2f9e98ed0e60a501.jpg"],"multipic":true,"id":9659055},{"display_date":"11
	 * 月 28 日","title":"我多次开玩笑说，这个世界上不存在他没拍过的故事","date":"20171128","images":["https://pic3.zhimg.com/v2-2b5d7c5d1563bdd0fab7c85bc61b2cee.jpg"],"multipic":true,"id":9658893}]
	 * name : 放映机
	 */

	@SerializedName("timestamp")
	private int timestamp;
	@SerializedName("name")
	private String name;
	@SerializedName("stories")
	private List<StoriesBean> stories;

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

	public List<StoriesBean> getStories() {
		return stories;
	}

	public void setStories(List<StoriesBean> stories) {
		this.stories = stories;
	}

	public static class StoriesBean {
		/**
		 * images : ["https://pic4.zhimg.com/v2-c018792e2c5aa68205ac3d50eb5a02fb.jpg"]
		 * date : 20171217
		 * display_date : 12 月 17 日
		 * id : 9661453
		 * title : 女人啊，你可以选择不结婚
		 * multipic : true
		 */

		@SerializedName("date")
		private String date;
		@SerializedName("display_date")
		private String displayDate;
		@SerializedName("id")
		private int id;
		@SerializedName("title")
		private String title;
		@SerializedName("multipic")
		private boolean multipic;
		@SerializedName("images")
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
}
