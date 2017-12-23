/*
 * Create by BobEve on 17-12-10 下午5:23
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午5:23
 */

package bob.eve.repository.converter;

import bob.eve.repository.encoding.AES;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Bob on 17/12/10.
 */

public class AESResponseConverter<T> implements Converter<ResponseBody, T> {
	private static final String LOG_TAG = "ResponseConverter";

	private boolean isAes;
	private Type type;

	public AESResponseConverter(Type type, boolean isAes) {
		this.isAes = isAes;
		this.type = type;
	}

	/**
	 * @return T
	 * 加密可能失败，需要进行处理
	 */
	@Override
	public T convert(ResponseBody value) {
		try {
			if (isAes) {
				byte[] b = value.bytes();
				AES aes = new AES();
				byte[] a = aes.decrypt(b, AES.ALGORITHM);
				String json = new String(a);
				return new Gson().fromJson(json, type);
			} else {
				String json = value.string();
				return new Gson().fromJson(json, type);
			}
		} catch (IOException e) {
			return null;
		} catch (Exception e) {
			return null;
		} finally {
			value.close();
		}
	}
}


