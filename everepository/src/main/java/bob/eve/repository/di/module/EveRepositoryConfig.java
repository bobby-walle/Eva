/*
 * Create by BobEve on 17-12-12 下午10:23
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-12 下午9:29
 */

package bob.eve.repository.di.module;

import android.app.Application;
import android.content.Context;
import bob.eve.comm.lib.configuration.IConfiguration;
import bob.eve.repository.cache.IEveCache;
import bob.eve.repository.cache.IEveCacheType;
import bob.eve.repository.cache.LruCache;
import io.rx_cache2.internal.RxCache;

/**
 * Created by Bob on 17/12/11.
 *
 * TODO 移动到App包
 */

public class EveRepositoryConfig implements IConfiguration<EveRepositoryConfigModule.Builder> {

	@Override
	public void applyOptions(Context context, EveRepositoryConfigModule.Builder builder) {
		builder.setBaseUrl("http://www.weather.com.cn/data/city3jdata/")
					 .setRootCacheDir(context.getCacheDir())
					 .setRxCacheDirName("rx_cities")
					 //					 .setRetrofitConfiguration(new EveRepositoryModule.RetrofitConfiguration() {
					 //						 @Override
					 //						 public void configureRetrofit(Application application, Retrofit.Builder builder) {
					 //							 builder.addConverterFactory(GsonConverterFactory.create());
					 //						 }
					 //					 })
					 .setRxCacheConfiguration(new EveRepositoryModule.RxCacheConfiguration() {

						 @Override
						 public RxCache configureRxCache(Application application, RxCache.Builder builder) {
							 return null;
						 }
					 })
					 .setEveCacheFactory(new IEveCache.Factory() {
						 @Override
						 public IEveCache build(IEveCacheType type) {
							 return new LruCache(10);
						 }
					 })
					 .build();
	}
}
