/*
 * Create by BobEve on 17-12-12 下午1:23
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午1:23
 */

package bob.eve.mvp.rx.error;

import android.content.Context;
import bob.eve.mvp.R;
import bob.eve.mvp.rx.error.exception.EveStatusException;
import bob.eve.mvp.rx.error.exception.NetworkConnectionException;
import bob.eve.mvp.rx.error.exception.ParamsException;

/**
 * Created by Bob on 17/12/11.
 */

public class EveErrorMapper {
	private static final String LOG_TAG = "EveErrorFactory";

	/*
	 * CODE值与服务器确认
	 */
	// 网络错误
	public static final int ERROR_CODE_NETWORK = 1;
	// 参数错误
	public static final int ERROR_CODE_PARAMS = 1 << 1;

	public static EveStatusException create(Context context, Throwable exception) {
		final EveStatusException error;
		if (context == null) {
			return new EveStatusException("", new IllegalArgumentException(""),
																		EveStatusException.DEFAULT_ERROR_CODE);
		}
		if (exception instanceof NetworkConnectionException) {
			error = new EveStatusException(context.getString(R.string.error_message_network),
																		 new NetworkConnectionException(), ERROR_CODE_NETWORK);
		} else if (exception instanceof ParamsException) {
			error = new EveStatusException(context.getString(R.string.error_message_params),
																		 new ParamsException(), ERROR_CODE_PARAMS);
		} else {
			error = new EveStatusException(context.getString(R.string.error_message_unknown),
																		 new NetworkConnectionException(),
																		 EveStatusException.DEFAULT_ERROR_CODE);
		}

		return error;
	}
}
