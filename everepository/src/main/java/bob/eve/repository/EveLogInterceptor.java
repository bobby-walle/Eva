/*
 * Create by BobEve on 17-12-9 下午5:40
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午5:40
 */

package bob.eve.repository;

import android.support.annotation.Nullable;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Bob on 17/12/9.
 */

@Singleton
public class EveLogInterceptor implements Interceptor {
	private final String TAG = "EveLogInterceptor";

	private EveInterceptorOnRequestResponseHandler hanlder;

	@Inject
	public EveLogInterceptor(@Nullable EveInterceptorOnRequestResponseHandler hanlder) {
		this.hanlder = hanlder;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();

		long t1 = System.nanoTime();
		Response originalResponse = chain.proceed(request);
		long t2 = System.nanoTime();

		// TODO 配置打印级别和Log开关
		Log.e(TAG, request.url()
											.toString() + "请求时间：" + TimeUnit.NANOSECONDS.toMillis(t2 - t1));

		ResponseBody responseBody = originalResponse.body();

		if (hanlder != null) {
			hanlder.whenOkHttpResponse(responseBody, chain, originalResponse);
		}
		return originalResponse;
	}
}
