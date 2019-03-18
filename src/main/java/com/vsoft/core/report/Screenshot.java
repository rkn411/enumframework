package com.vsoft.core.report;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;

public class Screenshot {

	private String screenshotFilePath;
	private File screenshotFile;

	public Screenshot(String screenshotFilePath, File screenshotFile) {
		this.screenshotFilePath = screenshotFilePath;
		this.screenshotFile = screenshotFile;
	}

	public String getScreenshotFilePath() {
		return screenshotFilePath;
	}

	public void setScreenshotFilePath(String screenshotFilePath) {
		this.screenshotFilePath = screenshotFilePath;
	}

	public File getScreenshotFile() {
		return screenshotFile;
	}

	public void setScreenshotFile(File screenshotFile) {
		this.screenshotFile = screenshotFile;
	}

	public String getBase64Format() {
		try {
			FileInputStream fis = new FileInputStream(screenshotFile);
			byte byteArray[] = new byte[(int) screenshotFile.length()];
			fis.read(byteArray);
			String imageString = Base64.encodeBase64String(byteArray);
			return imageString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
