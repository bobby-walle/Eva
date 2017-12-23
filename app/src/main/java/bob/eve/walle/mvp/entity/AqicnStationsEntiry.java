/*
 * Create by BobEve on 17-12-13 下午4:59
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午4:59
 */

package bob.eve.walle.mvp.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/13.
 */

public class AqicnStationsEntiry {

	/**
	 * status : ok
	 * data : [{"uid":1451,"aqi":"102","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Beijing","geo":[39.954592,116.468117],"url":"beijing"}},{"uid":3303,"aqi":"102","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Beijing US Embassy,
	 * Beijing","geo":[39.954592,116.468117],"url":"beijing/us-embassy"}},{"uid":885,"aqi":"70","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Beijing South ,
	 * Huai'an","geo":[33.578039,119.007906],"url":"jiangsu/huaian/beijingnanlu"}},{"uid":454,"aqi":"-","time":{"tz":"+0800","stime":"2017-11-24
	 * 10:00:00","vtime":1511488800},"station":{"name":"Haidian Beijing Botanical Garden,
	 * Beijing","geo":[40.002,116.207],"url":"beijing/haidianbeijingzhiwuyuan"}},{"uid":465,"aqi":"97","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Pinggu town, Beijing","geo":[40.143,117.1],"url":"beijing/pingguzhen"}},{"uid":468,"aqi":"109","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Yanqing town, Beijing","geo":[40.453,115.972],"url":"beijing/yanqingzhen"}},{"uid":466,"aqi":"91","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Huairou town, Beijing","geo":[40.328,116.628],"url":"beijing/huairouzhen"}},{"uid":478,"aqi":"93","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Xizhimen N St, Beijing","geo":[39.954,116.349],"url":"beijing/xizhimenbeidajie"}},{"uid":455,"aqi":"97","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Fengtai garden,
	 * Beijing","geo":[39.863,116.279],"url":"beijing/fengtaihuayuan"}},{"uid":452,"aqi":"89","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Haidian Wanliu,
	 * Beijing","geo":[39.987,116.287],"url":"beijing/haidianwanliu"}},{"uid":463,"aqi":"72","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Changping Town,
	 * Beijing","geo":[40.217,116.23],"url":"beijing/changpingzhen"}},{"uid":449,"aqi":"74","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Wanshou Temple,
	 * Beijing","geo":[39.878,116.352],"url":"beijing/xichengwanshouxigong"}},{"uid":479,"aqi":"97","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"South Ring Road,
	 * Beijing","geo":[39.856,116.368],"url":"beijing/nansanhuanxilu"}},{"uid":456,"aqi":"87","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Fengtai Yungang,
	 * Beijing","geo":[39.824,116.146],"url":"beijing/fengtaiyungang"}},{"uid":471,"aqi":"68","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Miyun Reservoir,
	 * Beijing","geo":[40.499,116.911],"url":"beijing/jingdongbeimiyunshuiku"}},{"uid":462,"aqi":"97","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Shunyi New Town ,
	 * Beijing","geo":[40.127,116.655],"url":"beijing/shunyixincheng"}},{"uid":474,"aqi":"102","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Yufazhen, Daxing,
	 * Beijing","geo":[39.52,116.3],"url":"beijing/jingnanyufa"}},{"uid":446,"aqi":"85","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Dongcheng Dongsi,
	 * Beijing","geo":[39.929,116.417],"url":"beijing/dongchengdongsi"}},{"uid":457,"aqi":"97","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Shijingshan city,
	 * Beijing","geo":[39.914,116.184],"url":"beijing/shijingshangucheng"}},{"uid":461,"aqi":"117","time":{"tz":"+0800","stime":"2017-12-12
	 * 23:00:00","vtime":1513090800},"station":{"name":"Tongzhou New Town,
	 * Beijing","geo":[39.886,116.663],"url":"beijing/tongzhouxincheng"}}]
	 */

	@SerializedName("status")
	private String status;
	@SerializedName("data")
	private List<DataBean> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<DataBean> getData() {
		return data;
	}

	public void setData(List<DataBean> data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * uid : 1451
		 * aqi : 102
		 * time : {"tz":"+0800","stime":"2017-12-12 23:00:00","vtime":1513090800}
		 * station : {"name":"Beijing","geo":[39.954592,116.468117],"url":"beijing"}
		 */

		@SerializedName("uid")
		private int uid;
		@SerializedName("aqi")
		private String aqi;
		@SerializedName("time")
		private TimeBean time;
		@SerializedName("station")
		private StationBean station;

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

		public String getAqi() {
			return aqi;
		}

		public void setAqi(String aqi) {
			this.aqi = aqi;
		}

		public TimeBean getTime() {
			return time;
		}

		public void setTime(TimeBean time) {
			this.time = time;
		}

		public StationBean getStation() {
			return station;
		}

		public void setStation(StationBean station) {
			this.station = station;
		}

		public static class TimeBean {
			/**
			 * tz : +0800
			 * stime : 2017-12-12 23:00:00
			 * vtime : 1513090800
			 */

			@SerializedName("tz")
			private String tz;
			@SerializedName("stime")
			private String stime;
			@SerializedName("vtime")
			private long vtime;

			public String getTz() {
				return tz;
			}

			public void setTz(String tz) {
				this.tz = tz;
			}

			public String getStime() {
				return stime;
			}

			public void setStime(String stime) {
				this.stime = stime;
			}

			public long getVtime() {
				return vtime;
			}

			public void setVtime(long vtime) {
				this.vtime = vtime;
			}
		}

		public static class StationBean {
			/**
			 * name : Beijing
			 * geo : [39.954592,116.468117]
			 * url : beijing
			 */

			@SerializedName("name")
			private String name;
			@SerializedName("url")
			private String url;
			@SerializedName("geo")
			private List<Double> geo;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public List<Double> getGeo() {
				return geo;
			}

			public void setGeo(List<Double> geo) {
				this.geo = geo;
			}
		}
	}
}
