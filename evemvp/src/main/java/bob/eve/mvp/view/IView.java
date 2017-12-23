package bob.eve.mvp.view;

import bob.eve.mvp.presenter.IPresenter;
import bob.eve.mvp.rx.error.exception.EveStatusException;

/**
 * Created by Bob on 17/12/10.
 *
 * {@link IPresenter}负责按照{@link IView}要求进行数据处理，反馈结果到{@link IView}
 * {@link IView}向{@link IPresenter}提出请求，按照自己的逻辑处理{@link IPresenter}反馈，如页面展示
 */

public interface IView {
	/**
	 * 通知UI Presenter开始处理，具体展示逻辑由UI自己处理
	 */
	void start();

	/**
	 * 通知UI Presenter处理完成
	 */
	void complete();

	/**
	 * 通知UI Presenter处理失败，{@link EveStatusException}中按照具体Store业务封装了ERROR_CODE
	 */
	void error(Throwable e);
}
