/*
 * Create by BobEve on 17-12-19 上午12:15
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午12:15
 */

package bob.eve.walle.mvp.model.douban;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.cache.DouEveCacheService;
import bob.eve.walle.mvp.entity.douban.USBoxEntity;
import bob.eve.walle.mvp.service.DouEveService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class USBoxModel extends EveBaseModel<Reply<USBoxEntity>, USBoxModel.Params> {

	@Inject
	protected USBoxModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<USBoxEntity>> buildModelDataObservable(Params params) {
		return repositoryManager.obtainCacheService(DouEveCacheService.class)
														.getUSBox(repositoryManager.obtainRetrofitService(DouEveService.class)
																											 .getUSBox(), new DynamicKey(params.key),
																			new EvictDynamicKey(params.isEvictProvider()));
	}

	public static final class Params extends EveBaseModel.Params {
		private String key;

		private Params(String key) {
			this.key = key;
		}

		public static Params forCacheKey(String key) {
			return new Params(key);
		}

		@Override
		public Params setEvictProvider(boolean isEvictProvider) {
			this.isEvictProvider = isEvictProvider;
			return this;
		}
	}
}
