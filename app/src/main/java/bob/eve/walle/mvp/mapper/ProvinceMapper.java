/*
 * Create by BobEve on 17-12-12 下午8:31
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午8:31
 */

package bob.eve.walle.mvp.mapper;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.mapper.AbsEntityToModelMapper;
import bob.eve.walle.mvp.entity.cities.Province;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/12.
 */

@PreActivity
public class ProvinceMapper extends AbsEntityToModelMapper<Province, Province> {
	@Inject
	public ProvinceMapper() {
	}

	@Override
	public Province transform(Province province) {
		return province;
	}
}
