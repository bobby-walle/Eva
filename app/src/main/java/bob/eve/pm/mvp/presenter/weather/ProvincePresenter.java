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
import bob.eve.pm.ui.activity.MainActivity;
import bob.eve.pm.mvp.entity.cities.Province;
import bob.eve.pm.mvp.mapper.ProvinceMapper;
import bob.eve.pm.mvp.model.weather.ProvinceModel;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/12.
 */

@PreActivity
public class ProvincePresenter
		extends EveBasePresenter<MainActivity, ProvinceModel, ProvinceMapper> {

	@Inject
	public ProvincePresenter(ProvinceModel store, ProvinceMapper mapper) {
		super(store, mapper);
	}

	public void getProvinces() {
		store.execute(new EveRxErrorObserver<List<Province>>(view) {
			@Override
			public void onComplete() {
				view.complete();
			}

			@Override
			public void onNext(List<Province> provinces) {

			}

			@Override
			public void onError(Throwable e) {

			}
		}, ProvinceModel.Params.forUser(1));
	}
}
