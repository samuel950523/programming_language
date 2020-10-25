package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.util.DBUtil;


public class UserDaoImpl implements UserDao {

	@Override
	public int userRegister(UserDto userDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();
			String sql = "INSERT INTO USER "
					+ "(USER_NAME, USER_PASSWORD, USER_EMAIL, USER_REGISTER_DATE)"
					+ " VALUES (?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userDto.getUserName());
			pstmt.setString(2, userDto.getUserPassword());
			pstmt.setString(3, userDto.getUserEmail());

			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return ret;
	}
}
