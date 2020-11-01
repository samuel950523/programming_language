package com.ssafy.term4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.util.DBUtil;

import model.MemberDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public MemberDto login(Map<String, String> map) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select id, pw ");
			sql.append(" from userinfo ");
			sql.append(" where id = ? and pw = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpwd"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setPw(rs.getString("pw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return memberDto;
	}

}
