/*
 * Create by BobEve on 17-12-13 上午12:51
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-3-13 上午11:50
 */

package bob.eve.repository.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.net.UnknownServiceException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Bob on 2017/3/8.
 */

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
	private final Gson gson;
	private final TypeAdapter<T> adapter;

	GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
		this.gson = gson;
		this.adapter = adapter;
	}

	@Override
	public T convert(ResponseBody value) throws IOException {
		if (adapter != null && gson != null) {
			JsonReader jsonReader = gson.newJsonReader(value.charStream());
			try {
				T data = adapter.read(jsonReader);
				if (data == null) {
					throw new UnknownServiceException("server back data is null");
				}
				//                if (data instanceof ApiResult) {
				//                    ApiResult apiResult = (ApiResult) data;
				//                    if (!ApiException.isSuccess(apiResult)) {
				//                        throw new UnknownServiceException(apiResult.getMsg() == null ? "unknow error" : apiResult.getMsg());
				//                    }
				//                }
				return data;
			} finally {
				value.close();
			}
		} else {
			return null;
		}
	}
}
