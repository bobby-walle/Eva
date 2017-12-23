/*
 * Create by BobEve on 17-12-14 下午1:38
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午1:38
 */

package bob.eve.walle.mvp.mapper;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.mapper.AbsEntityToModelMapper;
import bob.eve.walle.mvp.entity.AqicnAQIDetailsEntity;
import bob.eve.walle.mvp.model.bean.weather.AQIDetailsCase;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class AqiDetailsFromAqicnMapper
		extends AbsEntityToModelMapper<AqicnAQIDetailsEntity, AQIDetailsCase> {
	@Inject
	public AqiDetailsFromAqicnMapper() {
	}

	@Override
	public AQIDetailsCase transform(AqicnAQIDetailsEntity aqicnAQIDetailsEntity) {
		final AQIDetailsCase aqiDetailsCase = new AQIDetailsCase();
		if (aqicnAQIDetailsEntity == null) {
			return aqiDetailsCase;
		}
		AqicnAQIDetailsEntity.DataBean dataBean = aqicnAQIDetailsEntity.getData();
		if (dataBean != null) {
			aqiDetailsCase.setAqi(dataBean.getAqi());
			aqiDetailsCase.setDominentpol(dataBean.getDominentpol());
		}

		AqicnAQIDetailsEntity.DataBean.CityBean cityBean = dataBean.getCity();
		if (cityBean != null) { // 观察点，未必是城市
			aqiDetailsCase.setStation(cityBean.getName());
		}

		AqicnAQIDetailsEntity.DataBean.TimeBean timeBean = dataBean.getTime();
		if (timeBean != null) {
			aqiDetailsCase.setTime(timeBean.getS());
		}

		AqicnAQIDetailsEntity.DataBean.IaqiBean iaqiBean = dataBean.getIaqi();
		if (iaqiBean != null) {

			aqiDetailsCase.setPm25(iaqiBean.getPm25()
																		 .getV());
			aqiDetailsCase.setPm10(iaqiBean.getPm10()
																		 .getV());
			aqiDetailsCase.setO3(iaqiBean.getO3()
																	 .getV());
			aqiDetailsCase.setNo2(iaqiBean.getNo2()
																		.getV());
			aqiDetailsCase.setSo2(iaqiBean.getSo2()
																		.getV());
			aqiDetailsCase.setCo(iaqiBean.getCo()
																	 .getV());
			aqiDetailsCase.setDew(iaqiBean.getD()
																		.getV());
			aqiDetailsCase.setHumidity(iaqiBean.getH()
																				 .getV());
			aqiDetailsCase.setTemp(iaqiBean.getT()
																		 .getV());
			aqiDetailsCase.setWind(iaqiBean.getW()
																		 .getV());
		}

		return aqiDetailsCase;
	}
}
