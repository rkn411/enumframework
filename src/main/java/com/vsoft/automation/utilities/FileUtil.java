package com.vsoft.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

public class FileUtil {

	/**
	 * use this method to copy from source to target file path.
	 * 
	 * @param sourceFilePath
	 * @param targetFilePath
	 * @throws Exception
	 *
	 */
	public static void copy(String sourceFilePath, String targetFilePath) {
		Path template = Paths.get(sourceFilePath);
		Path testReportFile = Paths.get(targetFilePath);
		try {
			Files.copy(template, testReportFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * use this method to check file exist or not.
	 * 
	 * @param flPath
	 * @return true or false
	 * @throws Exception
	 *
	 */

	public static boolean isFileExist(String flPath) {
		return new File(flPath).exists();
	}

	/**
	 * use this method to check is file or not.
	 * 
	 * @param flPath
	 * @return true or false
	 * @throws Exception
	 *
	 */
	public static boolean isFile(String flPath) {
		return new File(flPath).isFile();
	}

	/**
	 * use this method to check is directory or not.
	 * 
	 * @param flPath
	 * @return true or false
	 * @throws Exception
	 *
	 */

	public static boolean isFolder(String flPath) {
		return new File(flPath).isDirectory();
	}

	/**
	 * use this method to create a new directory.
	 * 
	 * @param flPath
	 * @return new directory
	 * @throws Exception
	 *
	 */

	public static boolean makeDirectories(String filepath) {
		return new File(filepath).mkdirs();
	}

	/**
	 * use this method to create a new directory for parent.
	 * 
	 * @param filepath
	 * @return new directory
	 * @throws Exception
	 *
	 */

	public static boolean makeParentDirectories(String filepath) {
		return new File(filepath).getParentFile().mkdirs();
	}

	/**
	 * use this method to delete a directory.
	 * 
	 * @param filepath
	 * @throws Exception
	 *
	 */
	public static void deleteDirectory(String filepath) {
		File file = new File(filepath);
		try {
			FileUtils.deleteDirectory(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
