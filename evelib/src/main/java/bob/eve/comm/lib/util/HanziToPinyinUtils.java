/*
 * Create by BobEve on 17-12-14 下午2:24
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午2:24
 */

package bob.eve.comm.lib.util;

import java.util.ArrayList;

/**
 * Created by Bob on 17/12/14.
 */

public class HanziToPinyinUtils {
	public static String getPinYin(String hanzi) {
		ArrayList<HanziToPinyin.Token> tokens = HanziToPinyin.getInstance()
																												 .get(hanzi);
		StringBuilder sb = new StringBuilder();
		if (tokens != null && tokens.size() > 0) {
			for (HanziToPinyin.Token token : tokens) {
				if (HanziToPinyin.Token.PINYIN == token.type) {
					sb.append(token.target);
				} else {
					sb.append(token.source);
				}
			}
		}

		return sb.toString()
						 .toUpperCase();
	}
}
