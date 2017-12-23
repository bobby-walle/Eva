/*
 * Create by BobEve on 17-12-18 下午12:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午12:01
 */

package bob.eve.walle.mvp.model.zhihu;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.zhihu.ZhihuLatestsEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuLatestsModel
		extends EveBaseModel<Reply<ZhihuLatestsEntity>, ZhihuLatestsModel.Params> {

	@Inject
	protected ZhihuLatestsModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<ZhihuLatestsEntity>> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private String cacheKey;

		private Params(String cacheKey) {
			this.cacheKey = cacheKey;
		}

		public static ZhihuLatestsModel.Params forCacheKey(String cacheKey) {
			return new ZhihuLatestsModel.Params(cacheKey);
		}
	}
}
