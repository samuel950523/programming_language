package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String ID = "ssafy";
	static final String PASSWORD = "ssafy";

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Context context = (Context) new InitialContext().lookup("java:comp/env/");
			DataSource datasource = (DataSource) context.lookup("jdbc/happyhouse");
			con = datasource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	public static void close(AutoCloseable obj) {
		try {
			if (obj != null)
				obj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
