package com.vsoft.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vsoft.automation.config.ConfigProperties;

public class ExcelReaderUtil {
	/**
	 * use this method to get all TCs data from the excel global sheet ,by TC name
	 * as key and value contains another map contains again TC name and
	 * corresponding TC data.
	 * 
	 * @throws Exception
	 *
	 */
	public Map<String, Map<String, String>> getAllTestCasesData() {

		String flPath = ConfigProperties.TEST_DATA_FILE_LOCATION;
		Workbook wb = null;
		Map<String, Map<String, String>> allTcDataMap = null;
		try {
			if (flPath.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(new FileInputStream(flPath));
			} else if (flPath.endsWith(".xls")) {
				wb = new HSSFWorkbook(new FileInputStream(flPath));
			}

			Sheet sht = wb.getSheet(ConfigProperties.TEST_DATA_FILE_NAME);

			int rc = sht.getLastRowNum();
			int cc = sht.getRow(0).getLastCellNum();

			allTcDataMap = new HashMap<>();

			for (int r = 1; r <= rc; r++) {
				HashMap<String, String> tcMap = new HashMap<>();
				for (int c = 0; c < cc; c++) {
					String kName = sht.getRow(0).getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
					String kVal = sht.getRow(r).getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
					tcMap.put(kName, kVal);
				}

				String tcName = sht.getRow(r).getCell(0).toString();
				allTcDataMap.put(tcName, tcMap);
			}

			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return allTcDataMap;
	}

	/**
	 * use this method to get all TCs data from the excel by passing sheet name as
	 * parameter and TC name as key and value contains another map contains again TC
	 * name and corresponding TC data.
	 * 
	 * @param shtName
	 * @throws Exception
	 *
	 */

	public Map<String, Map<String, String>> getAllTestCaseData(String shtName) {

		String flPath = ConfigProperties.TEST_DATA_FILE_LOCATION;
		Workbook wb = null;
		Map<String, Map<String, String>> allTcDataMap = null;
		try {
			if (flPath.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(new FileInputStream(flPath));
			} else if (flPath.endsWith(".xls")) {
				wb = new HSSFWorkbook(new FileInputStream(flPath));
			}

			Sheet sht = wb.getSheet(shtName);

			int rc = sht.getLastRowNum();
			int cc = sht.getRow(0).getLastCellNum();

			allTcDataMap = new HashMap<>();

			for (int r = 1; r <= rc; r++) {
				HashMap<String, String> rMap = new HashMap<>();
				for (int c = 0; c < cc; c++) {
					String kName = sht.getRow(0).getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
					String kVal = sht.getRow(r).getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
					rMap.put(kName, kVal);
				}
				String tcName = sht.getRow(r).getCell(0).toString();
				allTcDataMap.put(tcName, rMap);
			}

			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return allTcDataMap;
	}

	/**
	 * use this method to get all TCs data from the excel global sheet by passing TC
	 * name as parameter and TC name as key and value contains corresponding TC
	 * data.
	 * 
	 * @param shtName
	 * @throws Exception
	 *
	 */
	public HashMap<String, String> getTCData(String tcName) {

		String flPath = ConfigProperties.TEST_DATA_FILE_LOCATION;
		Workbook wb = null;
		HashMap<String, String> tcMap = null;
		try {
			if (flPath.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(new FileInputStream(flPath));
			} else if (flPath.endsWith(".xls")) {
				wb = new HSSFWorkbook(new FileInputStream(flPath));
			}

			Sheet sht = wb.getSheet(ConfigProperties.TEST_DATA_FILE_NAME);

			int rc = sht.getLastRowNum();
			int cc = sht.getRow(0).getLastCellNum();

			tcMap = new HashMap<>();
			for (int r = 1; r <= rc; r++) {

				if (sht.getRow(r).getCell(0).toString().equalsIgnoreCase(tcName)) {
					for (int c = 0; c < cc; c++) {
						String kName = sht.getRow(0).getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
						String kVal = sht.getRow(r).getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
						tcMap.put(kName, kVal);
					}
					break;
				}
			}

			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tcMap;
	}

}
