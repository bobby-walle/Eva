/*
 * Create by BobEve on 17-12-21 下午10:50
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 下午5:11
 */

package bob.eve.walle.mvp.contract;

import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.view.IView;
import bob.eve.walle.mvp.model.bean.gank.GankItem;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public interface HiGirlFromGankContract {
	interface View extends IView {
		void showGirls(List<GankItem> items);

		void showMoreGirls(List<GankItem> items);
	}

	interface Presenter extends IPresenter<View> {
		void getGirls(String category);

		void getMoreGirls(String category);
	}
}
