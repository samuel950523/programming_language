package com.mycom.mvcdbhw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mvcdbhw.dto.QuizDto;

@Repository
public class DBDaoImpl implements DBDao {

	@Autowired
	DataSource dataSource;

	@Override
	public QuizDto quizDetail(int q_index) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		QuizDto dto = null;

		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT q_index, first_name, last_name, email, joindate ");
			sb.append(" FROM quiz ");
			sb.append(" WHERE q_index = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, q_index);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new QuizDto();
				dto.setQ_index(rs.getInt("q_index"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getString("joindate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public List<QuizDto> quizList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<QuizDto> list = new ArrayList<QuizDto>();

		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT q_index, first_name, last_name, email, joindate ");
			sb.append(" FROM quiz ");

			pstmt = con.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				QuizDto dto = new QuizDto();
				dto.setQ_index(rs.getInt("q_index"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getString("joindate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int quizInsert(QuizDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int ret = -1;
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO quiz (q_index, first_name, last_name, email, joindate) ");
			sb.append(" VALUES (?, ?, ?, ?, ?) ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getQ_index());
			pstmt.setString(2, dto.getFirst_name());
			pstmt.setString(3, dto.getLast_name());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getJoindate());

			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	@Override
	public int quizUpdate(QuizDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int ret = -1;
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE quiz SET ");
			sb.append(" first_name = ?, ");
			sb.append(" last_name = ?, ");
			sb.append(" email = ?, ");
			sb.append(" joindate = ? ");
			sb.append(" WHERE q_index = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getFirst_name());
			pstmt.setString(2, dto.getLast_name());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getJoindate());

			pstmt.setInt(5, dto.getQ_index());
			
			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	@Override
	public int quizDelete(int q_index) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int ret = -1;
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM quiz WHERE q_index = ?  ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, q_index);

			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

}
