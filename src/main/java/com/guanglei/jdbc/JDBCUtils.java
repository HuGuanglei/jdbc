package com.guanglei.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCUtils {
	static final Logger logger = LoggerFactory.getLogger(JDBCUtils.class);

	/**
	 * get connection
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		String driverName = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3306/tim_checkout";
		String user = "root";
		String password = "905293";
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
			logger.info("success");
		} catch (Exception e) {
			logger.error("Fail to connect", e);
		}
		return con;
	}

	/**
	 * close connection
	 */
	public static void free(ResultSet rs, Statement sta, Connection con) {
		try {
			if (null != rs) {
				rs.close();
				rs = null;
			}

			if (null != sta) {
				sta.close();
				sta = null;
			}

			if (null != con) {
				con.close();
				con = null;
			}

		} catch (Exception e) {
			logger.error("Fail to disconnect", e);
		}
	}

}
