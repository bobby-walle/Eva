/*
 * Create by BobEve on 17-12-13 下午5:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午5:01
 */

package bob.eve.walle.mvp.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/13.
 */

public class AqicnAQIDetailsEntity {

	/**
	 * status : ok
	 * data : {"aqi":97,"idx":453,"attributions":[{"url":"http://www.bjmemc.com.cn/","name":"Beijing
	 * Environmental Protection Monitoring Center (北京市环境保护监测中心)"}],"city":{"geo":[40.09,116.174],"name":"The
	 * Haidian northern New Area","url":"http://aqicn.org/city/beijing/haidianbeibuxinqu/"},"dominentpol":"pm25","iaqi":{"co":{"v":6.4},"d":{"v":-20},"h":{"v":23},"no2":{"v":24.7},"o3":{"v":7},"p":{"v":1036},"pm10":{"v":50},"pm25":{"v":97},"so2":{"v":3.6},"t":{"v":-1},"w":{"v":1.8},"wd":{"v":340}},"time":{"s":"2017-12-13
	 * 16:00:00","tz":"+08:00","v":1513180800}}
	 */

	@SerializedName("status")
	private String status;
	@SerializedName("data")
	private DataBean data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * aqi : 97
		 * idx : 453
		 * attributions : [{"url":"http://www.bjmemc.com.cn/","name":"Beijing Environmental Protection
		 * Monitoring Center (北京市环境保护监测中心)"}]
		 * city : {"geo":[40.09,116.174],"name":"The Haidian northern New Area","url":"http://aqicn.org/city/beijing/haidianbeibuxinqu/"}
		 * dominentpol : pm25
		 * iaqi : {"co":{"v":6.4},"d":{"v":-20},"h":{"v":23},"no2":{"v":24.7},"o3":{"v":7},"p":{"v":1036},"pm10":{"v":50},"pm25":{"v":97},"so2":{"v":3.6},"t":{"v":-1},"w":{"v":1.8},"wd":{"v":340}}
		 * time : {"s":"2017-12-13 16:00:00","tz":"+08:00","v":1513180800}
		 */

		@SerializedName("aqi")
		private double aqi;
		@SerializedName("idx")
		private double idx;
		@SerializedName("city")
		private CityBean city;
		@SerializedName("dominentpol")
		private String dominentpol;
		@SerializedName("iaqi")
		private IaqiBean iaqi;
		@SerializedName("time")
		private TimeBean time;
		@SerializedName("attributions")
		private List<AttributionsBean> attributions;

		public double getAqi() {
			return aqi;
		}

		public void setAqi(double aqi) {
			this.aqi = aqi;
		}

		public double getIdx() {
			return idx;
		}

		public void setIdx(double idx) {
			this.idx = idx;
		}

		public CityBean getCity() {
			return city;
		}

		public void setCity(CityBean city) {
			this.city = city;
		}

		public String getDominentpol() {
			return dominentpol;
		}

		public void setDominentpol(String dominentpol) {
			this.dominentpol = dominentpol;
		}

		public IaqiBean getIaqi() {
			return iaqi;
		}

		public void setIaqi(IaqiBean iaqi) {
			this.iaqi = iaqi;
		}

		public TimeBean getTime() {
			return time;
		}

		public void setTime(TimeBean time) {
			this.time = time;
		}

		public List<AttributionsBean> getAttributions() {
			return attributions;
		}

		public void setAttributions(List<AttributionsBean> attributions) {
			this.attributions = attributions;
		}

		public static class CityBean {
			/**
			 * geo : [40.09,116.174]
			 * name : The Haidian northern New Area
			 * url : http://aqicn.org/city/beijing/haidianbeibuxinqu/
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

		public static class IaqiBean {
			/**
			 * co : {"v":6.4} CO 一氧化碳
			 * d : {"v":-20} Dew 露
			 * h : {"v":23} Humidity 湿度
			 * no2 : {"v":24.7} NO2 二氧化氮
			 * o3 : {"v":7} O3 臭氧
			 * p : {"v":1036} Pressure 压力
			 * pm10 : {"v":50} PM10 可吸入颗粒物
			 * pm25 : {"v":97} PM25 细颗粒物
			 * so2 : {"v":3.6} SO2 二氧化硫
			 * t : {"v":-1} Temp 温度
			 * w : {"v":1.8} Wind 风
			 * wd : {"v":340}
			 */

			@SerializedName("co")
			private CoBean co;
			@SerializedName("d")
			private DBean d;
			@SerializedName("h")
			private HBean h;
			@SerializedName("no2")
			private No2Bean no2;
			@SerializedName("o3")
			private O3Bean o3;
			@SerializedName("p")
			private PBean p;
			@SerializedName("pm10")
			private Pm10Bean pm10;
			@SerializedName("pm25")
			private Pm25Bean pm25;
			@SerializedName("so2")
			private So2Bean so2;
			@SerializedName("t")
			private TBean t;
			@SerializedName("w")
			private WBean w;
			@SerializedName("wd")
			private WdBean wd;

			public CoBean getCo() {
				return co;
			}

			public void setCo(CoBean co) {
				this.co = co;
			}

			public DBean getD() {
				return d;
			}

			public void setD(DBean d) {
				this.d = d;
			}

			public HBean getH() {
				return h;
			}

			public void setH(HBean h) {
				this.h = h;
			}

			public No2Bean getNo2() {
				return no2;
			}

			public void setNo2(No2Bean no2) {
				this.no2 = no2;
			}

			public O3Bean getO3() {
				return o3;
			}

			public void setO3(O3Bean o3) {
				this.o3 = o3;
			}

			public PBean getP() {
				return p;
			}

			public void setP(PBean p) {
				this.p = p;
			}

			public Pm10Bean getPm10() {
				return pm10;
			}

			public void setPm10(Pm10Bean pm10) {
				this.pm10 = pm10;
			}

			public Pm25Bean getPm25() {
				return pm25;
			}

			public void setPm25(Pm25Bean pm25) {
				this.pm25 = pm25;
			}

			public So2Bean getSo2() {
				return so2;
			}

			public void setSo2(So2Bean so2) {
				this.so2 = so2;
			}

			public TBean getT() {
				return t;
			}

			public void setT(TBean t) {
				this.t = t;
			}

			public WBean getW() {
				return w;
			}

			public void setW(WBean w) {
				this.w = w;
			}

			public WdBean getWd() {
				return wd;
			}

			public void setWd(WdBean wd) {
				this.wd = wd;
			}

			public static class CoBean {
				/**
				 * v : 6.4
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class DBean {
				/**
				 * v : -20
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class HBean {
				/**
				 * v : 23
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class No2Bean {
				/**
				 * v : 24.7
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class O3Bean {
				/**
				 * v : 7
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class PBean {
				/**
				 * v : 1036
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class Pm10Bean {
				/**
				 * v : 50
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class Pm25Bean {
				/**
				 * v : 97
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class So2Bean {
				/**
				 * v : 3.6
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class TBean {
				/**
				 * v : -1
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class WBean {
				/**
				 * v : 1.8
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}

			public static class WdBean {
				/**
				 * v : 340
				 */

				@SerializedName("v")
				private double v;

				public double getV() {
					return v;
				}

				public void setV(double v) {
					this.v = v;
				}
			}
		}

		public static class TimeBean {
			/**
			 * s : 2017-12-13 16:00:00
			 * tz : +08:00
			 * v : 1513180800
			 */

			@SerializedName("s")
			private String s;
			@SerializedName("tz")
			private String tz;
			@SerializedName("v")
			private double v;

			public String getS() {
				return s;
			}

			public void setS(String s) {
				this.s = s;
			}

			public String getTz() {
				return tz;
			}

			public void setTz(String tz) {
				this.tz = tz;
			}

			public double getV() {
				return v;
			}

			public void setV(double v) {
				this.v = v;
			}
		}

		public static class AttributionsBean {
			/**
			 * url : http://www.bjmemc.com.cn/
			 * name : Beijing Environmental Protection Monitoring Center (北京市环境保护监测中心)
			 */

			@SerializedName("url")
			private String url;
			@SerializedName("name")
			private String name;

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
		}
	}
}
