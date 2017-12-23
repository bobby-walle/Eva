/*
 * Create by BobEve on 17-12-18 上午11:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午7:15
 */

package bob.eve.walle.mvp.model.weather;

import bob.eve.comm.lib.util.LocationUtils;
import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.app.Constants;
import bob.eve.walle.mvp.entity.AqicnAQIDetailsEntity;
import bob.eve.walle.mvp.service.AqicnService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class AqicnAQIDetailsModel
		extends EveBaseModel<AqicnAQIDetailsEntity, AqicnAQIDetailsModel.Params> {

	@Inject
	protected AqicnAQIDetailsModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<AqicnAQIDetailsEntity> buildModelDataObservable(final Params params) {
		return repositoryManager.obtainRetrofitService(AqicnService.class)
														.getAQIDetailsForCity(params.lat, params.lng, Constants.AQICN_TOKEN);
		/*final AqicnCacheService aqicnCacheService =
				repositoryManager.obtainCacheService(AqicnCacheService.class);
		final AqicnService aqicnService = repositoryManager.obtainRetrofitService(AqicnService.class);
		return aqicnCacheService.getAQIStationsForCity(
				aqicnService.getAQIStationsForCity(params.city, Constants.AQICN_TOKEN),
				new DynamicKey(params.city), new EvictProvider(false))
														.flatMap(
																new Function<Reply<AqicnStationsEntiry>, ObservableSource<AqicnStationsEntiry.DataBean>>() {
																	@Override
																	public ObservableSource<AqicnStationsEntiry.DataBean> apply(
																			Reply<AqicnStationsEntiry> aqicnStationsEntiryReply)
																			throws Exception {
																		final List<AqicnStationsEntiry.DataBean> stations;
																		if (aqicnStationsEntiryReply == null) {
																			stations = Collections.emptyList();
																			return Observable.fromIterable(stations);
																		}

																		AqicnStationsEntiry aqicnStations =
																				aqicnStationsEntiryReply.getData();
																		if (aqicnStations == null) {
																			stations = Collections.emptyList();
																			return Observable.fromIterable(stations);
																		}

																		stations = aqicnStations.getData();
																		return Observable.fromIterable(stations);
																	}
																})
														.map(
																new Function<AqicnStationsEntiry.DataBean, AqicnStationsEntiry.DataBean.StationBean>() {
																	@Override
																	public AqicnStationsEntiry.DataBean.StationBean apply(
																			AqicnStationsEntiry.DataBean dataBean) throws Exception {
																		return dataBean.getStation();
																	}
																})
														.map(
																new Function<AqicnStationsEntiry.DataBean.StationBean, Observable<AqicnAQIDetailsEntity>>() {
																	@Override
																	public Observable<AqicnAQIDetailsEntity> apply(
																			AqicnStationsEntiry.DataBean.StationBean stationBean)
																			throws Exception {
																		List<Double> geo = stationBean.getGeo();
																		return aqicnService.getAQIDetailsForCity(geo.get(0), geo.get(1),
																																						 Constants.AQICN_TOKEN);
																	}
																})
														.collect(new Callable<List<AqicnAQIDetailsEntity>>() {
																			 @Override
																			 public List<AqicnAQIDetailsEntity> call() throws Exception {
																				 return new ArrayList<>();
																			 }
																		 },
																		 new BiConsumer<List<AqicnAQIDetailsEntity>, Observable<AqicnAQIDetailsEntity>>() {
																			 @Override
																			 public void accept(
																					 final List<AqicnAQIDetailsEntity> aqicnAQIDetailsEntities,
																					 Observable<AqicnAQIDetailsEntity> aqicnAQIDetailsEntityObservable)
																					 throws Exception {
																				 aqicnAQIDetailsEntityObservable.subscribe(
																						 new Consumer<AqicnAQIDetailsEntity>() {
																							 @Override
																							 public void accept(
																									 AqicnAQIDetailsEntity aqicnAQIDetailsEntity)
																									 throws Exception {
																								 aqicnAQIDetailsEntities.add(aqicnAQIDetailsEntity);
																							 }
																						 });
																			 }
																		 })
														.flatMapObservable(
																new Function<List<AqicnAQIDetailsEntity>, Observable<List<AqicnAQIDetailsEntity>>>() {
																	@Override
																	public Observable<List<AqicnAQIDetailsEntity>> apply(
																			List<AqicnAQIDetailsEntity> replies) throws Exception {
																		return Observable.just(replies);
																	}
																});*/
	}

	public static final class Params {
		private final double lat;
		private final double lng;

		private Params(double lat, double lng) {
			this.lat = lat;
			this.lng = lng;
		}

		public static AqicnAQIDetailsModel.Params forAqicnAQIDetails(double lat, double lng) {
			return new AqicnAQIDetailsModel.Params(lat, lng);
		}
	}
}
