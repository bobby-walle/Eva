/*
 * Create by BobEve on 17-12-19 上午12:15
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午12:13
 */

package bob.eve.walle.mvp.model.douban;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.cache.DouEveCacheService;
import bob.eve.walle.mvp.entity.douban.Top250Entity;
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

public class Top250Model extends EveBaseModel<Reply<Top250Entity>, Top250Model.Params> {

	@Inject
	protected Top250Model(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<Top250Entity>> buildModelDataObservable(Params params) {
		return repositoryManager.obtainCacheService(DouEveCacheService.class)
														.getTop250Movies(
																repositoryManager.obtainRetrofitService(DouEveService.class)
																								 .getTop250Movies(params.page),
																new DynamicKey(params.page),
																new EvictDynamicKey(params.isEvictProvider()));
	}

	public static final class Params extends EveBaseModel.Params {
		private int page;

		private Params(int page) {
			this.page = page;
		}

		public static Params forPage(int page) {
			return new Params(page);
		}

		@Override
		public Params setEvictProvider(boolean isEvictProvider) {
			this.isEvictProvider = isEvictProvider;
			return this;
		}
	}
}
