/*
 * Create by BobEve on 17-12-17 下午2:22
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-17 下午2:22
 */

package bob.eve.comm.lib.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Bob on 17/12/17.
 */

public class DeviceUtils {

	public static int dp2px(Context context, float dp) {
		return (int) (getDisplayMetrics(context).density * dp);
	}

	public static int px2dp(Context context, float px) {
		return (int) (px / getDisplayMetrics(context).density + 0.5f);
	}

	public static DisplayMetrics getDisplayMetrics(Context context) {
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay()
			.getMetrics(metrics);
		return metrics;
	}

	public static int getStatusBarHeight(Context context) {
		int result = 0;
		int resourceId = context.getResources()
														.getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = context.getResources()
											.getDimensionPixelSize(resourceId);
		}
		return result;
	}
}
