/*
 * Create by BobEve on 17-12-11 下午6:22
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午5:21
 */

package bob.eve.comm.lib.configuration;

import android.content.Context;

/**
 * Created by Bob on 17/12/11.
 */

public interface IConfiguration<T> {
	void applyOptions(Context context, T builder);
}
