/*
 * Create by BobEve on 17-12-18 上午10:35
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午10:35
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuDetailEntity {

	/**
	 * body : <div class="main-wrap content-wrap">
	 * <div class="headline">
	 *
	 * <div class="img-place-holder"></div>
	 *
	 *
	 *
	 * </div>
	 *
	 * <div class="content-inner">
	 *
	 *
	 *
	 * <div class="question">
	 * <h2 class="question-title"></h2>
	 * <div class="answer">
	 *
	 * <div class="meta">
	 * <img class="avatar" src="http://pic3.zhimg.com/v2-115c6279ab91e8eaee0a94abe5966f02_is.jpg">
	 * <span class="author">巴塞电影</span>
	 * </div>
	 *
	 * <div class="content">
	 * <p>今年，一部《我的前半生》红遍全国。</p>
	 * <p>小三插足、男主养成、失婚女主逆袭成功......种种话题都能引发全民热论。</p>
	 * <p>最近，有一部国外版《我的前半生》来了。</p>
	 * <p>不仅有小三插足、励志女主、还有大露点、野战戏，简直吸引。</p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-126eb90c7c2a7ed42cef38e17ab7298f_b.jpg"
	 * alt=""></figure><figure><img class="content-image" src="http://pic4.zhimg.com/v2-3a8cf445f05b83752fdcee80ae8e03df_b.jpg"
	 * alt=""></figure><p>豆瓣 9.3 高分，看过的都说好。</p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-b7a1e1caac69fd843f1001f72f741f63_b.jpg"
	 * alt=""></figure><p>它就是——</p>
	 * <p><strong><strong>《了不起的麦瑟尔夫人》 </strong></strong></p>
	 * <p>The Marvelous Mrs. Maisel</p>
	 * <figure><img class="content-image" src="http://pic1.zhimg.com/v2-49a8c8429813e8c469d7f0dc489496e8_b.jpg"
	 * alt=""></figure><p><strong>上世纪 50 年代的家庭主妇，过着怎样的一种生活？</strong></p>
	 * <p>这部剧的女主角米琪·麦瑟尔，完美地向我们诠释了这种生活——</p>
	 * <p>夜晚，关灯，老公睡了。米琪连忙起床，去厕所卷发、卸妆、洗脸、敷睡眠面膜。</p>
	 * <p>回到卧室，打开窗户，角度精准得只能让隔天的太阳照到自己。</p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-c6718d86167622b69025f5cd36e1a1e7_b.gif"
	 * alt=""></figure><p>早晨，天微亮，老公还没醒。米琪被洒在脸上的阳光惊醒，一个鲤鱼挺身，赶到厕所。</p>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-6ad93fb3e5f2a54d417c592af3f83115_b.gif"
	 * alt=""></figure><p>洗脸、擦粉底、贴假睫毛、涂唇膏、打理发型、喷香水......</p>
	 * <p>回到卧室，关上窗户，躺回床上<strong>假装睡着</strong>。</p>
	 * <p>等待闹钟铃响，老公醒来，看到的依旧是她最精致的一面。</p>
	 * <figure><img class="content-image" src="http://pic1.zhimg.com/v2-31f0a8708e80ad051b647b10a1129298_b.gif"
	 * alt=""></figure><figure><img class="content-image" src="http://pic1.zhimg.com/v2-a2b7368ac8a7207a6011dedbaf427b24_b.gif"
	 * alt=""></figure><p>结婚四年，子女双全，米琪的老公，没有见过一次她的素颜。</p>
	 * <p>会不会觉得，这种围着老公转的婚后生活有点累？</p>
	 * <p>然而，大家都不觉得。</p>
	 * <p><strong>在外人看来，米琪简直是人生赢家</strong>——</p>
	 * <p>长得美、身材好，出生书香门第，毕业于名校。</p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-6c305f98a1d35d84b847367b30823243_b.jpg"
	 * alt=""></figure><p>不仅上得了厅堂，她还下得了厨房，做出的食物简直让人流口水。</p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-ea2b758ec1453710028ed7667f8410ef_b.gif"
	 * alt=""></figure><p>最关键的是，米琪嫁给了所有人都称羡的男人。</p>
	 * <p>老公乔尔，人帅身材高。有个开服装加工厂的有钱老爹，自己还是公司副总裁。</p>
	 * <figure><img class="content-image" src="http://pic3.zhimg.com/v2-88dc333a97ef07ce2f9cb184294d7a1e_b.jpg"
	 * alt=""></figure><p>而且，他还有个自己的小梦想：<strong>成为一个著名的喜剧脱口秀家</strong>。</p>
	 * <p>每天晚上，夫妇俩都会跑到酒吧，让乔尔练习上台表演。</p>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-cb0c2b3df43ea74b7421549ffeeb0ae5_b.jpg"
	 * alt=""></figure><p>在世俗眼中，米琪是许多女人的榜样——</p>
	 * <p>上好大学、化美美的妆、保持苗条的身材。毕业后，嫁个有钱老公，过上稳定的中产阶级生活。</p>
	 * <p>对她们来说，这就是唯一的成功人生。</p>
	 * <p>米琪也是这么想，直到现实打碎了这得之不易的胜利。</p>
	 * <p>一次表演失败后，乔尔把所有的气都出在米琪身上。</p>
	 * <blockquote>“都是你，没有给我争取到表演的黄金时段。”<br>“都是你，没有注意到我的衣服上有洞，害得我上台丢脸。”<br>“都是你，让我自己原创一个关于毛衣的笑话，让我表演失败。”</blockquote>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-475715131dc3108384273a5cbc491415_b.jpg"
	 * alt=""></figure><p>你以为吵一架就完了？还不止——</p>
	 * <p>乔尔突然收拾行李说：我要离开你。</p>
	 * <p><strong>原因也很常见，他出轨了。</strong></p>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-a6d0b68b511b8e99ef25bad96a78e9ad_b.gif"
	 * alt=""></figure><p>对象是那个连铅笔刀都削不好的蠢秘书。</p>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-4741ac658f1f71758fc283bc33d319f9_b.gif"
	 * alt=""></figure><p>这够渣了吧？但在男尊女卑的男权社会中，丈夫突然间抛弃妻子，那绝对是女方的错。</p>
	 * <p>剧中，所有人的反应都印证着这一点——</p>
	 * <p>当米琪告诉父母乔尔想离婚时，母亲的第一句话是：</p>
	 * <p><strong>为什么？你做错了什么？</strong></p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-580056c1e091f900d7f662408eb83acf_b.jpg"
	 * alt=""></figure><p>当知道是乔尔出轨时，作为大学教授的父亲想出的对策是：</p>
	 * <p><strong>你打扮一下，穿上他最喜欢的裙子，然后出去找他，让他回家。</strong></p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-327ae33a30a29abaec469c6cdf5ebecf_b.jpg"
	 * alt=""></figure><p>闺蜜的反应则是：<strong>不能离婚啊！</strong></p>
	 * <p>离了婚的女人，就像健身课上那些角落里的女人，结局特别悲惨。</p>
	 * <blockquote>那些离婚的人<br>我们来上课是为了能吃芝士蛋糕<br>她们来上这些课是为了能找到新男人<br>或者至少死了验尸的时候<br>看起来没那么糟</blockquote>
	 * <figure><img class="content-image" src="http://pic3.zhimg.com/v2-aad6ffce53926a42dd04e0048adae2a2_b.jpg"
	 * alt=""></figure><p>因为被老公抛弃，米琪由人人称羡的人生赢家，一夜间沦为失败者。</p>
	 * <p>发现这其中感人的逻辑没？</p>
	 * <p><strong>一个女人的人生成功与否，完全依附于男人与婚姻。</strong></p>
	 * <p>只要你大龄单身、只要你离了婚，便只能过上绝望而悲惨的生活。</p>
	 * <p>女人不是人，女人是物品。没男人用，是垃圾。用了被扔，是二手货。</p>
	 * <p>所以，当乔尔离开米琪，她的第一反应是：我做得还不够好。</p>
	 * <p>我会做得更好，我会更加用心。</p>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-0904b8f21d745d2d0c08a41a24ac5a09_b.jpg"
	 * alt=""></figure><p>米琪的存在，其实代表着千千万万个女人。</p>
	 * <p>这部剧的故事，设立于美国上世纪的 50 年代末——<strong>正是 60 年代妇女解放运动的前夕。</strong></p>
	 * <p>当时的美国经济繁荣、保守主义盛行。</p>
	 * <p>在这种风潮下，男主外、女主内成为一种社会传统。除了当家庭主妇，女性似乎没有其他选项。</p>
	 * <p>换言之，假如她们选择不同的人生道路，便会遭受他人与社会的不满与嘲笑。</p>
	 * <p><strong>她们没有自由选择的权利。</strong></p>
	 * <figure><img class="content-image" src="http://pic3.zhimg.com/v2-f3a541ab775a3ea6773cdfb64407d456_b.jpg"
	 * alt=""></figure><p>在这个前提下，许多怀揣着其他目标的妇女，看似不用为经济发愁，可却把家庭看为沉重的枷锁：<strong>不仅经济依赖于丈夫，而且社会地位地下，难以成为独立的个体。</strong></p>
	 * <p>她们有梦，但社会无法容忍女性追梦。</p>
	 * <p>米琪便是其中的一员。</p>
	 * <p>你以为她生下来，就是那个“必须在丈夫面前时刻保持完美”的女人吗？</p>
	 * <p>作为犹太人，她会在婚礼上说：蛋卷里有虾！（犹太人的饮食忌讳）</p>
	 * <figure><img class="content-image" src="http://pic1.zhimg.com/v2-596ec03dcb740afd614854f8e274de18_b.jpg"
	 * alt=""></figure><p>宾客闹作一团，她站在人群中，顽皮地眨着眼睛。</p>
	 * <figure><img class="content-image" src="http://pic1.zhimg.com/v2-31deaf5c4b918ac1e9a31ef7625f1dbc_b.gif"
	 * alt=""></figure><p>她还会在舞台上，调侃着“穿束身衣的淑女”，全场观众爆笑如雷。</p>
	 * <blockquote>我很想狂踢在坐每一位男士的蛋蛋<br>但我不会 我还是个淑女<br>淑女从来不会狂踢男人的蛋蛋<br>最多也就踢二三十分钟<br>因为他们的束身衣会让血液不流通</blockquote>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-33476dbe7da16c42e409483c90e3c7b1_b.jpg"
	 * alt=""></figure><p>只要她想，一言一语都能引起台下轰动。</p>
	 * <p>这是一个天生活在舞台的女人。</p>
	 * <p>然而，她却在被物化的过程中，把乔尔当成世界中心，并说出<strong>“离了婚，我就是一个悲惨、难堪的女人”。</strong></p>
	 * <figure><img class="content-image" src="http://pic3.zhimg.com/v2-cff1c79fd42f10af71256e19b669f872_b.jpg"
	 * alt=""></figure><p>对她而言，老公便是人生的全部意义。</p>
	 * <p><strong>这究竟是米琪的错，还是男权社会的错？</strong></p>
	 * <p>答案一清二楚。</p>
	 * <p>同样，米琪的改变也告诉我们：先选择自己，才能更好地选择爱情、选择生活。</p>
	 * <p>在我看来，这其实是一个迷失自我的女人，在遭受生活暴击后逐渐觉醒的故事。</p>
	 * <p>三个场景，见证这段成长——</p>
	 * <p><strong>▎一，释放自己。</strong></p>
	 * <p>米琪被丈夫抛弃，被父母与闺蜜不理解。她喝醉酒，晕乎乎跑到俱乐部。</p>
	 * <p>唯一肯聆听她的，是台下等待娱乐的听众。</p>
	 * <p>米琪站在台上，衣衫不整、妆容尽毁、头发湿漉漉，却迎来了难得的自我时刻：她用调侃的方式，讲述着自己悲惨的境遇。</p>
	 * <p>娱乐着听众，同时也释放出自己。</p>
	 * <figure><img class="content-image" src="http://pic2.zhimg.com/v2-192d4032c1d65b89541cb90c1ea855a1_b.jpg"
	 * alt=""></figure><p>虽然释放得有点过了......</p>
	 * <figure><img class="content-image" src="http://pic4.zhimg.com/v2-126eb90c7c2a7ed42cef38e17ab7298f_b.jpg"
	 * alt=""></figure><p><strong>▎二，反思生活。</strong></p>
	 * <p>舞台上的米琪，提出了质问：女人有没有不做母亲的权利？女人可以有更多的生活方式吗？</p>
	 * <p>她开始思考，自己的生活可以有所不同。</p>
	 * <blockquote>我的意识是，女人生来就要当妈妈<br>这被看作是自然而然、理所当然的<br>我是说，有没有例外呢<br>假如我们之中的有些人<br>天生就是四处漂泊呢<br>又或者穿着工作服二十四小时</blockquote>
	 * <figure><img class="content-image" src="http://pic3.zhimg.com/v2-ede437515d236968b5a80b28f3900c4e_b.jpg"
	 * alt=""></figure><p><strong>▎三，做出抉择。</strong></p>
	 * <p>这是前三集中，我最爱的场景——</p>
	 * <p>当乔尔幡然悔悟，想与米琪重新开始时，她看着他，坚定地说不。</p>
	 * <blockquote>乔尔：不？为什么？<br>麦瑟尔：因为你离开了我。</blockquote>
	 * <figure><img class="content-image" src="http://pic3.zhimg.com/v2-2d03832ff81f2f0ca73c462125f84a2e_b.jpg"
	 * alt=""></figure><p>这一刻，米琪终于活出自我。</p>
	 * <p>她选择了那个虽然前方漂泊不定，却有权利说“不”的自由。</p>
	 * <p><strong>她有得选择。</strong></p>
	 *
	 * <div class="view-more"><a href="http://zhuanlan.zhihu.com/p/32021811">查看知乎讨论</a></div>
	 *
	 * </div>
	 * </div>
	 * </div>
	 *
	 *
	 * </div>
	 * </div><script type=“text/javascript”>window.daily=true</script>
	 * image_source : 《了不起的麦瑟尔夫人》
	 * title : 女人啊，你可以选择不结婚
	 * image : https://pic4.zhimg.com/v2-f2b72f5d6eda9c8a52ee0f6aa1ad63fb.jpg
	 * share_url : http://daily.zhihu.com/story/9661453
	 * js : []
	 * id : 9661453
	 * ga_prefix : 121721
	 * images : ["https://pic4.zhimg.com/v2-c018792e2c5aa68205ac3d50eb5a02fb.jpg"]
	 * type : 0
	 * section : {"thumbnail":"https://pic4.zhimg.com/v2-c018792e2c5aa68205ac3d50eb5a02fb.jpg","name":"放映机","id":28}
	 * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
	 */

	@SerializedName("body")
	private String body;
	@SerializedName("image_source")
	private String imageSource;
	@SerializedName("title")
	private String title;
	@SerializedName("image")
	private String image;
	@SerializedName("share_url")
	private String shareUrl;
	@SerializedName("id")
	private int id;
	@SerializedName("ga_prefix")
	private String gaPrefix;
	@SerializedName("type")
	private int type;
	@SerializedName("section")
	private ZhihuDetailSourceEntity section;
	@SerializedName("theme")
	private ZhihuDetailSourceEntity theme;
	@SerializedName("js")
	private List<String> js;
	@SerializedName("images")
	private List<String> images;
	@SerializedName("css")
	private List<String> css;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ZhihuDetailSourceEntity getSection() {
		return section;
	}

	public void setSection(ZhihuDetailSourceEntity section) {
		this.section = section;
	}

	public ZhihuDetailSourceEntity getTheme() {
		return theme;
	}

	public void setTheme(ZhihuDetailSourceEntity theme) {
		this.theme = theme;
	}

	public List<String> getJs() {
		return js;
	}

	public void setJs(List<String> js) {
		this.js = js;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<String> getCss() {
		return css;
	}

	public void setCss(List<String> css) {
		this.css = css;
	}

	/*public static class SectionBean {
		*//**
	 * thumbnail : https://pic4.zhimg.com/v2-c018792e2c5aa68205ac3d50eb5a02fb.jpg
	 * name : 放映机
	 * id : 28
	 *//*

		@SerializedName("thumbnail")
		private String thumbnail;
		@SerializedName("name")
		private String name;
		@SerializedName("id")
		private int id;

		public String getThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

	public static class ThemeBean {
		*//**
	 * "thumbnail": "http://pic3.zhimg.com/00eba01080138a5ac861d581a64ff9bd.jpg",
	 * "id": 3,
	 * "name": "电影日报"
	 *//*

		@SerializedName("thumbnail")
		private String thumbnail;
		@SerializedName("name")
		private String name;
		@SerializedName("id")
		private int id;

		public String getThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}*/
}
