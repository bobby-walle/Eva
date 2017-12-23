/*
 * Create by BobEve on 17-12-11 上午1:38
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 上午1:38
 */

package bob.eve.mvp.rx.error.exception;

/**
 * Created by Bob on 17/12/11.
 */

public class NetworkConnectionException extends Exception {
	private static final String LOG_TAG = "NetworkConnectionException";

	public NetworkConnectionException() {
		super();
	}

	public NetworkConnectionException(final Throwable cause) {
		super(cause);
	}
}
