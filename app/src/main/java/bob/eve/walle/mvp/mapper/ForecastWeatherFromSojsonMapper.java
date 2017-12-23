/*
 * Create by BobEve on 17-12-14 下午1:09
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午1:09
 */

package bob.eve.walle.mvp.mapper;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.mapper.AbsEntityToModelMapper;
import bob.eve.walle.mvp.entity.SojsonWeatherEntity;
import bob.eve.walle.mvp.model.bean.weather.ForecastWeathersCase;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class ForecastWeatherFromSojsonMapper
		extends AbsEntityToModelMapper<SojsonWeatherEntity, ForecastWeathersCase> {

	@Inject
	public ForecastWeatherFromSojsonMapper() {
	}

	@Override
	public ForecastWeathersCase transform(SojsonWeatherEntity sojsonWeatherEntity) {
		final ForecastWeathersCase forecastWeathersCase = new ForecastWeathersCase();
		if (sojsonWeatherEntity == null) {
			return forecastWeathersCase;
		}

		forecastWeathersCase.setCity(sojsonWeatherEntity.getCity());
		forecastWeathersCase.setTime(sojsonWeatherEntity.getDate());
		SojsonWeatherEntity.DataBean sojsonDataBean = sojsonWeatherEntity.getData();

		if (sojsonDataBean == null) {
			return forecastWeathersCase;
		}
		List<SojsonWeatherEntity.DataBean.ForecastBean> forecastes = sojsonDataBean.getForecast();
		if (forecastes == null || forecastes.isEmpty()) {
			return forecastWeathersCase;
		}
		final ForecastWeatherListMapper mapper = new ForecastWeatherListMapper();
		List<ForecastWeathersCase.ForecastWeather> forecastWeathers =
				(List<ForecastWeathersCase.ForecastWeather>) mapper.transform(forecastes);

		forecastWeathersCase.setForecastWeatheres(forecastWeathers);

		return forecastWeathersCase;
	}

	private class ForecastWeatherListMapper extends
																					AbsEntityToModelMapper<SojsonWeatherEntity.DataBean.ForecastBean, ForecastWeathersCase.ForecastWeather> {

		@Override
		public ForecastWeathersCase.ForecastWeather transform(
				SojsonWeatherEntity.DataBean.ForecastBean forecastBean) {
			final ForecastWeathersCase.ForecastWeather forecastWeather =
					new ForecastWeathersCase.ForecastWeather();
			if (forecastBean == null) {
				return forecastWeather;
			}

			forecastWeather.setAqi(forecastBean.getAqi());
			forecastWeather.setDate(forecastBean.getDate());
			forecastWeather.setFl(forecastBean.getFl());
			forecastWeather.setFx(forecastBean.getFx());
			forecastWeather.setHigh(forecastBean.getHigh());
			forecastWeather.setLow(forecastBean.getLow());
			forecastWeather.setNotice(forecastBean.getNotice());
			forecastWeather.setSunrise(forecastBean.getSunrise());
			forecastWeather.setSunset(forecastBean.getSunset());
			forecastWeather.setType(forecastBean.getType());

			return forecastWeather;
		}
	}
}
