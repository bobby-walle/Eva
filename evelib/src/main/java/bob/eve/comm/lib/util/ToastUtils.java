/*
 * Create by BobEve on 17-12-20 下午8:11
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午8:11
 */

package bob.eve.comm.lib.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Bob on 17/12/20.
 */

public class ToastUtils {

	private static Toast toast;

	private ToastUtils() {
	}

	public static void show(Context context, int resId) {
		create(context, context.getResources()
													 .getString(resId)).show();
	}

	public static void show(Context context, String msg) {
		create(context, msg).show();
	}

	@SuppressLint("ShowToast")
	private static Toast create(Context context, String text) {
		if (toast != null) {
			toast.setText(text);
			return toast;
		}
		toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		return toast;
	}
}
