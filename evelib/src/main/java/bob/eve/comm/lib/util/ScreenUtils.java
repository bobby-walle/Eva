/*
 * Create by BobEve on 17-12-9 下午10:15
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午10:15
 */

package bob.eve.comm.lib.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Bob on 17/12/9.
 */

public class ScreenUtils {

	private ScreenUtils() {
		throw new AssertionError();
	}

	public static DisplayMetrics displayMetrics(Context context) {
		if (context == null) {
			return null;
		}
		return context.getResources()
									.getDisplayMetrics();
	}

	public static float density(Context context) {
		if (context == null) {
			return -1;
		}
		return context.getResources()
									.getDisplayMetrics().density;
	}

	public static float dpToPx(Context context, float dp) {
		if (context == null) {
			return -1;
		}
		return dp * context.getResources()
											 .getDisplayMetrics().density;
	}

	public static float pxToDp(Context context, float px) {
		if (context == null) {
			return -1;
		}
		return px / context.getResources()
											 .getDisplayMetrics().density;
	}

	public static int dpToPxInt(Context context, float dp) {
		return (int) (dpToPx(context, dp) + 0.5f);
	}

	public static int pxToDpCeilInt(Context context, float px) {
		return (int) (pxToDp(context, px) + 0.5f);
	}
}