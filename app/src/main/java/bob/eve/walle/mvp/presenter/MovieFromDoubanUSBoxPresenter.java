/*
 * Create by BobEve on 17-12-21 下午4:13
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午3:12
 */

package bob.eve.walle.mvp.presenter;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.walle.mvp.contract.MovieFromDoubanUSBoxContract;
import bob.eve.walle.mvp.entity.douban.USBoxEntity;
import bob.eve.walle.mvp.mapper.DoubanUSBoxMapper;
import bob.eve.walle.mvp.model.bean.douban.MovieSubject;
import bob.eve.walle.mvp.model.douban.USBoxModel;
import io.rx_cache2.Reply;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/19.
 */

@PreFragment
public class MovieFromDoubanUSBoxPresenter
		extends EveBasePresenter<MovieFromDoubanUSBoxContract.View, USBoxModel, DoubanUSBoxMapper>
		implements MovieFromDoubanUSBoxContract.Presenter {

	// 默认每页请求数量
	private int num = 20;
	private int page = 1;

	@Inject
	public MovieFromDoubanUSBoxPresenter(USBoxModel store, DoubanUSBoxMapper mapper) {
		super(store, mapper);
	}

	@Override
	public void getMovies() {
		page = 1;
		store.execute(new EveRxErrorObserver<Reply<USBoxEntity>>(view) {
			@Override
			public void onNext(Reply<USBoxEntity> top250EntityReply) {
				show(top250EntityReply);
			}
		}, USBoxModel.Params.forCacheKey(String.valueOf(page))
												.setEvictProvider(false));
	}

	private void show(Reply<USBoxEntity> top250EntityReply) {
		List<MovieSubject> items = null;
		if (top250EntityReply != null) {
			USBoxEntity entity = top250EntityReply.getData();
			if (entity != null) {
				items = (List<MovieSubject>) mapper.transform(entity.getSubjects());
			}
		}
		view.showMovies(items);
	}
}
