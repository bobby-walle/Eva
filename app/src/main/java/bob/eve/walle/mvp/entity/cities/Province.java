/*
 * Create by BobEve on 17-12-14 下午2:08
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午4:28
 */

package bob.eve.walle.mvp.entity.cities;

import java.util.List;

/**
 * Created by Bob on 17/12/12.
 */

public class Province {
	private String name;
	private String code;
	private String pinyin;
	private String firstLetter;

	private List<City> cities;

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	@Override
	public String toString() {
		return "Province{" + "name='" + name + '\'' + ", code='" + code + '\'' + ", pinyin='" + pinyin +
					 '\'' + ", firstLetter='" + firstLetter + '\'' + ", cities=" + cities + '}';
	}
}
