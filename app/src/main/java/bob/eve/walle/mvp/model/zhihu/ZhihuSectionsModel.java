/*
 * Create by BobEve on 17-12-18 下午12:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午12:01
 */

package bob.eve.walle.mvp.model.zhihu;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.zhihu.ZhihuSectionsEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuSectionsModel
		extends EveBaseModel<Reply<ZhihuSectionsEntity>, ZhihuSectionsModel.Params> {

	@Inject
	protected ZhihuSectionsModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<ZhihuSectionsEntity>> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private String cacheKey;

		private Params(String cacheKey) {
			this.cacheKey = cacheKey;
		}

		public static ZhihuSectionsModel.Params forCacheKey(String cacheKey) {
			return new ZhihuSectionsModel.Params(cacheKey);
		}
	}
}
