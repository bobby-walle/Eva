/*
 * Create by BobEve on 17-12-19 上午9:54
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午9:52
 */

package bob.eve.walle.mvp.model.gank;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.gank.GankItemEntity;
import bob.eve.walle.mvp.service.GankioService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */
@PreFragment
public class RandomGirlsModel extends EveBaseModel<GankItemEntity, RandomGirlsModel.Params> {

	@Inject
	protected RandomGirlsModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<GankItemEntity> buildModelDataObservable(Params params) {
		return repositoryManager.obtainRetrofitService(GankioService.class)
														.getRandomGirls(params.num);
	}

	public static final class Params {
		private int num;

		private Params(int num) {
			this.num = num;
		}

		public static Params forRandomGirls(int num) {
			return new Params(num);
		}
	}
}
