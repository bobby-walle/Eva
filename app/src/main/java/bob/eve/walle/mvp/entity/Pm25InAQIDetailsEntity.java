/*
 * Create by BobEve on 17-12-13 下午4:53
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午4:53
 */

package bob.eve.walle.mvp.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bob on 17/12/13.
 */

public class Pm25InAQIDetailsEntity {

	/**
	 * aqi : 54
	 * area : 北京
	 * co : 0.8
	 * co_24h : 0.7
	 * no2 : 67
	 * no2_24h : 51
	 * o3 : 6
	 * o3_24h : 33
	 * o3_8h : 20
	 * o3_8h_24h : 20
	 * pm10 : 58
	 * pm10_24h : 42
	 * pm2_5 : 35
	 * pm2_5_24h : 27
	 * position_name : 万寿西宫
	 * primary_pollutant : 颗粒物(PM10)
	 * quality : 良
	 * so2 : 8
	 * so2_24h : 7
	 * station_code : 1001A
	 * time_podouble : 2017-12-13T17:00:00Z
	 */

	@SerializedName("aqi")
	private double aqi;
	@SerializedName("area")
	private String area;
	@SerializedName("co")
	private double co;
	@SerializedName("co_24h")
	private double co24h;
	@SerializedName("no2")
	private double no2;
	@SerializedName("no2_24h")
	private double no224h;
	@SerializedName("o3")
	private double o3;
	@SerializedName("o3_24h")
	private double o324h;
	@SerializedName("o3_8h")
	private double o38h;
	@SerializedName("o3_8h_24h")
	private double o38h24h;
	@SerializedName("pm10")
	private double pm10;
	@SerializedName("pm10_24h")
	private double pm1024h;
	@SerializedName("pm2_5")
	private double pm25;
	@SerializedName("pm2_5_24h")
	private double pm2524h;
	@SerializedName("position_name")
	private String positionName;
	@SerializedName("primary_pollutant")
	private String primaryPollutant;
	@SerializedName("quality")
	private String quality;
	@SerializedName("so2")
	private double so2;
	@SerializedName("so2_24h")
	private double so224h;
	@SerializedName("station_code")
	private String stationCode;
	@SerializedName("time_podouble")
	private String timePodouble;

	public double getAqi() {
		return aqi;
	}

	public void setAqi(double aqi) {
		this.aqi = aqi;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getCo() {
		return co;
	}

	public void setCo(double co) {
		this.co = co;
	}

	public double getCo24h() {
		return co24h;
	}

	public void setCo24h(double co24h) {
		this.co24h = co24h;
	}

	public double getNo2() {
		return no2;
	}

	public void setNo2(double no2) {
		this.no2 = no2;
	}

	public double getNo224h() {
		return no224h;
	}

	public void setNo224h(double no224h) {
		this.no224h = no224h;
	}

	public double getO3() {
		return o3;
	}

	public void setO3(double o3) {
		this.o3 = o3;
	}

	public double getO324h() {
		return o324h;
	}

	public void setO324h(double o324h) {
		this.o324h = o324h;
	}

	public double getO38h() {
		return o38h;
	}

	public void setO38h(double o38h) {
		this.o38h = o38h;
	}

	public double getO38h24h() {
		return o38h24h;
	}

	public void setO38h24h(double o38h24h) {
		this.o38h24h = o38h24h;
	}

	public double getPm10() {
		return pm10;
	}

	public void setPm10(double pm10) {
		this.pm10 = pm10;
	}

	public double getPm1024h() {
		return pm1024h;
	}

	public void setPm1024h(double pm1024h) {
		this.pm1024h = pm1024h;
	}

	public double getPm25() {
		return pm25;
	}

	public void setPm25(double pm25) {
		this.pm25 = pm25;
	}

	public double getPm2524h() {
		return pm2524h;
	}

	public void setPm2524h(double pm2524h) {
		this.pm2524h = pm2524h;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPrimaryPollutant() {
		return primaryPollutant;
	}

	public void setPrimaryPollutant(String primaryPollutant) {
		this.primaryPollutant = primaryPollutant;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public double getSo2() {
		return so2;
	}

	public void setSo2(double so2) {
		this.so2 = so2;
	}

	public double getSo224h() {
		return so224h;
	}

	public void setSo224h(double so224h) {
		this.so224h = so224h;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getTimePodouble() {
		return timePodouble;
	}

	public void setTimePodouble(String timePodouble) {
		this.timePodouble = timePodouble;
	}
}
