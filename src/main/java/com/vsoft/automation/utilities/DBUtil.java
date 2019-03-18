package com.vsoft.automation.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	/**
	 * use this method to get the data from database by passing necessary
	 * parameters.
	 * 
	 * @param dbServerUrl
	 * @param dbName
	 * @param dbUserName
	 * @param dbPassword
	 * @param query
	 * @throws Exception
	 *
	 */
	public ResultSet readDataFromDB(String dbServerUrl, String dbName, String dbUserName, String dbPassword,
			String query) {

		String sqldb_url = "jdbc:mysql://localhost:3307/company";
		// Use your database username here. It Is "root" for root account.
		String sqldb_uname = dbUserName;
		String sqldb_pass = dbPassword;
		ResultSet rs = null;
		try {
			// To Create database connection.
			Connection db = DriverManager.getConnection(sqldb_url, sqldb_uname, sqldb_pass);
			Statement st = db.createStatement();
			rs = st.executeQuery(query);

			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * use this method to write the data into database by passing necessary
	 * parameters.
	 * 
	 * @param dbServerUrl
	 * @param dbName
	 * @param dbUserName
	 * @param dbPassword
	 * @param query
	 * @throws Exception
	 *
	 */

	public boolean writeDataToDB(String dbServerUrl, String dbName, String dbUserName, String dbPassword,
			String query) {

		boolean status = false;
		try {
			String sqldb_url = "jdbc:mysql://localhost:3307/company";
			// Use your database username here. It Is "root" for root account.
			String sqldb_uname = dbUserName;
			String sqldb_pass = dbPassword;
			Connection db = DriverManager.getConnection(sqldb_url, sqldb_uname, sqldb_pass);
			Statement st = db.createStatement();

			status = st.execute("INSERT INTO emp (id, name, age, sal) VALUES (26, 'aaa', 25,3435435);");

			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

}
