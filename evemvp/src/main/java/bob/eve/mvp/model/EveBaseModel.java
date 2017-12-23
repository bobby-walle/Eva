/*
 * Create by BobEve on 17-12-11 下午2:02
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午2:02
 */

package bob.eve.mvp.model;

import bob.eve.comm.lib.util.Preconditions;
import bob.eve.mvp.rx.error.EveErrorFunction;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Bob on 17/12/10.
 *
 * 数据仓库实现{@link #buildModelDataObservable(Object)}提供数据
 */

public abstract class EveBaseModel<T, PARAMS> implements IModel<T, PARAMS> {
	private static final String LOG_TAG = "AbsDataStore";
	protected static final String DYNAMICKEY_SPLIT = "@";
	//	private final ThreadExecutor threadExecutor;
	//	private final PostExecutionThread postExecutionThread;
	protected IEveRepositoryManager repositoryManager;
	private final CompositeDisposable disposables;

	protected EveBaseModel(IEveRepositoryManager repositoryManager) {
		this.repositoryManager = repositoryManager;
		this.disposables = new CompositeDisposable();
	}

	protected abstract Observable<T> buildModelDataObservable(PARAMS params);

	// TODO 是否需要引入线程池
	//	AbsDataStore(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
	//		this.threadExecutor = threadExecutor;
	//		this.postExecutionThread = postExecutionThread;
	//		this.disposables = new CompositeDisposable();
	//	}

	/**
	 * Presenter中获取Data
	 *
	 * @param observer
	 * 		订阅Data数据
	 * @param params
	 * 		请求Data参数
	 */
	@Override
	public void execute(DisposableObserver<T> observer, PARAMS params) {
		Preconditions.checkNotNull(observer, "DataStore's observer can not be null then execute.");
		final Observable<T> observable = this.buildModelDataObservable(params)
																				 .onErrorResumeNext(new EveErrorFunction<T>())
																				 .subscribeOn(Schedulers.io())
																				 .observeOn(AndroidSchedulers.mainThread());

		addDisposable(observable.subscribeWith(observer));
	}

	@Override
	public void addDisposable(Disposable disposable) {
		Preconditions.checkNotNull(disposable);
		Preconditions.checkNotNull(disposables);
		disposables.add(disposable);
	}

	/**
	 * Presenter destroy()中回收
	 */
	@Override
	public void dispose() {
		if (!disposables.isDisposed()) {
			disposables.dispose();
		}
	}

	public static abstract class Params<T> {
		public boolean isEvictProvider;

		public boolean isEvictProvider() {
			return isEvictProvider;
		}

		public abstract T setEvictProvider(boolean isEvictProvider);
	}
}
