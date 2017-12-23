/*
 * Create by BobEve on 17-12-21 上午11:25
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午11:25
 */

package bob.eve.walle.ui.widget.transition;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;
import bob.eve.comm.lib.util.FastBlur;
import bob.eve.comm.lib.util.RSBlur;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

/**
 * Created by Bob on 17/12/21.
 */

public class BlurTransformation implements Transformation<Bitmap> {

	private static int MAX_RADIUS = 25;
	private static int DEFAULT_DOWN_SAMPLING = 1;

	private BitmapPool mBitmapPool;

	private int mRadius;
	private int mSampling;

	public BlurTransformation(Context context) {
		this(context, Glide.get(context)
											 .getBitmapPool(), MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
	}

	public BlurTransformation(Context context, BitmapPool pool) {
		this(context, pool, MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
	}

	public BlurTransformation(Context context, BitmapPool pool, int radius) {
		this(context, pool, radius, DEFAULT_DOWN_SAMPLING);
	}

	public BlurTransformation(Context context, int radius) {
		this(context, Glide.get(context)
											 .getBitmapPool(), radius, DEFAULT_DOWN_SAMPLING);
	}

	public BlurTransformation(Context context, BitmapPool pool, int radius, int sampling) {
		mBitmapPool = pool;
		mRadius = radius;
		mSampling = sampling;
	}

	public BlurTransformation(Context context, int radius, int sampling) {
		mBitmapPool = Glide.get(context)
											 .getBitmapPool();
		mRadius = radius;
		mSampling = sampling;
	}

	@Override
	public Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int outWidth,
																		int outHeight) {
		Bitmap source = resource.get();

		int width = source.getWidth();
		int height = source.getHeight();
		int scaledWidth = width / mSampling;
		int scaledHeight = height / mSampling;

		Bitmap bitmap = mBitmapPool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmap);
		canvas.scale(1 / (float) mSampling, 1 / (float) mSampling);
		Paint paint = new Paint();
		paint.setFlags(Paint.FILTER_BITMAP_FLAG);
		canvas.drawBitmap(source, 0, 0, paint);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			try {
				bitmap = RSBlur.blur(context, bitmap, mRadius);
			} catch (RSRuntimeException e) {
				bitmap = FastBlur.blur(bitmap, mRadius, true);
			}
		} else {
			bitmap = FastBlur.blur(bitmap, mRadius, true);
		}

		return BitmapResource.obtain(bitmap, mBitmapPool);
	}

	@Override
	public void updateDiskCacheKey(MessageDigest messageDigest) {

	}
}