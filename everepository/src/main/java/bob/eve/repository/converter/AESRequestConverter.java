/*
 * Create by BobEve on 17-12-10 下午5:24
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午5:24
 */

package bob.eve.repository.converter;

import bob.eve.repository.encoding.AES;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by Bob on 17/12/10.
 */

public class AESRequestConverter<T> implements Converter<T, RequestBody> {
	private static final String LOG_TAG = "RequestConverter";
	private static final MediaType MEDIA_TYPE = MediaType.parse("application/wxt;charset=UTF-8");
	private static final MediaType MEDIA_TYPE1 = MediaType.parse("application/json;charset=UTF-8");
	private boolean isAes;
	private Gson gson;

	public AESRequestConverter(boolean isAes, Gson gson) {
		this.isAes = isAes;
		this.gson = gson;
	}

	/**
	 * @param value
	 * 		加密可能失败，需要进行处理
	 */
	@Override
	public RequestBody convert(T value) throws IOException {
		if (isAes) {
			AES aes = new AES();
			try {
				return RequestBody.create(MEDIA_TYPE, aes.encrypt(gson.toJson(value)
																															.getBytes(), AES.ALGORITHM));
			} catch (Exception e) {
				return null;
			}
		} else {
			return RequestBody.create(MEDIA_TYPE1, gson.toJson(value));
		}
	}
}
