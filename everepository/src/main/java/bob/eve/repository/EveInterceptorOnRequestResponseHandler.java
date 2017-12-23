/*
 * Create by BobEve on 17-12-9 下午5:09
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午5:09
 */

package bob.eve.repository;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Bob on 17/12/9.
 */

public interface EveInterceptorOnRequestResponseHandler {
	// 在服务器响应后，客户端处理前，可处理验证操作(eg. token)
	Response whenOkHttpResponse(ResponseBody body, Interceptor.Chain chain, Response response);

	// 在客户端请求后，服务器接收前，可处理统一参数、请求头等
	Request beforeOkHttpRequest(Interceptor.Chain chain, Request request);
}
