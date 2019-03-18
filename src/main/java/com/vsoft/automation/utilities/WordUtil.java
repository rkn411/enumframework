package com.vsoft.automation.utilities;

import static com.vsoft.core.extreport.ExtentTestManager.failStep;
import static com.vsoft.core.extreport.ExtentTestManager.passStep;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.vsoft.automation.config.ConfigProperties;
import com.vsoft.core.report.ActionResult;

public class WordUtil {

	private static final Logger logger = Logger.getLogger(WordUtil.class);

	/**
	 * use this method to check particular string present or not inside a word
	 * document.
	 * 
	 * @param wordToVerify
	 * @throws Exception
	 *
	 */
	public Boolean wordStringCheck(String wordToVerify) {
		ActionResult actionResult = null;
		File file = null;
		XWPFWordExtractor extractor = null;
		Boolean wordstatus = false;
		try {
			logger.info("checking the string inside word file");
			if (FileUtil.isFileExist(ConfigProperties.WORDFILEPATH)) {
				file = new File(ConfigProperties.WORDFILEPATH);
				FileInputStream fis = new FileInputStream(file.getAbsolutePath());
				XWPFDocument document = new XWPFDocument(fis);
				extractor = new XWPFWordExtractor(document);
				if (extractor.getText().contains(wordToVerify)) {
					wordstatus = true;
				}
			} else {
				logger.error("Word File Path does not exist");
			}
			actionResult = new ActionResult(wordstatus);
			if (actionResult.getStatus() == true) {
				actionResult.setDescription("Successfully found the " + wordToVerify + " String inside word file.");
				logger.info(actionResult.getDescription());
				passStep(actionResult);
			} else {
				actionResult.setDescription("Fail to find the " + wordToVerify + " String inside word file.");
				logger.error(actionResult.getDescription());
				failStep(actionResult);

			}
		} catch (Exception e) {
			actionResult.setStatus(false);
			actionResult.setDescription("Failed to find the " + wordToVerify + " String inside word file.");
			failStep(actionResult);
			actionResult = new ActionResult(false);
        	actionResult.setDescription("Failed to find the " + wordToVerify + " String inside word file.");
        	failStep(actionResult);
			logger.error("Exception Details: " + e.getMessage());
		}
		return wordstatus;
	}

}
