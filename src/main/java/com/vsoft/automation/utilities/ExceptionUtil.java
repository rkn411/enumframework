package com.vsoft.automation.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	/**
	 * To get the exception stack trace
	 *
	 * @param exception
	 * @return String
	 */
	public static String getExceptionStackTrace(Exception exception) {
		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

}
