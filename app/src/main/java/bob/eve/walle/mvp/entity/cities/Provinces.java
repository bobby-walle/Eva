/*
 * Create by BobEve on 17-12-14 下午3:12
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午3:12
 */

package bob.eve.walle.mvp.entity.cities;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bob on 17/12/14.
 */

public class Provinces {
	List<Province> provinces;

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	@Override
	public String toString() {
		String string = provinces == null ? "" : Arrays.toString(provinces.toArray());
		return "Provinces{" + "provinces=" + string + '}';
	}
}
