package com.lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCMySQLTest2 {

	public static void main(String[] args) throws Exception {
		// 1. Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. Connection
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "ssafy");
		// 3. PreparedStatement Create
		PreparedStatement ps = con
				.prepareStatement(" insert into patient(name, age, gender, phone)" + " values (?, ?, ?, ?)");
		ps.setString(1, "유환자");
		ps.setInt(2, 40);
		ps.setString(3, "F");
		ps.setString(4, "01099999999");
		ps.executeUpdate();
		ps.close();
		con.close();
	}
}