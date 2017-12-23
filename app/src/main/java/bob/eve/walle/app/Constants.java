/*
 * Create by BobEve on 17-12-12 下午4:41
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午4:41
 */

package bob.eve.walle.app;

import android.os.Environment;
import java.io.File;

/**
 * Created by Bob on 17/12/12.
 */

public final class Constants {
	public static final String PM25IN_PUBLIC_KEY = "5j1znBVAsnSf5xQyNQyq";
	public static final String AQICN_TOKEN = "21acde2c4ac1fc1f47d4cbeb752e6bc000ea171d";
	public static final String TIAN_XING_KEY = "965831c7d8400cb5f065e3d783c5296b";
	public static final String BUGLY_APP_ID = "9a7bb55bcb";

	public static final String GIRLS_SDCARD_PATH = Environment.getExternalStorageDirectory()
																														.getAbsolutePath() + File.separator + "Eve" +
																								 File.separator + "Girls";
}
