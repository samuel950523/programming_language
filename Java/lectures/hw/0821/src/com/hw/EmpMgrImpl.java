package com.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpMgrImpl implements EmpMgr {

	// Singleton Pattern
	private static EmpMgrImpl instance = new EmpMgrImpl();

	public static EmpMgrImpl getInstance() {
		return instance;
	}

	final String URL = "jdbc:mysql://127.0.0.1:3306/employee_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	final String USER = "ssafy";
	final String PW = "ssafy";

	@Override
	public void add(Employee b) { // 직원정보를 DB에 저장
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sql = "insert into employee values (?,?,?,?)";

			try (Connection conn = DriverManager.getConnection(URL, USER, PW);
					PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, b.getEmpNo());
				stmt.setString(2, b.getName());
				stmt.setString(3, b.getPosition());
				stmt.setString(4, b.getDept());
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> search() { // 저장된 모든 직원 정보 반환
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ArrayList<Employee> eList = new ArrayList<>();
			String sql = "select * from employee";
			try (Connection conn = DriverManager.getConnection(URL, USER, PW);
					PreparedStatement stmt = conn.prepareStatement(sql);) {
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						eList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
					}
					return eList;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Employee search(int empNo) { // 파라미터로 전달된 사번과 같은 직원 정보를 찾아서 리턴. empNo가 존재하지 않을 경우 null을 리턴

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sql = "select * from employee where emp_no=?";
			try (Connection conn = DriverManager.getConnection(URL, USER, PW);
					PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.setInt(1, empNo);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> search(String name) { // 파라미터로 전달된 글자를 이름에 포함한 모든 직원 정보를 찾아서 리턴
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ArrayList<Employee> eList = new ArrayList<>();

			String sql = "select * from employee where emp_name like ?";
			try (Connection conn = DriverManager.getConnection(URL, USER, PW);
					PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.setString(1, "%" + name + "%");
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						eList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
					}
					return eList;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(int empNo, String dept) { // 파라미터로 전달된 사번을 직원으로 찾아 부서를 수정한다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sql = "update employee set emp_dept=? where emp_no=?";
			try (Connection conn = DriverManager.getConnection(URL, USER, PW);
					PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, dept);
				stmt.setInt(2, empNo);

				return stmt.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int empNo) { // 파라미터의 사번과 같은 직원을 찾아 삭제한다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sql = "delete from employee where emp_no=?";
			try (Connection conn = DriverManager.getConnection(URL, USER, PW);
					PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, empNo);

				return stmt.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
