/*
 * Create by BobEve on 17-12-9 下午10:25
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午8:51
 */

package bob.eve.repository.di.module;

import android.app.Application;
import android.support.annotation.Nullable;
import bob.eve.comm.lib.util.Preconditions;
import bob.eve.repository.EveInterceptorOnRequestResponseHandler;
import bob.eve.repository.EveLogInterceptor;
import bob.eve.repository.EveRepositoryManager;
import bob.eve.repository.IEveRepositoryManager;
import bob.eve.repository.converter.GsonConverterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Bob on 17/12/9.
 *
 * 对外提供各种实例支持，或者获取或者参数使用
 * 提供的对象基本稳定，不需再次配置，配置方式见{@link EveRepositoryConfigModule}
 */

@Module
public class EveRepositoryModule {
	private static final int TIME_OUT = 10;

	@Singleton
	@Provides
	Retrofit provideRetrofit(Application application, @Nullable RetrofitConfiguration configuration,
													 Retrofit.Builder builder, OkHttpClient client, HttpUrl url,
													 @Nullable Gson gson) {

		Preconditions.checkNotNull(builder, "builder cannot null with provideRetrofit");
		builder.baseUrl(url)
					 .client(client);

		if (configuration != null) {
			configuration.configureRetrofit(application, builder);
		}

		// gson==null 会NPE
		if (gson == null) {
			builder.addConverterFactory(GsonConverterFactory.create());
		} else {
			builder.addConverterFactory(GsonConverterFactory.create(gson));
		}

		builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());

		return builder.build();
	}

	@Singleton
	@Provides
	OkHttpClient provideOkHttpClient(Application application,
																	 @Nullable OkHttpClientConfiguration configuration,
																	 OkHttpClient.Builder builder,
																	 EveLogInterceptor eveLogInterceptor,
																	 @Nullable List<Interceptor> extraInterceptors,
																	 @Nullable final EveInterceptorOnRequestResponseHandler handler) {

		Preconditions.checkNotNull(builder, "builder cannot null with provideOkHttpClient");
		builder.addNetworkInterceptor(eveLogInterceptor)
					 .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
					 .readTimeout(TIME_OUT, TimeUnit.SECONDS)
					 .writeTimeout(TIME_OUT, TimeUnit.SECONDS);

		if (configuration != null) {
			configuration.configureOkHttpClient(application, builder);
		}

		if (extraInterceptors != null) {
			final int size = extraInterceptors.size();
			for (int i = 0; i < size; i++) {
				builder.addInterceptor(extraInterceptors.get(i));
			}
		}

		if (handler != null) {
			builder.addInterceptor(new Interceptor() {
				@Override
				public Response intercept(Chain chain) throws IOException {
					return chain.proceed(handler.beforeOkHttpRequest(chain, chain.request()));
				}
			});
		}

		return builder.build();
	}

	@Singleton
	@Provides
	RxCache provideRxCache(Application application, @Nullable RxCacheConfiguration configuration,
												 File cacheDir) {
		RxCache.Builder builder = new RxCache.Builder();

		RxCache rxCache = null;
		if (configuration != null) {
			rxCache = configuration.configureRxCache(application, builder);
		}

		if (rxCache != null) {
			return rxCache;
		}

		return builder.persistence(cacheDir, new GsonSpeaker());
	}

	@Singleton
	@Provides
	Gson provideGson(Application application, @Nullable GsonConfiguration configuration) {
		GsonBuilder builder = new GsonBuilder();
		if (configuration != null) {
			configuration.configureGson(application, builder);
		}

		return builder.create();
	}

	@Singleton
	@Provides
	IEveRepositoryManager provideEveRepositoryManager(EveRepositoryManager eveRepositoryManager) {
		return eveRepositoryManager;
	}

	@Singleton
	@Provides
	Retrofit.Builder provideRetrofitBuilder() {
		return new Retrofit.Builder();
	}

	@Singleton
	@Provides
	OkHttpClient.Builder provideOkHttpClientBuilder() {
		return new OkHttpClient.Builder();
	}

	public interface RetrofitConfiguration {
		void configureRetrofit(Application application, Retrofit.Builder builder);
	}

	public interface OkHttpClientConfiguration {
		void configureOkHttpClient(Application application, OkHttpClient.Builder builder);
	}

	public interface RxCacheConfiguration {
		RxCache configureRxCache(Application application, RxCache.Builder builder);
	}

	public interface GsonConfiguration {
		void configureGson(Application application, GsonBuilder builder);
	}
}
