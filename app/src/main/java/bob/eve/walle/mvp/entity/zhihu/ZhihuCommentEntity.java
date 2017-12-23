/*
 * Create by BobEve on 17-12-18 上午10:54
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午10:54
 */

package bob.eve.walle.mvp.entity.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuCommentEntity {

	@SerializedName("comments")
	private List<CommentsBean> comments;

	public List<CommentsBean> getComments() {
		return comments;
	}

	public void setComments(List<CommentsBean> comments) {
		this.comments = comments;
	}

	public static class CommentsBean {
		/**
		 * author : Butterfly150
		 * content : 暂不支持阅读模式
		 * 请问大家都怎么看内容的？
		 * avatar : http://pic4.zhimg.com/v2-318a0ed0d82307d5ec8887cb4090772b_im.jpg
		 * time : 1503852013
		 * id : 30087138
		 * likes : 1
		 * reply_to : {"content":"不好意思\u2026\u2026\u2026但是我想作者大概不看日漫","status":0,"id":21204925,"author":"尾随雪喵的喵呜樣"}
		 */

		@SerializedName("author")
		private String author;
		@SerializedName("content")
		private String content;
		@SerializedName("avatar")
		private String avatar;
		@SerializedName("time")
		private int time;
		@SerializedName("id")
		private int id;
		@SerializedName("likes")
		private int likes;
		@SerializedName("reply_to")
		private ReplyToBean replyTo;

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getLikes() {
			return likes;
		}

		public void setLikes(int likes) {
			this.likes = likes;
		}

		public ReplyToBean getReplyTo() {
			return replyTo;
		}

		public void setReplyTo(ReplyToBean replyTo) {
			this.replyTo = replyTo;
		}

		public static class ReplyToBean {
			/**
			 * content : 不好意思………但是我想作者大概不看日漫
			 * status : 0
			 * id : 21204925
			 * author : 尾随雪喵的喵呜樣
			 */

			@SerializedName("content")
			private String content;
			@SerializedName("status")
			private int status;
			@SerializedName("id")
			private int id;
			@SerializedName("author")
			private String author;

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public int getStatus() {
				return status;
			}

			public void setStatus(int status) {
				this.status = status;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getAuthor() {
				return author;
			}

			public void setAuthor(String author) {
				this.author = author;
			}
		}
	}
}
