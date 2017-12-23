/*
 * Create by BobEve on 17-12-20 下午6:03
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午6:03
 */

package bob.eve.comm.lib.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Bob on 17/12/20.
 */

public class SystemUtils {
	/**
	 * 保存文字到剪贴板
	 */
	public static void copyToClipBoard(Context context, String text) {
		ClipData clipData = ClipData.newPlainText("url", text);
		ClipboardManager manager =
				(ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
		manager.setPrimaryClip(clipData);
		ToastUtils.show(context, "已复制到剪贴板");
	}

	/**
	 * 获取进程号对应的进程名
	 *
	 * @param pid
	 * 		进程号
	 *
	 * @return 进程名
	 */
	public static String getProcessName(int pid) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
			String processName = reader.readLine();
			if (!TextUtils.isEmpty(processName)) {
				processName = processName.trim();
			}
			return processName;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}
}
