/*
 * Create by BobEve on 17-12-22 下午5:32
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-22 下午12:47
 */

package bob.eve.walle.mvp.presenter;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.presenter.EveBasePresenter;
import bob.eve.mvp.rx.error.EveRxErrorObserver;
import bob.eve.walle.mvp.contract.HiGirlFromTianContract;
import bob.eve.walle.mvp.entity.tian.TianGirlEntity;
import bob.eve.walle.mvp.mapper.TianGirlMapper;
import bob.eve.walle.mvp.model.bean.tian.TianGirl;
import bob.eve.walle.mvp.model.gank.RandomGirlsModel;
import bob.eve.walle.mvp.model.tian.TianGirlsModel;
import io.rx_cache2.Reply;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/19.
 */

@PreFragment
public class HiGirlFromTianPresenter
		extends EveBasePresenter<HiGirlFromTianContract.View, TianGirlsModel, TianGirlMapper>
		implements HiGirlFromTianContract.Presenter {

	@Inject
	public RandomGirlsModel girlsStore;
	// 默认每页请求数量
	public int num = 20;
	private int page = 1;

	@Inject
	public HiGirlFromTianPresenter(TianGirlsModel store, TianGirlMapper mapper) {
		super(store, mapper);
	}

	@Override
	public void getGirls() {
		page = 1;
		store.execute(new EveRxErrorObserver<Reply<TianGirlEntity>>(view) {
			@Override
			public void onNext(Reply<TianGirlEntity> gankItemEntityReply) {
				show(gankItemEntityReply, false);
			}
		}, TianGirlsModel.Params.forTianGirls(num, page + 1)
														.setEvictProvider(true));
	}

	@Override
	public void getMoreGirls() {
		store.execute(new EveRxErrorObserver<Reply<TianGirlEntity>>(view) {

			@Override
			public void onNext(Reply<TianGirlEntity> gankItemEntityReply) {
				show(gankItemEntityReply, true);
			}
		}, TianGirlsModel.Params.forTianGirls(num, page + 1)
														.setEvictProvider(false));
	}

	private void show(Reply<TianGirlEntity> gankItemEntityReply, boolean isMore) {
		List<TianGirl> items = null;

		if (gankItemEntityReply != null) {
			TianGirlEntity entity = gankItemEntityReply.getData();
			if (entity != null) {
				items = (List<TianGirl>) mapper.transform(entity.getNewslist());
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
