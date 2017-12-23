/*
 * Create by BobEve on 17-12-19 上午12:10
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:59
 */

package bob.eve.walle.mvp.model.tian;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.app.Constants;
import bob.eve.walle.mvp.cache.TianApiCacheService;
import bob.eve.walle.mvp.entity.tian.TianGirlEntity;
import bob.eve.walle.mvp.service.TianApiService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class TianGirlsModel extends EveBaseModel<Reply<TianGirlEntity>, TianGirlsModel.Params> {

	@Inject
	protected TianGirlsModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<TianGirlEntity>> buildModelDataObservable(Params params) {
		return repositoryManager.obtainCacheService(TianApiCacheService.class)
														.getTianGirls(
																repositoryManager.obtainRetrofitService(TianApiService.class)
																								 .getTianGirls(Constants.TIAN_XING_KEY, params.num,
																															 params.page),
																new DynamicKey(params.page + DYNAMICKEY_SPLIT + params.num),
																new EvictDynamicKey(params.isEvictProvider()));
	}

	public static final class Params extends EveBaseModel.Params<Params> {
		private int num;
		private int page;
		private String key = Constants.TIAN_XING_KEY;

		private Params(int num, int page) {
			this.num = num;
			this.page = page;
		}

		public static Params forTianGirls(int num, int page) {
			return new Params(num, page);
		}

		@Override
		public Params setEvictProvider(boolean isEvictProvider) {
			this.isEvictProvider = isEvictProvider;
			return this;
		}
	}
}
