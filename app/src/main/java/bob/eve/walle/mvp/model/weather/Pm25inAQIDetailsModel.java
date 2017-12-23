/*
 * Create by BobEve on 17-12-18 上午11:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午9:11
 */

package bob.eve.walle.mvp.model.weather;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.app.Constants;
import bob.eve.walle.mvp.entity.Pm25InAQIDetailsEntity;
import bob.eve.walle.mvp.cache.Pm25InCacheService;
import bob.eve.walle.mvp.service.Pm25InService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class Pm25inAQIDetailsModel
		extends EveBaseModel<Reply<List<Pm25InAQIDetailsEntity>>, Pm25inAQIDetailsModel.Params> {

	@Inject
	protected Pm25inAQIDetailsModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<List<Pm25InAQIDetailsEntity>>> buildModelDataObservable(
			Params params) {
		return repositoryManager.obtainCacheService(Pm25InCacheService.class)
														.getAQIDetailsForCity(
																repositoryManager.obtainRetrofitService(Pm25InService.class)
																								 .getAQIDetailsForCity(params.city,
																																			 Constants.PM25IN_PUBLIC_KEY),
																new DynamicKey(params.city), new EvictProvider(false));
	}

	public static final class Params {
		private String city;

		private Params(String city) {
			this.city = city;
		}

		public static Pm25inAQIDetailsModel.Params forAqicnAQIDetails(String city) {
			return new Pm25inAQIDetailsModel.Params(city);
		}
	}
}
