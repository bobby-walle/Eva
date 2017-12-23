/*
 * Create by BobEve on 17-12-20 下午5:44
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午5:44
 */

package bob.eve.walle.app;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import bob.eve.comm.lib.util.SystemUtils;
import bob.eve.walle.BuildConfig;
import butterknife.ButterKnife;
import com.github.moduth.blockcanary.BlockCanary;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import timber.log.Timber;

/**
 * Created by Bob on 17/12/20.
 */

public class InitializeService extends IntentService {

	private static final String ACTION_INIT = "ApplicationInit";

	public InitializeService() {
		super("InitializeService");
	}

	public static void start(Context context) {
		Intent intent = new Intent(context, InitializeService.class);
		intent.setAction(ACTION_INIT);
		context.startService(intent);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		if (intent != null) {
			final String action = intent.getAction();
			if (ACTION_INIT.equals(action)) {
				initApplication();
			}
		}
	}

	private void initApplication() {

		Context context = getApplicationContext();
		String packageName = context.getPackageName();
		String processName = SystemUtils.getProcessName(android.os.Process.myPid());
		CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
		strategy.setUploadProcess(processName == null || processName.equals(packageName));
		CrashReport.initCrashReport(context, Constants.BUGLY_APP_ID, BuildConfig.DEBUG, strategy);

		if (BuildConfig.DEBUG) {
			Logger.addLogAdapter(new AndroidLogAdapter());

			Timber.plant(new Timber.DebugTree());

			ButterKnife.setDebug(true);

			if (LeakCanary.isInAnalyzerProcess(getApplicationContext())) {
				// This process is dedicated to LeakCanary for heap analysis.
				// You should not init your app in this process.
				return;
			} else {
				LeakCanary.install(getApplication());
			}
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll()
																																			.penaltyLog()
																																			.build());
			/* 内存检查 */
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
																															.penaltyLog()
																															.build());

			//初始化过度绘制检测
			BlockCanary.install(getApplicationContext(), new AppBlockCanaryContext())
								 .start();
		}
	}
}
