/*
 * Create by BobEve on 17-12-21 上午11:31
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午11:31
 */

package bob.eve.walle.ui.widget.imageloader;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Bob on 17/12/21.
 */

public interface IImageLoder {

	void displayImage(Context context, String url, ImageView imageView);

	void displayImageWithoutCrop(Context context, String url, ImageView imageView);

	void displayImage(Context context, @DrawableRes int resID, ImageView imageView);

	void displayImage(Fragment fragment, String url, ImageView imageView);

	void displayImageWithoutCrop(Fragment fragment, String url, ImageView imageView);

	void displayImage(Fragment fragment, @DrawableRes int resID, ImageView imageView);

	void displayImage(View view, String url, ImageView imageView);

	void displayImageWithoutCrop(View view, String url, ImageView imageView);

	void displayImage(View view, @DrawableRes int resID, ImageView imageView);

	void displayImageWithoutPlace(Fragment fragment, String url, ImageView imageView);
}
