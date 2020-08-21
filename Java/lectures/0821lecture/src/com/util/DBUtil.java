package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/product_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String USER = "ssafy";
	private static final String PW = "ssafy";

	// static initializer : 클래스가 메모리에 로드 될 때 자동으로 실행되는 블럭
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// instance initializer : 객체 생성될 때 자동 실행 블럭
	{

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PW);
	}
}
