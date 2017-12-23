/*
 * Create by BobEve on 17-12-21 上午2:48
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午3:01
 */

package bob.eve.walle.mvp.presenter;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.walle.mvp.contract.MovieFromDoubanTop250Contract;
import bob.eve.walle.mvp.entity.douban.Top250Entity;
import bob.eve.walle.mvp.mapper.DoubanTop250Mapper;
import bob.eve.walle.mvp.model.bean.douban.MovieSubject;
import bob.eve.walle.mvp.model.douban.Top250Model;
import io.rx_cache2.Reply;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/19.
 */

@PreFragment
public class MovieFromDoubanTop250Presenter
		extends EveBasePresenter<MovieFromDoubanTop250Contract.View, Top250Model, DoubanTop250Mapper>
		implements MovieFromDoubanTop250Contract.Presenter {

	// 默认每页请求数量
	private int num = 20;
	private int page = 1;

	@Inject
	public MovieFromDoubanTop250Presenter(Top250Model store, DoubanTop250Mapper mapper) {
		super(store, mapper);
	}

	@Override
	public void getMovies() {
		page = 1;
		store.execute(new EveRxErrorObserver<Reply<Top250Entity>>(view) {
			@Override
			public void onNext(Reply<Top250Entity> top250EntityReply) {
				show(top250EntityReply, false);
			}
		}, Top250Model.Params.forPage(page)
												 .setEvictProvider(true));
	}

	@Override
	public void getMoreMovies() {
		store.execute(new EveRxErrorObserver<Reply<Top250Entity>>(view) {
			@Override
			public void onNext(Reply<Top250Entity> top250EntityReply) {
				show(top250EntityReply, true);
			}
		}, Top250Model.Params.forPage(page + 1)
												 .setEvictProvider(false));
	}

	private void show(Reply<Top250Entity> top250EntityReply, boolean isMore) {
		List<MovieSubject> items = null;

		if (top250EntityReply != null) {
			Top250Entity entity = top250EntityReply.getData();
			if (entity != null) {
				items = (List<MovieSubject>) mapper.transform(entity.getSubjects());
			}
		}

		if (!isMore) {
			view.showMovies(items);
		} else {
			page += 1;
			view.showMoreMovies(items);
		}
	}
}
