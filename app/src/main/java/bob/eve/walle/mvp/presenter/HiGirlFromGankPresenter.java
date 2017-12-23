/*
 * Create by BobEve on 17-12-21 下午10:52
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 下午5:12
 */

package bob.eve.walle.mvp.presenter;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.walle.mvp.contract.HiGirlFromGankContract;
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
public class HiGirlFromGankPresenter
		extends EveBasePresenter<HiGirlFromGankContract.View, CategoryGanksModel, GankItemMapper>
		implements HiGirlFromGankContract.Presenter {

	@Inject
	public RandomGirlsModel girlsStore;
	// 默认每页请求数量
	public int num = 20;
	private int page = 1;

	@Inject
	public HiGirlFromGankPresenter(CategoryGanksModel store, GankItemMapper mapper) {
		super(store, mapper);
	}

	@Override
	public void getGirls(String category) {
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
	public void getMoreGirls(String category) {
		store.execute(new EveRxErrorObserver<Reply<GankItemEntity>>(view) {

			@Override
			public void onNext(Reply<GankItemEntity> gankItemEntityReply) {
				show(gankItemEntityReply, true);
			}
		}, CategoryGanksModel.Params.forCategoryGanks(category, num, page + 1)
																.setEvictProvider(false));
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
			view.showGirls(items);
		} else {
			page += 1;
			view.showMoreGirls(items);
		}
	}
}
