/*
 * Create by BobEve on 17-12-22 下午3:23
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-22 下午3:23
 */

package bob.eve.pm.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Bob on 17/12/22.
 */

public class SnackbarUtil {
	public static void show(View view, String msg) {
		Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
						.show();
	}

	public static void showShort(View view, String msg) {
		Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)
						.show();
	}
}
