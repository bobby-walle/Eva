/*
 * Create by BobEve on 17-12-12 上午11:20
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 上午11:20
 */

package bob.eve.walle.app;

import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import bob.eve.mvp.base.EveBaseApplication;
import bob.eve.mvp.base.IApplication;
import bob.eve.mvp.base.proxy.ApplicationProxy;
import bob.eve.walle.config.ImplPreferencesHelper;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/12.
 */

public class PmWeatherApplication extends EveBaseApplication implements IApplication {
	public static int SCREEN_WIDTH = -1;
	public static int SCREEN_HEIGHT = -1;
	public static float DIMEN_RATE = -1.0F;
	public static int DIMEN_DPI = -1;

	@Inject
	ImplPreferencesHelper preferencesHelper;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		initDefaultNightMode(base);
	}

	private void initDefaultNightMode(Context base) {
		boolean isNight = base.getSharedPreferences("eve_sp", Context.MODE_PRIVATE)
													.getBoolean("night_mode", false);
		if (isNight) {
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mApplicationProxy = new ApplicationProxy();
		mApplicationProxy.onCreate(this);
		getScreenSize();
		// 初始化
		InitializeService.start(this);
	}

	public void getScreenSize() {
		WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		Display display = windowManager.getDefaultDisplay();
		display.getMetrics(dm);
		DIMEN_RATE = dm.density / 1.0F;
		DIMEN_DPI = dm.densityDpi;
		SCREEN_WIDTH = dm.widthPixels;
		SCREEN_HEIGHT = dm.heightPixels;
	}
}
