/*
 * Create by BobEve on 17-12-14 下午2:08
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-13 下午4:28
 */

package bob.eve.walle.mvp.entity.cities;

/**
 * Created by Bob on 17/12/12.
 */

public class County {
	private String name;
	private String code;
	private String pinyin;
	private String firstLetter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return "County{" + "name='" + name + '\'' + ", code='" + code + '\'' + ", pinyin='" + pinyin +
					 '\'' + ", firstLetter='" + firstLetter + '\'' + '}';
	}
}
