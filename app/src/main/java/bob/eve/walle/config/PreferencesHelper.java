/*
 * Create by BobEve on 17-12-20 下午7:21
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午7:21
 */

package bob.eve.walle.config;

/**
 * Created by Bob on 17/12/20.
 */

public interface PreferencesHelper {

	boolean getNightModeState();

	void setNightModeState(boolean state);

	boolean getNoImageState();

	void setNoImageState(boolean state);

	boolean getAutoCacheState();

	void setAutoCacheState(boolean state);

	int getFragmentIndex();

	void setFragmentIndex(int index);
}
