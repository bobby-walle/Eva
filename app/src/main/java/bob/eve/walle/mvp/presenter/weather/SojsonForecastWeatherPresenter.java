/*
 * Create by BobEve on 17-12-19 上午10:43
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:58
 */

package bob.eve.walle.mvp.presenter.weather;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.walle.ui.activity.MainActivity;
import bob.eve.walle.mvp.entity.SojsonWeatherEntity;
import bob.eve.walle.mvp.mapper.ForecastWeatherFromSojsonMapper;
import bob.eve.walle.mvp.model.bean.weather.ForecastWeathersCase;
import bob.eve.walle.mvp.model.weather.SojsonForecastWeatherModel;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class SojsonForecastWeatherPresenter extends
																						EveBasePresenter<MainActivity, SojsonForecastWeatherModel, ForecastWeatherFromSojsonMapper> {

	@Inject
	public SojsonForecastWeatherPresenter(SojsonForecastWeatherModel store,
																				ForecastWeatherFromSojsonMapper mapper) {
		super(store, mapper);
	}

	public void getForecastWeathers() {
		store.execute(new EveRxErrorObserver<Reply<SojsonWeatherEntity>>(view) {
			@Override
			public void onNext(Reply<SojsonWeatherEntity> o) {
				ForecastWeathersCase forecastWeathers = mapper.transform(o.getData());
			}

			@Override
			public void onError(Throwable e) {

			}
		}, SojsonForecastWeatherModel.Params.forSojsonWeather("北京"));
	}
}
