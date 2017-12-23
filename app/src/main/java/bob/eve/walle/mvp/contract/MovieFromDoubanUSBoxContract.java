/*
 * Create by BobEve on 17-12-21 下午4:13
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午2:50
 */

package bob.eve.walle.mvp.contract;

import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.view.IView;
import bob.eve.walle.mvp.model.bean.douban.MovieSubject;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public interface MovieFromDoubanUSBoxContract {
	interface View extends IView {
		void showMovies(List<MovieSubject> items);
	}

	interface Presenter extends IPresenter<View> {
		void getMovies();
	}
}
