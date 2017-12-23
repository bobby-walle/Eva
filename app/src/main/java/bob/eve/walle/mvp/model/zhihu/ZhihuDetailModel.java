/*
 * Create by BobEve on 17-12-18 上午11:56
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:56
 */

package bob.eve.walle.mvp.model.zhihu;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.zhihu.ZhihuDetailEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuDetailModel
		extends EveBaseModel<Reply<ZhihuDetailEntity>, ZhihuDetailModel.Params> {

	@Inject
	protected ZhihuDetailModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<ZhihuDetailEntity>> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private String id;

		private Params(String id) {
			this.id = id;
		}

		public static ZhihuDetailModel.Params forZhihuDetail(String id) {
			return new ZhihuDetailModel.Params(id);
		}
	}
}
