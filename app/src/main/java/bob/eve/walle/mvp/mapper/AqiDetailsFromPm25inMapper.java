/*
 * Create by BobEve on 17-12-14 下午1:35
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午1:35
 */

package bob.eve.walle.mvp.mapper;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.mapper.AbsEntityToModelMapper;
import bob.eve.walle.mvp.entity.Pm25InAQIDetailsEntity;
import bob.eve.walle.mvp.model.bean.weather.AQIDetailsCase;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class AqiDetailsFromPm25inMapper
		extends AbsEntityToModelMapper<Pm25InAQIDetailsEntity, AQIDetailsCase> {
	
	@Inject
	public AqiDetailsFromPm25inMapper() {
	}

	@Override
	public AQIDetailsCase transform(Pm25InAQIDetailsEntity pm25InAQIDetailsEntity) {
		final AQIDetailsCase aqiDetailsCase = new AQIDetailsCase();
		if (pm25InAQIDetailsEntity == null) {
			return aqiDetailsCase;
		}

		aqiDetailsCase.setCity(pm25InAQIDetailsEntity.getArea());
		aqiDetailsCase.setStation(pm25InAQIDetailsEntity.getPositionName());
		aqiDetailsCase.setDominentpol(pm25InAQIDetailsEntity.getPrimaryPollutant());
		aqiDetailsCase.setTime(pm25InAQIDetailsEntity.getTimePodouble());
		aqiDetailsCase.setAqi(pm25InAQIDetailsEntity.getAqi());
		aqiDetailsCase.setPm25(pm25InAQIDetailsEntity.getPm25());
		aqiDetailsCase.setPm10(pm25InAQIDetailsEntity.getPm10());
		aqiDetailsCase.setO3(pm25InAQIDetailsEntity.getO3());
		aqiDetailsCase.setNo2(pm25InAQIDetailsEntity.getNo2());
		aqiDetailsCase.setSo2(pm25InAQIDetailsEntity.getSo2());
		aqiDetailsCase.setCo(pm25InAQIDetailsEntity.getCo());

		return aqiDetailsCase;
	}
}
