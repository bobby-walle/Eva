/*
 * Create by BobEve on 17-12-18 下午12:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午12:01
 */

package bob.eve.walle.mvp.model.zhihu;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.zhihu.ZhihuThemesEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuThemesModel
		extends EveBaseModel<Reply<ZhihuThemesEntity>, ZhihuThemesModel.Params> {

	@Inject
	protected ZhihuThemesModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<ZhihuThemesEntity>> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private String cacheKey;

		private Params(String cacheKey) {
			this.cacheKey = cacheKey;
		}

		public static ZhihuThemesModel.Params forCacheKey(String cacheKey) {
			return new ZhihuThemesModel.Params(cacheKey);
		}
	}
}
