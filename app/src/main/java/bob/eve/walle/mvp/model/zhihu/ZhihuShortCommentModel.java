/*
 * Create by BobEve on 17-12-18 上午11:59
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:59
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

public class ZhihuShortCommentModel
		extends EveBaseModel<Reply<ZhihuCommentEntity>, ZhihuShortCommentModel.Params> {

	@Inject
	protected ZhihuShortCommentModel(IEveRepositoryManager repositoryManager) {
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

		public static ZhihuShortCommentModel.Params forShortComment(String id) {
			return new ZhihuShortCommentModel.Params(id);
		}
	}
}
