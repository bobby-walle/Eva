/*
 * Create by BobEve on 17-12-18 上午11:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午9:50
 */

package bob.eve.walle.mvp.model.bean.weather;

/**
 * Created by Bob on 17/12/14.
 *
 * 关注的城市
 */

public class ChooseCitiesCase {
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
}
