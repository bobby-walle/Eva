/*
 * Create by BobEve on 17-12-19 上午10:43
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:58
 */

package bob.eve.walle.mvp.presenter.weather;

import android.util.Log;
import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.walle.ui.activity.MainActivity;
import bob.eve.walle.mvp.entity.Pm25InAQIDetailsEntity;
import bob.eve.walle.mvp.mapper.AqiDetailsFromPm25inMapper;
import bob.eve.walle.mvp.model.weather.Pm25inAQIDetailsModel;
import io.rx_cache2.Reply;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/14.
 */

@PreActivity
public class Pm25inAQIPresenter
		extends EveBasePresenter<MainActivity, Pm25inAQIDetailsModel, AqiDetailsFromPm25inMapper> {
	@Inject
	public Pm25inAQIPresenter(Pm25inAQIDetailsModel store, AqiDetailsFromPm25inMapper mapper) {
		super(store, mapper);
	}

	public void getAQIDetails() {
		store.execute(new EveRxErrorObserver<Reply<List<Pm25InAQIDetailsEntity>>>(view) {
			@Override
			public void onComplete() {
				Log.e(">>>>>>>>>", "AqicnAQIDetailsPresenter:onComplete");
			}

			@Override
			public void onNext(Reply<List<Pm25InAQIDetailsEntity>> replies) {

			}

			@Override
			public void onError(Throwable e) {
				Log.e(">>>>>>>>>", "AqicnAQIDetailsPresenter:onError\n" + e.getMessage());
			}
		}, Pm25inAQIDetailsModel.Params.forAqicnAQIDetails("beijing"));
	}
}
