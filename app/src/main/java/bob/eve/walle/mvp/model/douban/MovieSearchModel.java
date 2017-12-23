/*
 * Create by BobEve on 17-12-19 上午12:16
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午12:16
 */

package bob.eve.walle.mvp.model.douban;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.douban.MovieSearchEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class MovieSearchModel extends EveBaseModel<MovieSearchEntity, MovieSearchModel.Params> {

	@Inject
	protected MovieSearchModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<MovieSearchEntity> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private String q;
		private String tag;
		private int start;
		private int count;

		private Params(String q, String tag, int start, int count) {
			this.q = q;
			this.tag = tag;
			this.start = start;
			this.count = count;
		}

		public static Params forMovieSearch(String q, String tag, int start, int count) {
			return new Params(q, tag, start, count);
		}
	}
}
