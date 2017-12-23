/*
 * Create by BobEve on 17-12-18 上午11:00
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:00
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuThemeListEntity {

	/**
	 * stories : [{"type":0,"id":7400530,"title":"哪些电影有浓厚的建筑人文意味？"},{"images":["http://pic4.zhimg.com/e43e1f7d8dfce546c4e95e944bcfb6cb_t.jpg"],"type":2,"id":7260659,"title":"「新片」十月份，值得你走进影院的电影总会有一些"},{"images":["http://pic4.zhimg.com/d57c509391f2d2b9e50bdf6696f9b01f.jpg"],"type":1,"id":7249394,"title":"是不是发现自己除了久石让，其他的日本配乐师都不认识\u2026"},{"images":["http://pic1.zhimg.com/48e16ae19f3955bac6e5ef890102d210_t.jpg"],"type":1,"id":7242546,"title":"知道这些彩蛋，《头脑特工队》将好看10倍"},{"images":["http://pic4.zhimg.com/af00d51d888b0d086937ab92f2b51fd7_t.jpg"],"type":1,"id":7234927,"title":"玩物
	 * | 鬼族怪兽团，[九层妖塔]中的神奇动物"},{"images":["http://pic2.zhimg.com/39e607ccec165fccc29f615ffd50df31_t.jpg"],"type":2,"id":7223446,"title":"在约翰·拉塞特脑洞打开之前，台灯是个什么鬼
	 * | 这个人有好奇心"},{"images":["http://pic1.zhimg.com/af1ed9411bfd1ff122fc79356f70cc18_t.jpg"],"type":2,"id":7206605,"title":"伍迪·艾伦：他居然说自己不好奇？｜
	 * 这个人有好奇心"},{"images":["http://pic1.zhimg.com/f35563cee5bc110acee06f406fbd4bc4_t.jpg"],"type":1,"id":7175914,"title":"玩物
	 * | 女巫玛琳菲森装备，朱莉提升实力的必备神器"},{"images":["http://pic2.zhimg.com/a6d4f5405f7c1de212e450d72e87c671_t.jpg"],"type":2,"id":7125750,"title":"IMAX
	 * 中国即将在香港上市，它如何用 5 年时间成为中国电影市场上最成功的品牌？"},{"images":["http://pic3.zhimg.com/ee97f322e692070927709a3c0447c162_t.jpg"],"type":2,"id":7117948,"title":"「好莱坞报告完结篇」到底什么是好莱坞（可能）不可取代的东西？"},{"images":["http://pic2.zhimg.com/557bc559c7bfb9c702c3367be7dacaa1_t.jpg"],"type":1,"id":7122720,"title":"技术流
	 * | [杀人回忆]vs[十二宫]，两部著名真实悬案所改编电影的横向对比"},{"images":["http://pic2.zhimg.com/a6d28aa38400147aae2560bb0182882d_t.jpg"],"type":2,"id":7118025,"title":"政客上各种电视节目，你们以为真是为了公益和慈善吗？"},{"images":["http://pic3.zhimg.com/238711ae90d4f7c50945ea175bd3bbc2_t.jpg"],"type":1,"id":7111705,"title":"从电影里看苹果是如何一步步占领全球的"},{"images":["http://pic4.zhimg.com/beff8af30a763940d895baa070d8d94b_t.jpg"],"type":2,"id":7107434,"title":"「好莱坞报告四」全球化为什么害了好莱坞？"},{"images":["http://pic4.zhimg.com/144785034bf50db01efeb173a4f4a6e3_t.jpg"],"type":2,"id":7106072,"title":"「好莱坞报告五」好莱坞拱手把黄金时代让给了电视业吗？"},{"images":["http://pic2.zhimg.com/da862ce54d0fe664ed42ed7f76bb5d41_t.jpg"],"type":1,"id":7102003,"title":"玩物
	 * | 见鬼杀鬼，见神杀神，服部半藏武士刀"},{"images":["http://pic2.zhimg.com/73dc14fb0011b8cda8a898d7cfd2e615_t.jpg"],"type":1,"id":7093452,"title":"寻找[港囧]的蛛丝马迹及血缘归属"},{"images":["http://pic4.zhimg.com/bf7201ee5eb640c126ddfc05c5c562d7_t.jpg"],"type":2,"id":7093222,"title":"「好莱坞报告三」中国人带着资本进入好莱坞，但美国人想要的不是钱"},{"images":["http://pic3.zhimg.com/42a7dd7cf12b3fb5903d78273dfc6c8e_t.jpg"],"type":1,"id":7090984,"title":"玩物
	 * | 万军丛中过，滴血不沾身，刺客的信条\u2014\u2014袖刃"}]
	 * description : 除了经典和新片，我们还关注技术和产业
	 * background : http://p1.zhimg.com/80/0b/800b79a4821a535de31b349ffdc9eabb.jpg
	 * color : 14483535
	 * name : 电影日报
	 * image : https://pic1.zhimg.com/ddf10a04227ea50fd59746dbcd13c728.jpg
	 * editors : [{"url":"http://www.zhihu.com/people/deng-ruo-xu","bio":"好奇心日报","id":82,"avatar":"http://pic2.zhimg.com/d3b31fa32_m.jpg","name":"邓若虚"},{"url":"http://www.zhihu.com/people/yu-ke-er","bio":"电影产业研究者","id":40,"avatar":"http://pic4.zhimg.com/9d9e1f217_m.jpg","name":"余柯儿"},{"url":"http://www.zhihu.com/people/wo-jiao-a-lang","bio":"《看电影》杂志主编","id":85,"avatar":"http://pic3.zhimg.com/10b09d8b79a5315273824d310c4d602e_m.jpg","name":"我叫阿郎"},{"url":"http://www.zhihu.com/people/zhao-shu-rong","bio":"《看电影》杂志编辑","id":84,"avatar":"http://pic1.zhimg.com/57c7b29e4_m.jpg","name":"赵恕容"}]
	 * image_source :
	 */

	@SerializedName("description")
	private String description;
	@SerializedName("background")
	private String background;
	@SerializedName("color")
	private int color;
	@SerializedName("name")
	private String name;
	@SerializedName("image")
	private String image;
	@SerializedName("image_source")
	private String imageSource;
	@SerializedName("stories")
	private List<StoriesBean> stories;
	@SerializedName("editors")
	private List<EditorsBean> editors;

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

	public List<StoriesBean> getStories() {
		return stories;
	}

	public void setStories(List<StoriesBean> stories) {
		this.stories = stories;
	}

	public List<EditorsBean> getEditors() {
		return editors;
	}

	public void setEditors(List<EditorsBean> editors) {
		this.editors = editors;
	}

	public static class StoriesBean {
		/**
		 * type : 0
		 * id : 7400530
		 * title : 哪些电影有浓厚的建筑人文意味？
		 * images : ["http://pic4.zhimg.com/e43e1f7d8dfce546c4e95e944bcfb6cb_t.jpg"]
		 */

		@SerializedName("type")
		private int type;
		@SerializedName("id")
		private int id;
		@SerializedName("title")
		private String title;
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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getImages() {
			return images;
		}

		public void setImages(List<String> images) {
			this.images = images;
		}
	}

	public static class EditorsBean {
		/**
		 * url : http://www.zhihu.com/people/deng-ruo-xu
		 * bio : 好奇心日报
		 * id : 82
		 * avatar : http://pic2.zhimg.com/d3b31fa32_m.jpg
		 * name : 邓若虚
		 */

		@SerializedName("url")
		private String url;
		@SerializedName("bio")
		private String bio;
		@SerializedName("id")
		private int id;
		@SerializedName("avatar")
		private String avatar;
		@SerializedName("name")
		private String name;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getBio() {
			return bio;
		}

		public void setBio(String bio) {
			this.bio = bio;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
