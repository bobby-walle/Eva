/*
 * Create by BobEve on 17-12-11 下午10:19
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:19
 */

package bob.eve.mvp.rx.error;

import android.content.Context;

/**
 * Created by Bob on 17/12/11.
 */

public class EveRxErrorHandler {
	public final String TAG = this.getClass()
																.getSimpleName();
	private EveRxErrorFactory mErrorFactory;

	private EveRxErrorHandler(Builder builder) {
		this.mErrorFactory = builder.mErrorFactory;
	}

	public static Builder builder() {
		return new Builder();
	}

	public EveRxErrorFactory getErrorFactory() {
		return mErrorFactory;
	}

	public static final class Builder {
		private Context context;
		private EveRxErrorListener mErrorListener;
		private EveRxErrorFactory mErrorFactory;

		private Builder() {
		}

		public Builder with(Context context) {
			this.context = context;
			return this;
		}

		public Builder eveRxErrorListener(EveRxErrorListener listener) {
			this.mErrorListener = listener;
			return this;
		}

		public EveRxErrorHandler build() {
			if (context == null) {
				throw new IllegalStateException("Context is required");
			}

			if (mErrorListener == null) {
				throw new IllegalStateException("EveErrorListener is required");
			}

			this.mErrorFactory = new EveRxErrorFactory(context, mErrorListener);

			return new EveRxErrorHandler(this);
		}
	}
}
