/*
 * Create by BobEve on 17-12-19 上午10:43
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:58
 */

package bob.eve.pm.mvp.presenter.weather;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.pm.mvp.entity.AqicnAQIDetailsEntity;
import bob.eve.pm.mvp.mapper.AqiDetailsFromAqicnMapper;
import bob.eve.pm.mvp.model.weather.AqicnAQIDetailsModel;
import bob.eve.pm.ui.activity.MainActivity;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class AqicnAQIDetailsPresenter
		extends EveBasePresenter<MainActivity, AqicnAQIDetailsModel, AqiDetailsFromAqicnMapper> {
	@Inject
	public AqicnAQIDetailsPresenter(AqicnAQIDetailsModel store, AqiDetailsFromAqicnMapper mapper) {
		super(store, mapper);
	}

	public void getAQIDetail(double lat, double lng) {
		store.execute(new EveRxErrorObserver<AqicnAQIDetailsEntity>(view) {
			@Override
			public void onNext(AqicnAQIDetailsEntity aqicnAQIDetailsEntities) {

			}
		}, AqicnAQIDetailsModel.Params.forAqicnAQIDetails(lat, lng));
	}
	/*public void getAQIDetails() {
		store.execute(new EveRxErrorObserver<List<AqicnAQIDetailsEntity>>(view) {
			@Override
			public void onComplete() {
				Log.e(">>>>>>>>>", "AqicnAQIDetailsPresenter:onComplete");
			}

			@Override
			public void onNext(List<AqicnAQIDetailsEntity> replies) {

			}

			@Override
			public void onError(Throwable e) {
				Log.e(">>>>>>>>>", "AqicnAQIDetailsPresenter:onError\n" + e.getMessage());
			}
		}, AqicnAQIDetailsModel.Params.forAqicnAQIDetails("beijing"));
	}*/
}
