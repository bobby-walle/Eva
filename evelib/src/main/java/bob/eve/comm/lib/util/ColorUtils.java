/*
 * Create by BobEve on 17-12-16 下午7:24
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-16 下午7:24
 */

package bob.eve.comm.lib.util;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.support.annotation.FloatRange;

/**
 * Created by Bob on 17/12/16.
 */

public class ColorUtils {
	/**
	 * 获取当前颜色的深色
	 */
	public static int getDarkerColor(int color) {
		return getDarkerColor(color, 0.1f);
	}

	/**
	 * 获取当前颜色的浅色
	 */
	public static int getBrighterColor(int color) {
		return getBrighterColor(color, 0.1f);
	}

	/**
	 * 获取当前颜色的深色
	 */
	public static int getDarkerColor(int color, float value) {
		float[] hsv = new float[3];
		Color.colorToHSV(color, hsv); // convert to hsv
		// make darker
		hsv[1] = hsv[1] + value; // more saturation
		hsv[2] = hsv[2] - value; // less brightness
		return Color.HSVToColor(hsv);
	}

	/**
	 * 获取当前颜色的浅色
	 */
	public static int getBrighterColor(int color, float value) {
		float[] hsv = new float[3];
		Color.colorToHSV(color, hsv); // convert to hsv

		hsv[1] = hsv[1] - value; // less saturation
		hsv[2] = hsv[2] + value; // more brightness
		return Color.HSVToColor(hsv);
	}

	public static int argbEvaluatorColor(@FloatRange(from = 0.0f, to = 1.0f) float offset,
																			 int firstColor, int secondColor) {
		ArgbEvaluator argbEvaluator = new ArgbEvaluator();//渐变色计算类
		return (int) argbEvaluator.evaluate(offset, firstColor, secondColor);
	}

	/**
	 * 颜色渐变算法
	 * 获取某个百分比下的渐变颜色值
	 */
	public static int getCurrentColor(float percent, int[] colors) {
		float[][] f = new float[colors.length][3];
		for (int i = 0; i < colors.length; i++) {
			f[i][0] = (colors[i] & 0xff0000) >> 16;
			f[i][1] = (colors[i] & 0x00ff00) >> 8;
			f[i][2] = (colors[i] & 0x0000ff);
		}
		float[] result = new float[3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < f.length; j++) {
				if (f.length == 1 || percent == j / (f.length - 1f)) {
					result = f[j];
				} else {
					if (percent > j / (f.length - 1f) && percent < (j + 1f) / (f.length - 1)) {
						result[i] = f[j][i] - f[j][i] * (percent - j / (f.length - 1f)) * (f.length - 1f);
					}
				}
			}
		}
		return Color.rgb((int) result[0], (int) result[1], (int) result[2]);
	}
}
