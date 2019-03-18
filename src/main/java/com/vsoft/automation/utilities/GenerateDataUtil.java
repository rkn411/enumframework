package com.vsoft.automation.utilities;

import static com.vsoft.core.extreport.ExtentTestManager.failStep;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.github.javafaker.Faker;
import com.vsoft.core.report.ActionResult;

public class GenerateDataUtil {

	private static final Logger logger = Logger.getLogger(GenerateDataUtil.class);
	private static Faker faker = null;

	/**
	 * use this method to get the faker instance.
	 *
	 */
	private static Faker getInstance() {
		if (faker == null) {
			faker = new Faker();
		}
		return faker;
	}

	/**
	 * use this method to get random First name.
	 *
	 */
	public static String getFirstName() {
		logger.info("First name random data from faker is " + getInstance().name().firstName());
		return getInstance().name().firstName();

	}

	/**
	 * use this method to get random Last name.
	 *
	 */
	public static String getLastName() {
		logger.info("Last name random data from faker is " + getInstance().name().lastName());
		return getInstance().name().lastName();
	}

	/**
	 * use this method to get random full name.
	 *
	 */
	public static String getFullName() {
		logger.info("Full name random data from faker is " + getInstance().name().fullName());
		return getInstance().name().fullName();
	}
	
	/**
	 * use this method to get random street Address.
	 *
	 */
	public static String getStreetAddress() {
		logger.info("Street address random data from faker is " + getInstance().address().streetAddress());
		return getInstance().address().streetAddress();
	}
	

	/**
	 * use this method to get random city name.
	 *
	 */
	public static String getCityName() {
		logger.info("City name random data from faker is " + getInstance().address().cityName());
		return getInstance().address().cityName();
	}

	/**
	 * use this method to get random zipcode.
	 *
	 */
	public static String getZipCode() {
		logger.info("Zip code random data from faker is " + getInstance().address().zipCode());
		return getInstance().address().zipCode();
	}

	/**
	 * use this method to get random country.
	 *
	 */
	public static String getCountry() {
		logger.info("Country random data from faker is " + getInstance().address().country());
		return getInstance().address().country();
	}

	/**
	 * use this method to get random phone number.
	 *
	 */
	public static String getPhoneNumber() {
		logger.info("Phone Number random data from faker is " + getInstance().number().digits(10));
		return getInstance().number().digits(10);
	}
	
	/**
	 * use this method to get random Random  number with fixed lenght int as output format type as "xx.xx".
	 *
	 */
	public static int getRandomDecimalNumber() {
		logger.info("Decimal Number random data from faker is " + getInstance().number().digits(2)+"."+getInstance().number().digits(2));
		 return Integer.parseInt((getInstance().number().digits(2)+"."+getInstance().number().digits(2)));
	}
	
	/**
	 * use this method to get random number by passing required lenght of the number.
	 *
	 */
	public static int getRandomNumber(int digitLength) {
		logger.info("Phone Number random data from faker is " + getInstance().number().digits(digitLength));
		return Integer.parseInt((getInstance().number().digits(digitLength)));
	}
	

	/**
	 * use this method to get random date by passing from and to date range
	 * parameter in string format "MM/dd/yyyy".
	 *
	 * @param fromDate
	 * @param toDate
	 * @throws Exception
	 *
	 */
	public static String getDateBetweenRange(String fromDate, String toDate) {
		ActionResult actionResult = null;
		Date start = null;
		Date end = null;
		Date randomdate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {
			start = formatter.parse(fromDate);
			end = formatter.parse(toDate);
		} catch (Exception e) {
			actionResult = new ActionResult(false);
			actionResult.setDescription("Failed to get the random date, Error in passing wrong date format");
			failStep(actionResult);
		}
		randomdate = getInstance().date().between(start, end);
		logger.info("Random Date from faker is " + formatter.format(randomdate));
		return formatter.format(randomdate);
	}

}
