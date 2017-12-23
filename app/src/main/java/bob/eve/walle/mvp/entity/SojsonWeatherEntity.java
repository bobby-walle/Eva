/*
 * Create by BobEve on 17-12-13 下午10:27
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午10:27
 */

package bob.eve.walle.mvp.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Bob on 17/12/13.
 */

public class SojsonWeatherEntity {

	/**
	 * date : 20171213
	 * message : Success !
	 * status : 200
	 * city : 北京
	 * count : 69
	 * data : {"shidu":"28%","pm25":27,"pm10":53,"quality":"良","wendu":"-7","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"12日星期二","sunrise":"07:26","high":"高温
	 * -1.0℃","low":"低温 -8.0℃","sunset":"16:50","aqi":25,"fx":"东风","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"},"forecast":[{"date":"13日星期三","sunrise":"07:26","high":"高温
	 * 0.0℃","low":"低温 -7.0℃","sunset":"16:50","aqi":47,"fx":"东风","fl":"<3级","type":"晴","notice":"lovely
	 * sunshine，尽情享受阳光的温暖吧"},{"date":"14日星期四","sunrise":"07:27","high":"高温 -1.0℃","low":"低温
	 * -5.0℃","sunset":"16:50","aqi":70,"fx":"南风","fl":"<3级","type":"阴","notice":"阴天是彩虹的前期之景"},{"date":"15日星期五","sunrise":"07:28","high":"高温
	 * 4.0℃","low":"低温 -5.0℃","sunset":"16:50","aqi":57,"fx":"西北风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"16日星期六","sunrise":"07:29","high":"高温
	 * 2.0℃","low":"低温 -7.0℃","sunset":"16:50","aqi":30,"fx":"西北风","fl":"3-4级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"17日星期日","sunrise":"07:29","high":"高温
	 * 5.0℃","low":"低温 -6.0℃","sunset":"16:51","aqi":81,"fx":"西南风","fl":"<3级","type":"晴","notice":"lovely
	 * sunshine，尽情享受阳光的温暖吧"}]}
	 */

	@SerializedName("date")
	private String date;
	@SerializedName("message")
	private String message;
	@SerializedName("status")
	private double status;
	@SerializedName("city")
	private String city;
	@SerializedName("count")
	private double count;
	@SerializedName("data")
	private DataBean data;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getStatus() {
		return status;
	}

	public void setStatus(double status) {
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * shidu : 28%
		 * pm25 : 27
		 * pm10 : 53
		 * quality : 良
		 * wendu : -7
		 * ganmao : 极少数敏感人群应减少户外活动
		 * yesterday : {"date":"12日星期二","sunrise":"07:26","high":"高温 -1.0℃","low":"低温
		 * -8.0℃","sunset":"16:50","aqi":25,"fx":"东风","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"}
		 * forecast : [{"date":"13日星期三","sunrise":"07:26","high":"高温 0.0℃","low":"低温
		 * -7.0℃","sunset":"16:50","aqi":47,"fx":"东风","fl":"<3级","type":"晴","notice":"lovely
		 * sunshine，尽情享受阳光的温暖吧"},{"date":"14日星期四","sunrise":"07:27","high":"高温 -1.0℃","low":"低温
		 * -5.0℃","sunset":"16:50","aqi":70,"fx":"南风","fl":"<3级","type":"阴","notice":"阴天是彩虹的前期之景"},{"date":"15日星期五","sunrise":"07:28","high":"高温
		 * 4.0℃","low":"低温 -5.0℃","sunset":"16:50","aqi":57,"fx":"西北风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"16日星期六","sunrise":"07:29","high":"高温
		 * 2.0℃","low":"低温 -7.0℃","sunset":"16:50","aqi":30,"fx":"西北风","fl":"3-4级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"17日星期日","sunrise":"07:29","high":"高温
		 * 5.0℃","low":"低温 -6.0℃","sunset":"16:51","aqi":81,"fx":"西南风","fl":"<3级","type":"晴","notice":"lovely
		 * sunshine，尽情享受阳光的温暖吧"}]
		 */

		@SerializedName("shidu")
		private String shidu;
		@SerializedName("pm25")
		private double pm25;
		@SerializedName("pm10")
		private double pm10;
		@SerializedName("quality")
		private String quality;
		@SerializedName("wendu")
		private String wendu;
		@SerializedName("ganmao")
		private String ganmao;
		@SerializedName("yesterday")
		private YesterdayBean yesterday;
		@SerializedName("forecast")
		private List<ForecastBean> forecast;

		public String getShidu() {
			return shidu;
		}

		public void setShidu(String shidu) {
			this.shidu = shidu;
		}

		public double getPm25() {
			return pm25;
		}

		public void setPm25(double pm25) {
			this.pm25 = pm25;
		}

		public double getPm10() {
			return pm10;
		}

		public void setPm10(double pm10) {
			this.pm10 = pm10;
		}

		public String getQuality() {
			return quality;
		}

		public void setQuality(String quality) {
			this.quality = quality;
		}

		public String getWendu() {
			return wendu;
		}

		public void setWendu(String wendu) {
			this.wendu = wendu;
		}

		public String getGanmao() {
			return ganmao;
		}

		public void setGanmao(String ganmao) {
			this.ganmao = ganmao;
		}

		public YesterdayBean getYesterday() {
			return yesterday;
		}

		public void setYesterday(YesterdayBean yesterday) {
			this.yesterday = yesterday;
		}

		public List<ForecastBean> getForecast() {
			return forecast;
		}

		public void setForecast(List<ForecastBean> forecast) {
			this.forecast = forecast;
		}

		public static class YesterdayBean {
			/**
			 * date : 12日星期二
			 * sunrise : 07:26
			 * high : 高温 -1.0℃
			 * low : 低温 -8.0℃
			 * sunset : 16:50
			 * aqi : 25
			 * fx : 东风
			 * fl : <3级
			 * type : 多云
			 * notice : 绵绵的云朵，形状千变万化
			 */

			@SerializedName("date")
			private String date;
			@SerializedName("sunrise")
			private String sunrise;
			@SerializedName("high")
			private String high;
			@SerializedName("low")
			private String low;
			@SerializedName("sunset")
			private String sunset;
			@SerializedName("aqi")
			private double aqi;
			@SerializedName("fx")
			private String fx;
			@SerializedName("fl")
			private String fl;
			@SerializedName("type")
			private String type;
			@SerializedName("notice")
			private String notice;

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getSunrise() {
				return sunrise;
			}

			public void setSunrise(String sunrise) {
				this.sunrise = sunrise;
			}

			public String getHigh() {
				return high;
			}

			public void setHigh(String high) {
				this.high = high;
			}

			public String getLow() {
				return low;
			}

			public void setLow(String low) {
				this.low = low;
			}

			public String getSunset() {
				return sunset;
			}

			public void setSunset(String sunset) {
				this.sunset = sunset;
			}

			public double getAqi() {
				return aqi;
			}

			public void setAqi(double aqi) {
				this.aqi = aqi;
			}

			public String getFx() {
				return fx;
			}

			public void setFx(String fx) {
				this.fx = fx;
			}

			public String getFl() {
				return fl;
			}

			public void setFl(String fl) {
				this.fl = fl;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getNotice() {
				return notice;
			}

			public void setNotice(String notice) {
				this.notice = notice;
			}
		}

		public static class ForecastBean {
			/**
			 * date : 13日星期三
			 * sunrise : 07:26
			 * high : 高温 0.0℃
			 * low : 低温 -7.0℃
			 * sunset : 16:50
			 * aqi : 47
			 * fx : 东风
			 * fl : <3级
			 * type : 晴
			 * notice : lovely sunshine，尽情享受阳光的温暖吧
			 */

			@SerializedName("date")
			private String date;
			@SerializedName("sunrise")
			private String sunrise;
			@SerializedName("high")
			private String high;
			@SerializedName("low")
			private String low;
			@SerializedName("sunset")
			private String sunset;
			@SerializedName("aqi")
			private double aqi;
			@SerializedName("fx")
			private String fx;
			@SerializedName("fl")
			private String fl;
			@SerializedName("type")
			private String type;
			@SerializedName("notice")
			private String notice;

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getSunrise() {
				return sunrise;
			}

			public void setSunrise(String sunrise) {
				this.sunrise = sunrise;
			}

			public String getHigh() {
				return high;
			}

			public void setHigh(String high) {
				this.high = high;
			}

			public String getLow() {
				return low;
			}

			public void setLow(String low) {
				this.low = low;
			}

			public String getSunset() {
				return sunset;
			}

			public void setSunset(String sunset) {
				this.sunset = sunset;
			}

			public double getAqi() {
				return aqi;
			}

			public void setAqi(double aqi) {
				this.aqi = aqi;
			}

			public String getFx() {
				return fx;
			}

			public void setFx(String fx) {
				this.fx = fx;
			}

			public String getFl() {
				return fl;
			}

			public void setFl(String fl) {
				this.fl = fl;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getNotice() {
				return notice;
			}

			public void setNotice(String notice) {
				this.notice = notice;
			}
		}
	}
}
