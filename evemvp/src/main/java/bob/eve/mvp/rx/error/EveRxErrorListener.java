/*
 * Create by BobEve on 17-12-11 下午10:20
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:20
 */

package bob.eve.mvp.rx.error;

import android.content.Context;

/**
 * Created by Bob on 17/12/11.
 */

public interface EveRxErrorListener {
	void rxError(Context context, Throwable t);

	EveRxErrorListener EMPTY = new EveRxErrorListener() {
		@Override
		public void rxError(Context context, Throwable t) {

		}
	};
}
