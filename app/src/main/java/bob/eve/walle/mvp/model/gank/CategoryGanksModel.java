/*
 * Create by BobEve on 17-12-19 上午9:49
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午12:13
 */

package bob.eve.walle.mvp.model.gank;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.cache.GankioCacheService;
import bob.eve.walle.mvp.entity.gank.GankItemEntity;
import bob.eve.walle.mvp.service.GankioService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */
@PreFragment
public class CategoryGanksModel
		extends EveBaseModel<Reply<GankItemEntity>, CategoryGanksModel.Params> {

	@Inject
	protected CategoryGanksModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<GankItemEntity>> buildModelDataObservable(Params params) {
		return repositoryManager.obtainCacheService(GankioCacheService.class)
														.getGanksWithCategory(
																repositoryManager.obtainRetrofitService(GankioService.class)
																								 .getGanksWithCategory(params.category, params.num,
																																			 params.page),
																new DynamicKey(params.category + DYNAMICKEY_SPLIT + params.page),
																new EvictDynamicKey(params.isEvictProvider()));
	}

	public static final class Params extends EveBaseModel.Params<Params> {
		String category;
		int num;
		int page;

		private Params(String category, int num, int page) {

			this.category = category;
			this.num = num;
			this.page = page;
		}

		public static Params forCategoryGanks(String category, int num, int page) {
			return new Params(category, num, page);
		}

		@Override
		public Params setEvictProvider(boolean isEvictProvider) {
			this.isEvictProvider = isEvictProvider;
			return this;
		}
	}
}
