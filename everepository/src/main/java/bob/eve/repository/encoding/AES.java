/*
 * Create by BobEve on 17-12-10 下午5:29
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午5:29
 */

package bob.eve.repository.encoding;

import android.util.Base64;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Bob on 17/12/10.
 */

public final class AES {
	private static final String LOG_TAG = "AES";
	public static final String ALGORITHM = "AES";

	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.decode(key, Base64.DEFAULT);
	}

	public static String encryptBASE64(byte[] key) throws Exception {
		return Base64.encodeToString(key, Base64.DEFAULT);
	}

	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		return secretKey;
	}

	public static byte[] decrypt(byte[] data, String key) throws Exception {
		Key k = toKey(decryptBASE64(key));

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	public static byte[] encrypt(byte[] data, String key) throws Exception {
		Key k = toKey(decryptBASE64(key));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	public static String initKey() throws Exception {
		return initKey(null);
	}

	public static String initKey(String seed) throws Exception {
		SecureRandom secureRandom = null;

		if (seed != null) {
			secureRandom = new SecureRandom(decryptBASE64(seed));
		} else {
			secureRandom = new SecureRandom();
		}

		KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
		kg.init(secureRandom);

		SecretKey secretKey = kg.generateKey();

		return encryptBASE64(secretKey.getEncoded());
	}
}
