/*
 * Create by BobEve on 17-12-19 上午10:03
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午9:52
 */

package bob.eve.walle.mvp.model.gank;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.gank.GankISearchItemEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class SearchGanksModel extends EveBaseModel<GankISearchItemEntity, SearchGanksModel.Params> {

	@Inject
	protected SearchGanksModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<GankISearchItemEntity> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		String query;
		String category;
		int num;
		int page;

		private Params(String query, String category, int num, int page) {
			this.query = query;
			this.category = category;
			this.num = num;
			this.page = page;
		}

		public static Params forSearchGanks(String query, String category, int num, int page) {
			return new Params(query, category, num, page);
		}
	}
}
