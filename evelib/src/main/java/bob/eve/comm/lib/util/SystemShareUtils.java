/*
 * Create by BobEve on 17-12-20 下午8:18
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午8:18
 */

package bob.eve.comm.lib.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Bob on 17/12/20.
 */

public class SystemShareUtils {
	private static final String EMAIL_ADDRESS = "bodroid@163.com";

	public static void shareText(Context context, String text, String title) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TITLE, "来自Eve的分享");
		intent.putExtra(Intent.EXTRA_TEXT, text);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(Intent.createChooser(intent, title));
	}

	public static void shareImage(Context context, Uri uri, String title) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(Intent.createChooser(intent, title));
	}

	public static void sendEmail(Context context, String title) {
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.setData(Uri.parse("mailto:" + EMAIL_ADDRESS));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(Intent.createChooser(intent, title));
	}
}
