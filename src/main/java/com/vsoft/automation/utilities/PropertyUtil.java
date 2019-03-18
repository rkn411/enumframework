package com.vsoft.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * V-Soft Automation - Utilities
 * 
 * @author V-Soft
 * 
 */

public class PropertyUtil {

	static Properties props = new Properties();
	String strFileName;
	String strValue;

	/**
	 * To get property value for the given key
	 * 
	 * @param strKey
	 * @return strValue
	 */
	public String getProperty(String strKey) {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				strValue = props.getProperty(strKey);
				in.close();
			} else
				System.out.println("File not found!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strValue;
	}

	/**
	 * To set the property
	 * 
	 * @param strKey
	 * @param strValue
	 * @throws Throwable
	 */
	public void setProperty(String strKey, String strValue) throws Throwable {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.setProperty(strKey, strValue);
				props.store(new FileOutputStream(strFileName), null);
				in.close();
			} else {
				System.out.println("File not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To remove the property
	 * 
	 * @param strKey
	 */
	public void removeProperty(String strKey) {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.remove(strKey);
				props.store(new FileOutputStream(strFileName), null);
				in.close();
			} else
				System.out.println("File not found!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PropertyUtil(String strFileName) {
		this.strFileName = strFileName;
	}

	/**
	 * To get the Host Name
	 * 
	 * @return hostname
	 * @throws UnknownHostException
	 */
	public static String getHostName() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();
		return hostname;
	}
}