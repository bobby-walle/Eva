/*
 * Create by BobEve on 17-12-13 上午12:51
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-3-13 上午11:50
 */

package bob.eve.repository.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/**
 * Created by Bob on 2017/3/8.
 */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
	private static final MediaType MEDIA_TYPE = MediaType.parse("init/json; charset=UTF-8");
	private static final Charset UTF_8 = Charset.forName("UTF-8");

	private final Gson gson;
	private final TypeAdapter<T> adapter;

	GsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
		this.gson = gson;
		this.adapter = adapter;
	}

	@Override
	public RequestBody convert(T value) throws IOException {
		Buffer buffer = new Buffer();
		Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
		JsonWriter jsonWriter = gson.newJsonWriter(writer);
		adapter.write(jsonWriter, value);
		jsonWriter.close();
		return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
	}
}