/*
 * Create by BobEve on 17-12-10 下午3:44
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午3:44
 */

package bob.eve.repository.cookies;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Bob on 17/12/10.
 */

public class InDiskCookieStore implements CookieStore {
	private static final String TAG = "InDiskCookieStore";
	private static final String COOKIE_PREFS = "CookiePrefsFile";
	private static final String COOKIE_NAME_PREFIX = "cookie_";

	private final HashMap<String, ConcurrentHashMap<String, HttpCookie>> cookies;
	private final SharedPreferences cookiePrefs;

	private ReentrantLock mLock = null;

	public InDiskCookieStore(Context context) {
		cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
		mLock = new ReentrantLock(false);
		cookies = new HashMap<>();
		initMemoryCookie();
	}

	private void initMemoryCookie() {
		// 加载本地cookie到内存中，注意SharePreferences存储结构
		Map<String, ?> prefsMap = cookiePrefs.getAll();
		for (Map.Entry<String, ?> entry : prefsMap.entrySet()) {
			if (((String) entry.getValue()) != null &&
					!((String) entry.getValue()).startsWith(COOKIE_NAME_PREFIX)) {
				String[] cookieNames = TextUtils.split((String) entry.getValue(), ",");
				for (String name : cookieNames) {
					String encodedCookie = cookiePrefs.getString(COOKIE_NAME_PREFIX + name, null);
					if (encodedCookie != null) {
						HttpCookie decodedCookie = decodeCookie(encodedCookie);
						if (decodedCookie != null) {
							if (!cookies.containsKey(entry.getKey())) {
								cookies.put(entry.getKey(), new ConcurrentHashMap<String, HttpCookie>());
							}
							cookies.get(entry.getKey())
										 .put(name, decodedCookie);
						}
					}
				}
			}
		}
	}

	@Override
	public void add(URI uri, HttpCookie cookie) {
		mLock.lock();
		try {
			String name = getCookieToken(uri, cookie);

			if (!cookie.hasExpired()) {
				if (!cookies.containsKey(uri.getHost())) {
					cookies.put(uri.getHost(), new ConcurrentHashMap<String, HttpCookie>());
				}
				cookies.get(uri.getHost())
							 .put(name, cookie);
			} else {//清除过期cookie
				if (cookies.containsKey(uri.toString())) {
					cookies.get(uri.getHost())
								 .remove(name);
				}
			}

			// Save cookie into persistent store
			SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
			prefsWriter.putString(uri.getHost(), TextUtils.join(",", cookies.get(uri.getHost())
																																			.keySet()));
			prefsWriter.putString(COOKIE_NAME_PREFIX + name, encodeCookie(new DiskHttpCookie(cookie)));
			prefsWriter.commit();
		} finally {
			mLock.unlock();
		}
	}

	protected String getCookieToken(URI uri, HttpCookie cookie) {
		return cookie.getName() + cookie.getDomain();
	}

	@Override
	public List<HttpCookie> get(URI uri) {
		mLock.lock();
		ArrayList<HttpCookie> ret = new ArrayList<HttpCookie>();
		if (cookies.containsKey(uri.getHost())) {
			ret.addAll(cookies.get(uri.getHost())
												.values());
		}
		mLock.unlock();
		return ret;
	}

	@Override
	public boolean removeAll() {
		mLock.lock();
		try {
			SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
			prefsWriter.clear();
			prefsWriter.commit();
			cookies.clear();
		} finally {
			mLock.unlock();
		}
		return true;
	}

	@Override
	public boolean remove(URI uri, HttpCookie cookie) {
		mLock.lock();
		try {
			String name = getCookieToken(uri, cookie);
			if (cookies.containsKey(uri.getHost()) && cookies.get(uri.getHost())
																											 .containsKey(name)) {
				cookies.get(uri.getHost())
							 .remove(name);

				SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
				if (cookiePrefs.contains(COOKIE_NAME_PREFIX + name)) {
					prefsWriter.remove(COOKIE_NAME_PREFIX + name);
				}
				prefsWriter.putString(uri.getHost(), TextUtils.join(",", cookies.get(uri.getHost())
																																				.keySet()));
				prefsWriter.commit();

				return true;
			} else {
				return false;
			}
		} finally {
			mLock.unlock();
		}
	}

	@Override
	public List<HttpCookie> getCookies() {
		mLock.lock();

		ArrayList<HttpCookie> ret = new ArrayList<HttpCookie>();
		for (String key : cookies.keySet())
			ret.addAll(cookies.get(key)
												.values());
		mLock.unlock();
		return ret;
	}

	@Override
	public List<URI> getURIs() {
		mLock.lock();
		ArrayList<URI> ret = new ArrayList<URI>();
		for (String key : cookies.keySet())
			try {
				ret.add(new URI(key));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

		mLock.unlock();
		return ret;
	}

	//序列化DiskHttpCookie，并将其转为字符串
	protected String encodeCookie(DiskHttpCookie cookie) {
		if (cookie == null) {
			return null;
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(os);
			outputStream.writeObject(cookie);
		} catch (IOException e) {
			Log.d(TAG, "IOException in encodeCookie", e);
			return null;
		}

		return byteArrayToHexString(os.toByteArray());
	}

	//通过cookie字符串反序列化为HttpCookie对象
	protected HttpCookie decodeCookie(String cookieString) {
		byte[] bytes = hexStringToByteArray(cookieString);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		HttpCookie cookie = null;
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			cookie = ((DiskHttpCookie) objectInputStream.readObject()).getCookie();
		} catch (IOException e) {
			Log.d(TAG, "IOException in decodeCookie", e);
		} catch (ClassNotFoundException e) {
			Log.d(TAG, "ClassNotFoundException in decodeCookie", e);
		}

		return cookie;
	}

	//字节转16进制
	protected String byteArrayToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte element : bytes) {
			int v = element & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString()
						 .toUpperCase(Locale.US);
	}

	//16进制转字节
	protected byte[] hexStringToByteArray(String hexString) {
		int len = hexString.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) +
														Character.digit(hexString.charAt(i + 1), 16));
		}
		return data;
	}
}