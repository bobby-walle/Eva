/*
 * Create by BobEve on 17-12-18 下午12:00
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午12:00
 */

package bob.eve.walle.mvp.model.zhihu;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.zhihu.ZhihuCommentEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuLongCommentModel
		extends EveBaseModel<Reply<ZhihuCommentEntity>, ZhihuLongCommentModel.Params> {

	@Inject
	protected ZhihuLongCommentModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<ZhihuCommentEntity>> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private String id;

		private Params(String id) {
			this.id = id;
		}

		public static ZhihuLongCommentModel.Params forLongComment(String id) {
			return new ZhihuLongCommentModel.Params(id);
		}
	}
}
