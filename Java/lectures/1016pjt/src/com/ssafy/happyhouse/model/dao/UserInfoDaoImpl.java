package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.happyhouse.model.UserInfoDto;
import com.ssafy.util.DBUtil;

public class UserInfoDaoImpl implements UserInfoDao {
	StringBuilder sb = new StringBuilder();

	@Override
	public int UserInfoUpdate(UserInfoDto UserInfoDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;
		try {
			con = DBUtil.getConnection();
			sb.setLength(0);
			sb.append("UPDATE USER SET USER_PASSWORD=?, USER_EMAIL=? ");
			sb.append(" WHERE USER_NAME=? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, UserInfoDto.getUserPassword());
			pstmt.setString(2, UserInfoDto.getUserEmail());
			pstmt.setString(3, UserInfoDto.getUserName());

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

	@Override
	public int UserInfoDelete(String userName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("DELETE FROM USER WHERE USER_NAME=? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userName);

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

	@Override
	public UserInfoDto UserInfoDetail(String userName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserInfoDto UserInfoDto = null;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("SELECT USER_SEQ, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_REGISTER_DATE ");
			sb.append("   FROM USER ");
			sb.append(" WHERE USER_NAME = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				UserInfoDto = new UserInfoDto();
				UserInfoDto.setUserSeq(rs.getInt("USER_SEQ"));
				UserInfoDto.setUserName(rs.getString("USER_NAME"));
				UserInfoDto.setUserPassword(rs.getString("USER_PASSWORD"));
				UserInfoDto.setUserEmail(rs.getString("USER_EMAIL"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return UserInfoDto;
	}
}
