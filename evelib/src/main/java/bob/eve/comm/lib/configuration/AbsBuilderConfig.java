/*
 * Create by BobEve on 17-12-11 下午6:21
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午6:11
 */

package bob.eve.comm.lib.configuration;

/**
 * Created by Bob on 17/12/11.
 */

public abstract class AbsBuilderConfig {

	public abstract static class AbsBuilder<T> {

		protected abstract T build();
	}
}
