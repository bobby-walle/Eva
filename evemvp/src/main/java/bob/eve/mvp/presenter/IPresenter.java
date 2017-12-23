/*
 * Create by BobEve on 17-12-10 下午10:42
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午10:42
 */

package bob.eve.mvp.presenter;

import bob.eve.mvp.mapper.IEntityToModelMapper;
import bob.eve.mvp.model.IModel;
import bob.eve.mvp.view.IView;

/**
 * Created by Bob on 17/12/10.
 *
 * View与Model交互
 *
 * {@link IView }UI展示 Model
 * {@link IModel } 数据获取 Data
 * {@link IEntityToModelMapper } 数据转换 Data -> Model
 */

public interface IPresenter<V extends IView> {

	/**
	 * On view's (Activity or Fragment) onResume() will be call.
	 */
	void resume();

	/**
	 * On view's (Activity or Fragment) onPause() will be call.
	 */
	void pause();

	/**
	 * On view's (Activity or Fragment) onDestroy() will be call.
	 */
	void destroy();

	/**
	 * On view's (Activity or Fragment) bind will be call.
	 */
	void attach(V v);

	/**
	 * On view's (Activity or Fragment) unbind will be call.
	 */
	void detach();

	/**
	 * @return view is attached return true,else false.
	 */
	boolean isAttach();
}
