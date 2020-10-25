package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.util.DBUtil;


public class LoginDaoImpl implements LoginDao {

	@Override
	public UserDto login(String userName) {
		UserDto userDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "SELECT USER_SEQ, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_REGISTER_DATE "
					+ " FROM USER WHERE USER_NAME = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userDto = new UserDto();
				userDto.setUserSeq(rs.getInt("USER_SEQ"));
				userDto.setUserName(rs.getNString("USER_NAME"));
				userDto.setUserPassword(rs.getString("USER_PASSWORD"));
				userDto.setUserEmail(rs.getString("USER_EMAIL"));
				userDto.setUserRegisterDate(rs.getDate("USER_REGISTER_DATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return userDto;
	}

}
