/*
 * Create by BobEve on 17-12-18 上午11:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午9:30
 */

package bob.eve.walle.mvp.model.weather;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.SojsonWeatherEntity;
import bob.eve.walle.mvp.cache.SojsonWeatherCacheService;
import bob.eve.walle.mvp.service.SojsonWeatherService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class SojsonForecastWeatherModel
		extends EveBaseModel<Reply<SojsonWeatherEntity>, SojsonForecastWeatherModel.Params> {

	@Inject
	protected SojsonForecastWeatherModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<SojsonWeatherEntity>> buildModelDataObservable(Params params) {
		return repositoryManager.obtainCacheService(SojsonWeatherCacheService.class)
														.getForecastWeathersFromSojson(
																repositoryManager.obtainRetrofitService(SojsonWeatherService.class)
																								 .getForecastWeathersFromSojson(params.city),
																new DynamicKey(params.city), new EvictProvider(false));
	}

	public static final class Params {

		private String city;

		private Params(String city) {
			this.city = city;
		}

		public static SojsonForecastWeatherModel.Params forSojsonWeather(String city) {
			return new Params(city);
		}
	}
}
