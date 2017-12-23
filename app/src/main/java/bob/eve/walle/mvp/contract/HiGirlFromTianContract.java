/*
 * Create by BobEve on 17-12-22 下午5:32
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 下午10:54
 */

package bob.eve.walle.mvp.contract;

import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.view.IView;
import bob.eve.walle.mvp.model.bean.tian.TianGirl;
import java.util.List;

/**
 * Created by Bob on 17/12/19.
 */

public interface HiGirlFromTianContract {
	interface View extends IView {
		void showGirls(List<TianGirl> items);

		void showMoreGirls(List<TianGirl> items);
	}

	interface Presenter extends IPresenter<View> {
		void getGirls();

		void getMoreGirls();
	}
}
