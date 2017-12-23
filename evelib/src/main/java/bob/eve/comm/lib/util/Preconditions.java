/*
 * Create by BobEve on 17-12-10 上午10:15
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 上午2:26
 */

package bob.eve.comm.lib.util;

import android.support.annotation.Nullable;

/**
 * Created by Bob on 17/12/9.
 */

// TODO move to commlibs
public class Preconditions {
	private Preconditions() {
		throw new IllegalStateException("you can't instantiate me!");
	}

	public static void checkArgument(boolean expression) {
		if (!expression) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkArgument(boolean expression, @Nullable String errorMessage) {
		if (!expression) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static <T> T checkNotNull(T reference) {
		if (reference == null) {
			throw new NullPointerException();
		} else {
			return reference;
		}
	}

	public static <T> T checkNotNull(T reference, @Nullable String errorMessage) {
		if (reference == null) {
			throw new NullPointerException(errorMessage);
		} else {

			return reference;
		}
	}
}
