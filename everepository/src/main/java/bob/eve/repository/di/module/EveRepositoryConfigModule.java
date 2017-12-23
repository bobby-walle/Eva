/*
 * Create by BobEve on 17-12-9 下午10:25
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午10:25
 */

package bob.eve.repository.di.module;

import android.app.Application;
import android.support.annotation.Nullable;
import bob.eve.comm.lib.configuration.AbsBuilderConfig;
import bob.eve.comm.lib.util.Preconditions;
import bob.eve.repository.EveInterceptorOnRequestResponseHandler;
import bob.eve.repository.cache.IEveCache;
import bob.eve.repository.cache.IEveCacheType;
import bob.eve.repository.cache.LruCache;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.util.List;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

/**
 * Created by Bob on 17/12/9.
 */

@Module
public class EveRepositoryConfigModule extends AbsBuilderConfig {
	private HttpUrl baseUrl;
	private EveInterceptorOnRequestResponseHandler hanlder;
	private List<Interceptor> interceptors;
	private File rootCacheDir; // 获取App缓存根目录
	private String rxCacheDirName; // 在#rootCacheDir中设置RxCache的缓存目录
	private EveRepositoryModule.RetrofitConfiguration retrofitConfiguration;
	private EveRepositoryModule.OkHttpClientConfiguration okHttpClientConfiguration;
	private EveRepositoryModule.RxCacheConfiguration rxCacheConfiguration;
	private EveRepositoryModule.GsonConfiguration gsonConfiguration;
	private IEveCache.Factory eveCacheFactory;

	private EveRepositoryConfigModule(Builder builder) {
		this.baseUrl = builder.baseUrl;
		this.hanlder = builder.hanlder;
		this.interceptors = builder.interceptors;
		this.rootCacheDir = builder.rootCacheDir;
		this.rxCacheDirName = builder.rxCacheDirName;
		this.retrofitConfiguration = builder.retrofitConfiguration;
		this.okHttpClientConfiguration = builder.okHttpClientConfiguration;
		this.rxCacheConfiguration = builder.rxCacheConfiguration;
		this.gsonConfiguration = builder.gsonConfiguration;
		this.eveCacheFactory = builder.eveCacheFactory;
	}

	public static Builder builder() {
		return new Builder();
	}

	@Singleton
	@Provides
	public HttpUrl provideBaseUrl() {
		return baseUrl;
	}

	@Singleton
	@Provides
	@Nullable
	public EveInterceptorOnRequestResponseHandler provideHanlder() {
		return hanlder;
	}

	@Singleton
	@Provides
	@Nullable
	public List<Interceptor> provideInterceptors() {
		return interceptors;
	}

	@Singleton
	@Provides
	public File provideRootCacheDir() {
		return rootCacheDir;
	}

	@Singleton
	@Provides
	public String provideRxCacheDirName() {
		return rxCacheDirName;
	}

	@Singleton
	@Provides
	@Nullable
	public EveRepositoryModule.RetrofitConfiguration provideRetrofitConfiguration() {
		return retrofitConfiguration;
	}

	@Singleton
	@Provides
	@Nullable
	public EveRepositoryModule.OkHttpClientConfiguration provideOkHttpClientConfiguration() {
		return okHttpClientConfiguration;
	}

	@Singleton
	@Provides
	@Nullable
	public EveRepositoryModule.RxCacheConfiguration provideRxCacheConfiguration() {
		return rxCacheConfiguration;
	}

	@Singleton
	@Provides
	@Nullable
	public EveRepositoryModule.GsonConfiguration provideGsonConfiguration() {
		return gsonConfiguration;
	}

	@Singleton
	@Provides
	public IEveCache.Factory provideEveCacheFactory(final Application application) {
		// 可以自定义缓存策略和方式，继承{@link #IEveCache}即可
		return eveCacheFactory == null ? new IEveCache.Factory() {
			@Override
			public IEveCache build(IEveCacheType type) {
				return new LruCache(type.calculateCacheSize(application));
			}
		} : eveCacheFactory;
	}

	public static final class Builder extends AbsBuilderConfig.AbsBuilder {
		private HttpUrl baseUrl;
		private EveInterceptorOnRequestResponseHandler hanlder;
		private List<Interceptor> interceptors;
		private File rootCacheDir; // 获取App缓存根目录
		private String rxCacheDirName; // 在#rootCacheDir中设置RxCache的缓存目录
		private EveRepositoryModule.RetrofitConfiguration retrofitConfiguration;
		private EveRepositoryModule.OkHttpClientConfiguration okHttpClientConfiguration;
		private EveRepositoryModule.RxCacheConfiguration rxCacheConfiguration;
		private EveRepositoryModule.GsonConfiguration gsonConfiguration;
		private IEveCache.Factory eveCacheFactory;

		private Builder() {
		}

		@Override
		public EveRepositoryConfigModule build() {
			return new EveRepositoryConfigModule(this);
		}

		public Builder setBaseUrl(String baseUrl) {
			Preconditions.checkNotNull(baseUrl, "BaseUr can not be null!");
			this.baseUrl = HttpUrl.parse(baseUrl);
			return this;
		}

		public Builder setEveInterceptorOnRequestResponseHandler(
				EveInterceptorOnRequestResponseHandler hanlder) {
			this.hanlder = hanlder;
			return this;
		}

		public Builder setInterceptors(List<Interceptor> interceptors) {
			this.interceptors = interceptors;
			return this;
		}

		public Builder setRootCacheDir(File rootCacheDir) {
			this.rootCacheDir = rootCacheDir;
			return this;
		}

		public Builder setRxCacheDirName(String rxCacheDirName) {
			this.rxCacheDirName = rxCacheDirName;
			return this;
		}

		public Builder setRetrofitConfiguration(
				EveRepositoryModule.RetrofitConfiguration retrofitConfiguration) {
			this.retrofitConfiguration = retrofitConfiguration;
			return this;
		}

		public Builder setOkHttpClientConfiguration(
				EveRepositoryModule.OkHttpClientConfiguration okHttpClientConfiguration) {
			this.okHttpClientConfiguration = okHttpClientConfiguration;
			return this;
		}

		public Builder setRxCacheConfiguration(
				EveRepositoryModule.RxCacheConfiguration rxCacheConfiguration) {
			this.rxCacheConfiguration = rxCacheConfiguration;
			return this;
		}

		public void setGsonConfiguration(EveRepositoryModule.GsonConfiguration gsonConfiguration) {
			this.gsonConfiguration = gsonConfiguration;
		}

		public Builder setEveCacheFactory(IEveCache.Factory eveCacheFactory) {
			this.eveCacheFactory = eveCacheFactory;
			return this;
		}
	}
}
