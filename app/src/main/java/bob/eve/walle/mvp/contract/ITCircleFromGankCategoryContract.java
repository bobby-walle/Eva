/*
 * Create by BobEve on 17-12-19 上午11:10
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午11:10
 */

package bob.eve.walle.mvp.contract;

import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.view.IView;
import bob.eve.walle.mvp.model.bean.gank.GankItem;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public interface ITCircleFromGankCategoryContract {
	interface View extends IView {
		void showTechs(List<GankItem> items);

		void showMoreTechs(List<GankItem> items);

		void showTopGirl(GankItem girl);
	}

	interface Presenter extends IPresenter<View> {
		void getTechs(String category);

		void getMoreTechs(String category);

		void getTopGirl();
	}
}
