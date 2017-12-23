/*
 * Create by BobEve on 17-12-20 上午10:43
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 上午10:43
 */

package bob.eve.walle.util;

import android.support.annotation.Nullable;
import bob.eve.comm.lib.util.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Bob on 17/12/20.
 */

public class DateUtils {

	public static String getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(new Date());
	}

	public static String getTomorrowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return String.valueOf(Integer.valueOf(df.format(new Date())) + 1);
	}

	public static String getCurrentDateString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		return df.format(new Date());
	}

	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH);
	}

	public static int getCurrentDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DATE);
	}

	/**
	 * 切割标准时间
	 */
	@Nullable
	public static String subStandardTime(String time) throws ParseException {
		SimpleDateFormat formatUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
		//注意是空格+UTC
		Date date = formatUTC.parse(time.replace("Z", " UTC"));
		SimpleDateFormat formatGST = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return formatGST.format(date);
	}

	/**
	 * 2015-12-7T16:00:00.000Z
	 *
	 * @throws ParseException
	 */
	public String changeTimeToUTC(String time) throws ParseException {
		if (StringUtils.isEmpty(time)) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// GMT相比时区偏移
		int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
		// 夏令时偏移值
		int dstOffset = calendar.get(Calendar.DST_OFFSET);
		calendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		long timeInMillis = calendar.getTimeInMillis();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		return df.format(timeInMillis);
	}

	/**
	 * 将时间戳转化为字符串
	 */
	public static String formatTime2String(long showTime) {
		return formatTime2String(showTime, false);
	}

	public static String formatTime2String(long showTime, boolean haveYear) {
		String str = "";
		long distance = currentTimeMillis() / 1000 - showTime;
		if (distance < 300) {
			str = "刚刚";
		} else if (distance >= 300 && distance < 600) {
			str = "5分钟前";
		} else if (distance >= 600 && distance < 1200) {
			str = "10分钟前";
		} else if (distance >= 1200 && distance < 1800) {
			str = "20分钟前";
		} else if (distance >= 1800 && distance < 2700) {
			str = "半小时前";
		} else if (distance >= 2700) {
			Date date = new Date(showTime * 1000);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			str = formatDateTime(sdf.format(date), haveYear);
		}
		return str;
	}

	public static String formatDate2String(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (time == null) {
			return "未知";
		}
		try {
			long createTime = format.parse(time)
															.getTime() / 1000;
			long currentTime = System.currentTimeMillis() / 1000;
			if (currentTime - createTime - 24 * 3600 > 0) { //超出一天
				return (currentTime - createTime) / (24 * 3600) + "天前";
			} else {
				return (currentTime - createTime) / 3600 + "小时前";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "未知";
	}

	public static String formatDateTime(String time, boolean haveYear) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (time == null) {
			return "";
		}
		Date date;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}

		Calendar current = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		Calendar yesterday = Calendar.getInstance();
		yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
		yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
		yesterday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) - 1);
		yesterday.set(Calendar.HOUR_OF_DAY, 0);
		yesterday.set(Calendar.MINUTE, 0);
		yesterday.set(Calendar.SECOND, 0);

		current.setTime(date);
		if (current.after(today)) {
			return "今天 " + time.split(" ")[1];
		} else if (current.before(today) && current.after(yesterday)) {
			return "昨天 " + time.split(" ")[1];
		} else {
			if (haveYear) {
				int index = time.indexOf(" ");
				return time.substring(0, index);
			} else {
				int yearIndex = time.indexOf("-") + 1;
				int index = time.indexOf(" ");
				return time.substring(yearIndex, time.length())
									 .substring(0, index);
			}
		}
	}
}
