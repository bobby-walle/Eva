/*
 * Create by BobEve on 17-12-9 下午10:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午10:01
 */

package bob.eve.comm.lib.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Bob on 17/12/9.
 */

public class IOUtils {

	private IOUtils() {
		throw new AssertionError();
	}

	/**
	 * Close closable object and wrap {@link IOException} with {@link RuntimeException}
	 *
	 * @param closeable
	 * 		closeable object
	 */
	public static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				throw new RuntimeException("IOException occurred. ", e);
			}
		}
	}

	/**
	 * Close closable and hide possible {@link IOException}
	 *
	 * @param closeable
	 * 		closeable object
	 */
	public static void closeQuietly(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				// Ignored
			}
		}
	}
}