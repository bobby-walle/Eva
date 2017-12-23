/*
 * Create by BobEve on 17-12-18 上午11:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午9:50
 */

package bob.eve.walle.mvp.model.bean.weather;

/**
 * Created by Bob on 17/12/14.
 */

public class AQIDetailsCase {
	// 城市名称
	private String city;
	// 定位点或者观察点名称
	private String station;
	// 数据时间
	private String time;
	// 主要污染物
	private String dominentpol;
	private double aqi;
	// CO 一氧化碳
	private double co;
	// Dew 露
	private double dew;
	// Humidity 湿度
	private double humidity;
	// NO2 二氧化氮
	private double no2;
	// O3 臭氧
	private double o3;
	// PM10 可吸入颗粒物
	private double pm10;
	// PM25 细颗粒物
	private double pm25;
	// SO2 二氧化硫
	private double so2;
	// Temp 温度
	private double temp;
	// Wind 风
	private double wind;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDominentpol() {
		return dominentpol;
	}

	public void setDominentpol(String dominentpol) {
		this.dominentpol = dominentpol;
	}

	public double getAqi() {
		return aqi;
	}

	public void setAqi(double aqi) {
		this.aqi = aqi;
	}

	public double getCo() {
		return co;
	}

	public void setCo(double co) {
		this.co = co;
	}

	public double getDew() {
		return dew;
	}

	public void setDew(double dew) {
		this.dew = dew;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getNo2() {
		return no2;
	}

	public void setNo2(double no2) {
		this.no2 = no2;
	}

	public double getO3() {
		return o3;
	}

	public void setO3(double o3) {
		this.o3 = o3;
	}

	public double getPm10() {
		return pm10;
	}

	public void setPm10(double pm10) {
		this.pm10 = pm10;
	}

	public double getPm25() {
		return pm25;
	}

	public void setPm25(double pm25) {
		this.pm25 = pm25;
	}

	public double getSo2() {
		return so2;
	}

	public void setSo2(double so2) {
		this.so2 = so2;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getWind() {
		return wind;
	}

	public void setWind(double wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "AQIDataCase{" + "city='" + city + '\'' + "station='" + station + '\'' + ", time='" +
					 time + '\'' + ", dominentpol='" + dominentpol + '\'' + ", aqi=" + aqi + ", co=" + co +
					 ", dew=" + dew + ", humidity=" + humidity + ", no2=" + no2 + ", o3=" + o3 + ", pm10=" +
					 pm10 + ", pm25=" + pm25 + ", so2=" + so2 + ", temp=" + temp + ", wind=" + wind + '}';
	}
}
