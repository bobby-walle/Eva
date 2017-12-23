/*
 * Create by BobEve on 17-12-21 上午11:54
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午11:54
 */

package bob.eve.walle.ui.widget.imageloader;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by Bob on 17/12/21.
 */
@GlideModule
public class CustomGlideModule extends AppGlideModule {
	@Override
	public boolean isManifestParsingEnabled() {
		return false;
	}

	@Override
	public void applyOptions(Context context, GlideBuilder builder) {
		MemorySizeCalculator calculator =
				new MemorySizeCalculator.Builder(context).setMemoryCacheScreens(6) // 缓存图片数量
																								 .build();
		builder.setMemoryCache(new LruResourceCache(calculator.getMemoryCacheSize()));

		/*
		int memoryCacheSizeBytes = 1024 * 1024 * 20; // 20mb
		builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));
		*/
	}
}
