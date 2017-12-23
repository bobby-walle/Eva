/*
 * Create by BobEve on 17-12-18 下午12:02
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午12:01
 */

package bob.eve.walle.mvp.model.zhihu;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.zhihu.ZhihuThemeListEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class ZhihuThemeListModel
		extends EveBaseModel<Reply<ZhihuThemeListEntity>, ZhihuThemeListModel.Params> {

	@Inject
	protected ZhihuThemeListModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<ZhihuThemeListEntity>> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private String id;

		private Params(String id) {
			this.id = id;
		}

		public static ZhihuThemeListModel.Params forThemeList(String id) {
			return new ZhihuThemeListModel.Params(id);
		}
	}
}
