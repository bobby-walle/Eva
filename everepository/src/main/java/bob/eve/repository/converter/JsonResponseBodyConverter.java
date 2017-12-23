/*
 * Create by BobEve on 17-12-13 上午12:51
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-7 下午4:21
 */

package bob.eve.repository.converter;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Bob on 2017/3/8.
 */

final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

	JsonResponseBodyConverter() {
	}

	@Override
	public T convert(ResponseBody value) throws IOException {
		return (T) value.string();
	}
}
