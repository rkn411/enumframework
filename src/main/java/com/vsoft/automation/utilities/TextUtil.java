package com.vsoft.automation.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextUtil {

	/**
	 * To get current date with time stamp
	 *
	 * @return CurrentDateTimeStamp
	 */
	public static String getCurrentDateTimeStamp() {
		return (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
	}

	/**
	 * To get current time stamp
	 *
	 * @return CurrentTimeStamp
	 */
	public static String getCurrentTimeStamp() {
		return (new SimpleDateFormat("HHmmss").format(new Date()));
	}

	/**
	 * to add Auto prefix to the current date Time stamp and given name
	 *
	 * @param name
	 * @return AutoPrefixWithCurrentDateTimeStamp
	 */
	public static String getAutoPrefixWithDateTimeStamp(String name) {
		return "Auto" + TextUtil.getCurrentDateTimeStamp() + "_" + name;
	}

	/**
	 * to add Auto prefix to the given date Time stamp and name
	 *
	 * @param name
	 * @param dateTimeStamp
	 * @return AutoPrefixWithGivenDateTimeStamp
	 */
	public static String getAutoPrefixWithDateTimeStamp(String name, String dateTimeStamp) {
		return "Auto" + dateTimeStamp + "_" + name;
	}

	/**
	 * to add Auto prefix to the given name
	 *
	 * @param name
	 * @return AutoPrefixWithGivenName
	 */
	public static String getAutoPrefix(String name) {
		return "Auto" + "_" + name;
	}

	/**
	 * To trim the string with the given limit
	 *
	 * @param string
	 * @param limit
	 * @return string
	 */
	public static String trimStringLength(String string, int limit) {
		if (string.length() > limit) {
			string = string.substring(0, limit - 1);
		}
		return string;
	}
}
