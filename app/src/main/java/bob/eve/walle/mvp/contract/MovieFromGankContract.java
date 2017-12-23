/*
 * Create by BobEve on 17-12-21 下午4:32
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午2:46
 */

package bob.eve.walle.mvp.contract;

import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.view.IView;
import bob.eve.walle.mvp.model.bean.gank.GankItem;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public interface MovieFromGankContract {
	interface View extends IView {
		void showMovies(List<GankItem> items);

		void showMoreMovies(List<GankItem> items);

		void showTopGirl(GankItem girl);
	}

	interface Presenter extends IPresenter<View> {
		void getMovies(String category);

		void getMoreMovies(String category);

		void getTopGirl();
	}
}
