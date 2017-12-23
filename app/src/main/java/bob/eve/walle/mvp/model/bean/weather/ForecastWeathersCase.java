/*
 * Create by BobEve on 17-12-18 上午11:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午9:50
 */

package bob.eve.walle.mvp.model.bean.weather;

import java.util.List;

/**
 * Created by Bob on 17/12/14.
 */

public class ForecastWeathersCase {
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

	private String city;
	private String time;
	private List<ForecastWeather> forecastWeatheres;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<ForecastWeather> getForecastWeatheres() {
		return forecastWeatheres;
	}

	public void setForecastWeatheres(List<ForecastWeather> forecastWeatheres) {
		this.forecastWeatheres = forecastWeatheres;
	}

	@Override
	public String toString() {
		String f = forecastWeatheres == null ? "" : forecastWeatheres.toString();
		return "ForecastWeatherDataCase{" + "city='" + city + '\'' + ", time='" + time + '\'' +
					 ", forecastWeatheres=" + f + '}';
	}

	public static class ForecastWeather {
		private String date;
		private String sunrise;
		private String high;
		private String low;
		private String sunset;
		private double aqi;
		private String fx;
		private String fl;
		private String type;
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

		@Override
		public String toString() {
			return "ForecastWeatheres{" + "date='" + date + '\'' + ", sunrise='" + sunrise + '\'' +
						 ", high='" + high + '\'' + ", low='" + low + '\'' + ", sunset='" + sunset + '\'' +
						 ", aqi=" + aqi + ", fx='" + fx + '\'' + ", fl='" + fl + '\'' + ", type='" + type +
						 '\'' + ", notice='" + notice + '\'' + '}';
		}
	}
}
