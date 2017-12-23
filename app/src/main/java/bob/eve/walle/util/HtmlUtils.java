/*
 * Create by BobEve on 17-12-18 上午11:10
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午11:10
 */

package bob.eve.walle.util;

import java.util.List;

/**
 * Created by Bob on 17/12/18.
 */

public class HtmlUtils {

	//css样式,隐藏header
	private static final String HIDE_HEADER_STYLE = "<style>div.headline{display:none;}</style>";

	// 格式化 css style tag
	private static final String NEEDED_FORMAT_CSS_TAG =
			"<link rel=\"stylesheet\" type=\"text/css\" href=\"%s\"/>";

	// 格式化 js script tag,
	private static final String NEEDED_FORMAT_JS_TAG = "<script src=\"%s\"></script>";

	public static final String MIME_TYPE = "text/html; charset=utf-8";

	public static final String ENCODING = "utf-8";

	private HtmlUtils() {

	}

	/**
	 * 根据css链接生成Link标签
	 *
	 * @param url
	 * 		String
	 *
	 * @return String
	 */
	public static String createCssTag(String url) {

		return String.format(NEEDED_FORMAT_CSS_TAG, url);
	}

	/**
	 * 根据多个css链接生成Link标签
	 *
	 * @param urls
	 * 		List<String>
	 *
	 * @return String
	 */
	public static String createCssTag(List<String> urls) {

		final StringBuilder sb = new StringBuilder();
		for (String url : urls) {
			sb.append(createCssTag(url));
		}
		return sb.toString();
	}

	/**
	 * 根据js链接生成Script标签
	 *
	 * @param url
	 * 		String
	 *
	 * @return String
	 */
	public static String createJsTag(String url) {

		return String.format(NEEDED_FORMAT_JS_TAG, url);
	}

	/**
	 * 根据多个js链接生成Script标签
	 *
	 * @param urls
	 * 		List<String>
	 *
	 * @return String
	 */
	public static String createJsTag(List<String> urls) {

		final StringBuilder sb = new StringBuilder();
		for (String url : urls) {
			sb.append(createJsTag(url));
		}
		return sb.toString();
	}

	/**
	 * 根据样式标签,html字符串,js标签
	 * 生成完整的HTML文档
	 */

	public static String createHtmlData(String html, List<String> cssList, List<String> jsList) {
		final String css = HtmlUtils.createCssTag(cssList);
		final String js = HtmlUtils.createJsTag(jsList);
		return css.concat(HIDE_HEADER_STYLE)
							.concat(html)
							.concat(js);
	}
}
