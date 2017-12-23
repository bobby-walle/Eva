/*
 * Create by BobEve on 17-12-18 下午6:56
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午6:56
 */

package bob.eve.comm.lib.layout.viewpager;

/**
 * Created by Bob on 17/12/18.
 */

public enum Mode {

	LEFT_OVERLAY(0), RIGHT_OVERLAY(1), NONE(2);
	int value;

	Mode(int value) {
		this.value = value;
	}
}