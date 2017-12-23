/*
 * Create by BobEve on 17-12-21 下午4:31
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午3:08
 */

package bob.eve.walle.mvp.presenter;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.walle.mvp.contract.MovieFromGankContract;
import bob.eve.walle.mvp.entity.gank.GankItemEntity;
import bob.eve.walle.mvp.mapper.GankItemMapper;
import bob.eve.walle.mvp.model.bean.gank.GankItem;
import bob.eve.walle.mvp.model.gank.CategoryGanksModel;
import bob.eve.walle.mvp.model.gank.RandomGirlsModel;
import io.rx_cache2.Reply;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/19.
 */

@PreFragment
public class MovieFromGankPresenter
		extends EveBasePresenter<MovieFromGankContract.View, CategoryGanksModel, GankItemMapper>
		implements MovieFromGankContract.Presenter {

	@Inject
	public RandomGirlsModel girlsStore;
	// 默认每页请求数量
	private int num = 20;
	private int page = 1;

	@Inject
	public MovieFromGankPresenter(CategoryGanksModel store, GankItemMapper mapper) {
		super(store, mapper);
	}

	@Override
	public void getMovies(String category) {
		page = 1;
		store.execute(new EveRxErrorObserver<Reply<GankItemEntity>>(view) {
			@Override
			public void onNext(Reply<GankItemEntity> gankItemEntityReply) {
				show(gankItemEntityReply, false);
			}
		}, CategoryGanksModel.Params.forCategoryGanks(category, num, page)
																.setEvictProvider(true));
	}

	@Override
	public void getMoreMovies(String category) {
		store.execute(new EveRxErrorObserver<Reply<GankItemEntity>>(view) {

			@Override
			public void onNext(Reply<GankItemEntity> gankItemEntityReply) {
				show(gankItemEntityReply, true);
			}
		}, CategoryGanksModel.Params.forCategoryGanks(category, num, page + 1)
																.setEvictProvider(false));
	}

	@Override
	public void getTopGirl() {
		girlsStore.execute(new EveRxErrorObserver<GankItemEntity>(view) {
			@Override
			public void onNext(GankItemEntity entity) {
				if (entity != null) {
					List<GankItem> items = (List<GankItem>) mapper.transform(entity.getResults());
					if (items != null && items.size() > 0) {
						view.showTopGirl(items.get(0));
					}
				}
			}
		}, RandomGirlsModel.Params.forRandomGirls(1));
	}

	@Override
	public void destroy() {
		super.destroy();
		if (girlsStore != null) {
			girlsStore.dispose();
			girlsStore = null;
		}
	}

	private void show(Reply<GankItemEntity> gankItemEntityReply, boolean isMore) {
		List<GankItem> items = null;

		if (gankItemEntityReply != null) {
			GankItemEntity entity = gankItemEntityReply.getData();
			if (entity != null) {
				items = (List<GankItem>) mapper.transform(entity.getResults());
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
