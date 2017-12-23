/*
 * Create by BobEve on 17-12-21 上午11:11
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午11:11
 */

package bob.eve.walle.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.format.Formatter;
import android.widget.TextView;
import java.io.File;

/**
 * Created by Bob on 17/12/21.
 * new GetDiskCacheSizeTask(textView)
 * * .execute(
 * * * new File(getCacheDir(), DiskCache.Factory.DEFAULT_DISK_CACHE_DIR
 * * )
 * );
 */

class GetDiskCacheSizeTask extends AsyncTask<File, Long, Long> {
	private final TextView resultView;

	public GetDiskCacheSizeTask(TextView resultView) {
		this.resultView = resultView;
	}

	@Override
	protected void onPreExecute() {
		resultView.setText("计算中...");
	}

	@Override
	protected void onProgressUpdate(Long... values) {
	}

	@Override
	protected Long doInBackground(File... dirs) {
		long totalSize = 0;
		try {
			for (File dir : dirs) {
				publishProgress(totalSize);
				totalSize += calculateSize(dir);
			}
		} catch (RuntimeException ex) {
			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
					resultView.setText("计算错误，稍后查看");
				}
			});
		}

		return totalSize;
	}

	@Override
	protected void onPostExecute(Long size) {
		String sizeText = Formatter.formatFileSize(resultView.getContext(), size);
		resultView.setText(sizeText);
	}

	private static long calculateSize(File dir) {
		if (dir == null) {
			return 0;
		}
		if (!dir.isDirectory()) {
			return dir.length();
		}
		long result = 0;
		File[] children = dir.listFiles();
		if (children != null) {
			for (File child : children)
				result += calculateSize(child);
		}
		return result;
	}
}
