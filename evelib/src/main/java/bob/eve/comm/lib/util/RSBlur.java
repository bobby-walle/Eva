/*
 * Create by BobEve on 17-12-21 上午11:26
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午11:26
 */

package bob.eve.comm.lib.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * Created by Bob on 17/12/21.
 */
public class RSBlur {
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static Bitmap blur(Context context, Bitmap blurredBitmap, int radius)
			throws RSRuntimeException {
		try {
			RenderScript rs = RenderScript.create(context);
			Allocation input =
					Allocation.createFromBitmap(rs, blurredBitmap, Allocation.MipmapControl.MIPMAP_NONE,
																			Allocation.USAGE_SCRIPT);
			Allocation output = Allocation.createTyped(rs, input.getType());
			ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

			blur.setInput(input);
			blur.setRadius(radius);
			blur.forEach(output);
			output.copyTo(blurredBitmap);
			rs.destroy();
		} catch (RSRuntimeException e) {
			blurredBitmap = FastBlur.blur(blurredBitmap, radius, true);
		}
		return blurredBitmap;
	}
}