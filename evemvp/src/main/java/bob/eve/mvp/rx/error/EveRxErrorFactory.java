/*
 * Create by BobEve on 17-12-11 下午10:22
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:22
 */

package bob.eve.mvp.rx.error;

import android.content.Context;

/**
 * Created by Bob on 17/12/11.
 */

public class EveRxErrorFactory {
	private static final String TAG = "EveErrorFactory";

	private Context mContext;
	private EveRxErrorListener mErrorListener;

	public EveRxErrorFactory(Context mContext, EveRxErrorListener mErrorListener) {
		this.mErrorListener = mErrorListener;
		this.mContext = mContext;
	}

	public void onError(Throwable throwable) {
		mErrorListener.rxError(mContext, throwable);
	}
}
