/*
 * Create by BobEve on 17-12-11 下午7:11
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午7:11
 */

package bob.eve.comm.lib.configuration;

import android.app.Application;
import android.content.Context;

/**
 * Created by Bob on 17/12/11.
 */

public interface IApplicationLifecycle {
	void attachBaseContext(Context base);

	void onCreate(Application application);

	void onTerminate(Application application);
}
