/*
 * Create by BobEve on 17-12-21 上午11:34
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午11:34
 */

package bob.eve.walle.ui.widget.imageloader;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import bob.eve.walle.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Bob on 17/12/21.
 */

public class GlideImageLoader implements IImageLoder {
	private static class SingleHandler {
		private static final GlideImageLoader INSTANCE = new GlideImageLoader();
	}

	private GlideImageLoader() {
	}

	public static GlideImageLoader getInstance() {
		return SingleHandler.INSTANCE;
	}

	@Override
	public void displayImage(Context context, String url, ImageView imageView) {
		Glide.with(context)
				 .load(url)
				 .thumbnail(0.3f)
				 .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
																		.error(R.drawable.ic_error_image)
																		.centerCrop())
				 .transition(DrawableTransitionOptions.withCrossFade(800))
				 .into(imageView);
	}

	@Override
	public void displayImageWithoutCrop(Context context, String url, ImageView imageView) {
		Glide.with(context)
				 .load(url)
				 .thumbnail(0.3f)
				 .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
																		.skipMemoryCache(true)
																		.error(R.drawable.ic_error_image))
				 .transition(DrawableTransitionOptions.withCrossFade(800))
				 .into(imageView);
	}

	@Override
	public void displayImage(Context context, int resID, ImageView imageView) {
		Glide.with(context)
				 .load(resID)
				 .apply(new RequestOptions().centerInside())
				 .transition(DrawableTransitionOptions.withCrossFade())
				 .into(imageView);
	}

	@Override
	public void displayImage(Fragment fragment, String url, ImageView imageView) {
		Glide.with(fragment)
				 .load(url)
				 .thumbnail(0.3f)
				 .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
																		.error(R.drawable.ic_error_image)
																		.centerCrop())
				 .transition(DrawableTransitionOptions.withCrossFade(800))
				 .into(imageView);
	}

	@Override
	public void displayImageWithoutCrop(Fragment fragment, String url, ImageView imageView) {
		Glide.with(fragment)
				 .load(url)
				 .thumbnail(0.3f)
				 .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
																		.skipMemoryCache(true)
																		.error(R.drawable.ic_error_image))
				 .transition(DrawableTransitionOptions.withCrossFade(800))
				 .into(imageView);
	}

	@Override
	public void displayImage(Fragment fragment, int resID, ImageView imageView) {
		Glide.with(fragment)
				 .load(resID)
				 .apply(new RequestOptions().centerInside())
				 .transition(DrawableTransitionOptions.withCrossFade())
				 .into(imageView);
	}

	@Override
	public void displayImage(View view, String url, ImageView imageView) {
		Glide.with(view)
				 .load(url)
				 .thumbnail(0.3f)
				 .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
																		.error(R.drawable.ic_error_image)
																		.centerCrop())
				 .transition(DrawableTransitionOptions.withCrossFade(800))
				 .into(imageView);
	}

	@Override
	public void displayImageWithoutCrop(View view, String url, ImageView imageView) {
		Glide.with(view)
				 .load(url)
				 .thumbnail(0.3f)
				 .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
																		.skipMemoryCache(true)
																		.error(R.drawable.ic_error_image))
				 .transition(DrawableTransitionOptions.withCrossFade(800))
				 .into(imageView);
	}

	@Override
	public void displayImage(View view, int resID, ImageView imageView) {
		Glide.with(view)
				 .load(resID)
				 .apply(new RequestOptions().centerInside())
				 .transition(DrawableTransitionOptions.withCrossFade())
				 .into(imageView);
	}

	@Override
	public void displayImageWithoutPlace(Fragment fragment, String url, ImageView imageView) {
		Glide.with(fragment)
				 .load(url)
				 .thumbnail(0.3f)
				 .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
																		.centerCrop()
																		.error(R.drawable.ic_error_image))
				 .transition(DrawableTransitionOptions.withCrossFade(800))
				 .into(imageView);
	}
}
