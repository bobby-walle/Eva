/*
 * Create by BobEve on 17-12-12 下午1:04
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午1:03
 */

package bob.eve.mvp.rx.error.exception;

/**
 * Created by Bob on 17/12/12.
 */

public class EveStatusException extends Throwable {
	public static final int DEFAULT_ERROR_CODE = -1;
	private int errorCode = DEFAULT_ERROR_CODE;

	public EveStatusException(String message, Throwable cause, int errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public int errorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
