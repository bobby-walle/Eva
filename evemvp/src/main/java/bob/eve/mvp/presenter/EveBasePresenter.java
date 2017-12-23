/*
 * Create by BobEve on 17-12-10 下午10:57
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午10:57
 */

package bob.eve.mvp.presenter;

import bob.eve.mvp.mapper.IEntityToModelMapper;
import bob.eve.mvp.model.IModel;
import bob.eve.mvp.view.IView;

/**
 * Created by Bob on 17/12/10.
 */

public class EveBasePresenter<V extends IView, Model extends IModel, Mapper extends IEntityToModelMapper>
		implements IPresenter<V> {
	private boolean isAttach = false;
	protected V view;
	protected Model store;
	protected Mapper mapper;

	public EveBasePresenter(Model store, Mapper mapper) {
		this.store = store;
		this.mapper = mapper;
	}

	@Override
	public void attach(V view) {
		this.view = view;
		isAttach = true;
	}

	@Override
	public void detach() {
		this.view = null;
		isAttach = false;
	}

	@Override
	public boolean isAttach() {
		return isAttach;
	}

	@Override
	public void resume() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void destroy() {
		detach();
		mapper = null;
		if (store != null) {
			store.dispose();
			store = null;
		}
	}
}
