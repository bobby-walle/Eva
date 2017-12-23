/*
 * Create by BobEve on 17-12-18 下午11:41
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午11:41
 */

package bob.eve.walle.mvp.model.bean.douban;

import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class MovieSubject {
	/**
	 * rating : {"max":10,"average":9.6,"stars":"50","min":0}
	 * genres : ["犯罪","剧情"]
	 * title : 肖申克的救赎
	 * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/",
	 * "avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg"},
	 * "name":"蒂姆·罗宾斯","id":"1054521"},
	 * {"alt":"https://movie.douban.com/celebrity/1054534/",
	 * "avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.jpg"},
	 * "name":"摩根·弗里曼","id":"1054534"},
	 * {"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.jpg"},
	 * "name":"鲍勃·冈顿","id":"1041179"}]
	 * collect_count : 1171879
	 * original_title : The Shawshank Redemption
	 * subtype : movie
	 * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/",
	 * "avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg"},
	 * "name":"弗兰克·德拉邦特","id":"1047973"}]
	 * year : 1994
	 * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg"}
	 * alt : https://movie.douban.com/subject/1292052/
	 * id : 1292052
	 */

	private RatingBean rating;
	private String title;
	private String originalTitle;
	private String subtype;
	private String year;
	private ImagesBean images;
	private String alt;
	private String id;
	private List<String> genres;
	private List<CastsBean> casts;
	private List<DirectorsBean> directors;

	public RatingBean getRating() {
		return rating;
	}

	public void setRating(RatingBean rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ImagesBean getImages() {
		return images;
	}

	public void setImages(ImagesBean images) {
		this.images = images;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<CastsBean> getCasts() {
		return casts;
	}

	public void setCasts(List<CastsBean> casts) {
		this.casts = casts;
	}

	public List<DirectorsBean> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorsBean> directors) {
		this.directors = directors;
	}

	public static class RatingBean {
		/**
		 * max : 10
		 * average : 9.6
		 * stars : 50
		 * min : 0
		 */

		private int max;
		private float average;
		private String stars;
		private int min;

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		public float getAverage() {
			return average;
		}

		public void setAverage(float average) {
			this.average = average;
		}

		public String getStars() {
			return stars;
		}

		public void setStars(String stars) {
			this.stars = stars;
		}

		public int getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}
	}

	public static class ImagesBean {
		/**
		 * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg
		 * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg
		 * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg
		 */

		private String small;
		private String large;
		private String medium;

		public String getSmall() {
			return small;
		}

		public void setSmall(String small) {
			this.small = small;
		}

		public String getLarge() {
			return large;
		}

		public void setLarge(String large) {
			this.large = large;
		}

		public String getMedium() {
			return medium;
		}

		public void setMedium(String medium) {
			this.medium = medium;
		}
	}

	public static class CastsBean {
		/**
		 * alt : https://movie.douban.com/celebrity/1054521/
		 * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg"}
		 * name : 蒂姆·罗宾斯
		 * id : 1054521
		 */

		private String alt;
		private AvatarsBean avatars;
		private String name;
		private String id;

		public String getAlt() {
			return alt;
		}

		public void setAlt(String alt) {
			this.alt = alt;
		}

		public AvatarsBean getAvatars() {
			return avatars;
		}

		public void setAvatars(AvatarsBean avatars) {
			this.avatars = avatars;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public static class AvatarsBean {
			/**
			 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg
			 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg
			 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.jpg
			 */

			private String small;
			private String large;
			private String medium;

			public String getSmall() {
				return small;
			}

			public void setSmall(String small) {
				this.small = small;
			}

			public String getLarge() {
				return large;
			}

			public void setLarge(String large) {
				this.large = large;
			}

			public String getMedium() {
				return medium;
			}

			public void setMedium(String medium) {
				this.medium = medium;
			}
		}
	}

	public static class DirectorsBean {
		/**
		 * alt : https://movie.douban.com/celebrity/1047973/
		 * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg"}
		 * name : 弗兰克·德拉邦特
		 * id : 1047973
		 */

		private String alt;
		private AvatarsBeanX avatars;
		private String name;
		private String id;

		public String getAlt() {
			return alt;
		}

		public void setAlt(String alt) {
			this.alt = alt;
		}

		public AvatarsBeanX getAvatars() {
			return avatars;
		}

		public void setAvatars(AvatarsBeanX avatars) {
			this.avatars = avatars;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public static class AvatarsBeanX {
			/**
			 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg
			 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg
			 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.jpg
			 */

			private String small;
			private String large;
			private String medium;

			public String getSmall() {
				return small;
			}

			public void setSmall(String small) {
				this.small = small;
			}

			public String getLarge() {
				return large;
			}

			public void setLarge(String large) {
				this.large = large;
			}

			public String getMedium() {
				return medium;
			}

			public void setMedium(String medium) {
				this.medium = medium;
			}
		}
	}
}
