/*
 * Create by BobEve on 17-12-20 下午7:29
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午7:29
 */

package bob.eve.walle.config;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/20.
 */

public class ImplPreferencesHelper implements PreferencesHelper {
	public static final String SP_NIGHT_MODE = "night_mode";
	public static final String SP_NO_IMAGE = "no_image";
	public static final String SP_AUTO_CACHE = "auto_cache";
	public static final String SP_FRAGMENT_INDEX = "fragment_index";

	private static final boolean DEFAULT_NIGHT_MODE = false;
	private static final boolean DEFAULT_NO_IMAGE = false;
	private static final boolean DEFAULT_AUTO_SAVE = true;
	private static final int DEFAULT_FRAGMENT_INDEX = 0;

	private static final String SHAREDPREFERENCES_NAME = "eve_sp";

	private final SharedPreferences mSharedPreferences;

	@Inject
	public ImplPreferencesHelper(Application application) {
		mSharedPreferences =
				application.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
	}

	@Override
	public boolean getNightModeState() {
		return mSharedPreferences.getBoolean(SP_NIGHT_MODE, DEFAULT_NIGHT_MODE);
	}

	@Override
	public void setNightModeState(boolean state) {
		mSharedPreferences.edit()
											.putBoolean(SP_NIGHT_MODE, state)
											.apply();
	}

	@Override
	public boolean getNoImageState() {
		return mSharedPreferences.getBoolean(SP_NO_IMAGE, DEFAULT_NO_IMAGE);
	}

	@Override
	public void setNoImageState(boolean state) {
		mSharedPreferences.edit()
											.putBoolean(SP_NO_IMAGE, state)
											.apply();
	}

	@Override
	public boolean getAutoCacheState() {
		return mSharedPreferences.getBoolean(SP_AUTO_CACHE, DEFAULT_AUTO_SAVE);
	}

	@Override
	public void setAutoCacheState(boolean state) {
		mSharedPreferences.edit()
											.putBoolean(SP_AUTO_CACHE, state)
											.apply();
	}

	@Override
	public int getFragmentIndex() {
		return mSharedPreferences.getInt(SP_FRAGMENT_INDEX, DEFAULT_FRAGMENT_INDEX);
	}

	@Override
	public void setFragmentIndex(int index) {
		if (index < 0) {
			index = 0;
		}
		mSharedPreferences.edit()
											.putInt(SP_FRAGMENT_INDEX, index)
											.apply();
	}
}
