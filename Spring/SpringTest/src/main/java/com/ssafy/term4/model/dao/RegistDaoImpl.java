package com.ssafy.term4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.util.DBUtil;

import model.RegistDto;

@Repository
public class RegistDaoImpl implements RegistDao {

	@Autowired
	private DataSource dataSource;

//	@Override
//	public List<RegistDto> listArticle(Map<String, String> map) throws SQLException {
//		List<RegistDto> list = new ArrayList<RegistDto>();
//
//		int currentPage = Integer.parseInt(map.get("pg"));
//		int sizePerPage = Integer.parseInt(map.get("spp"));
//		String key = map.get("key");
//		String word = map.get("word");
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = dataSource.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select articleno, userid, subject, content, regtime \n");
//			sql.append("from guestbook \n");
//			if (!word.isEmpty()) {// if(word.length() != 0) {
//				if ("subject".equals(key)) {
//					sql.append("where subject like ? \n");
//				} else {
//					sql.append("where " + key + " = ? \n");
//				}
//			}
//			sql.append("order by articleno desc \n");
//			sql.append("limit ?, ?");
//			pstmt = conn.prepareStatement(sql.toString());
//			int idx = 0;
//			if (!word.isEmpty()) {
//				if ("subject".equals(key))
//					pstmt.setString(++idx, "%" + word + "%");
//				else
//					pstmt.setString(++idx, word);
//			}
//			pstmt.setInt(++idx, (currentPage - 1) * sizePerPage);
//			pstmt.setInt(++idx, sizePerPage);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				RegistDto guestBookDto = new RegistDto();
//				guestBookDto.setArticleno(rs.getInt("articleno"));
//				guestBookDto.setUserid(rs.getString("userid"));
//				guestBookDto.setSubject(rs.getString("subject"));
//				guestBookDto.setContent(rs.getString("content"));
//				guestBookDto.setRegtime(rs.getString("regtime"));
//
//				list.add(guestBookDto);
//			}
//		} finally {
//			DBUtil.close(rs);
//			DBUtil.close(pstmt);
//			DBUtil.close(conn);
//		}
//
//		return list;
//	}

//	@Override
//	public RegistDto getArticle(int articleno) throws SQLException {
//		RegistDto guestBookDto = null;
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = dataSource.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select articleno, userid, subject, content, regtime \n");
//			sql.append("from guestbook \n");
//			sql.append("where articleno = ?");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setInt(1, articleno);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				guestBookDto = new RegistDto();
//				guestBookDto.setArticleno(rs.getInt("articleno"));
//				guestBookDto.setUserid(rs.getString("userid"));
//				guestBookDto.setSubject(rs.getString("subject"));
//				guestBookDto.setContent(rs.getString("content"));
//				guestBookDto.setRegtime(rs.getString("regtime"));
//			}
//		} finally {
//			DBUtil.close(rs);
//			DBUtil.close(pstmt);
//			DBUtil.close(conn);
//		}
//		return guestBookDto;
//	}

	@Override
	public void createRegist(RegistDto registDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into country_status (ccode, cname, patient, rcode) \n");
			insertMember.append("values (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, registDto.getCcode());
			pstmt.setString(2, registDto.getCname());
			pstmt.setInt(3, registDto.getPatient());
			pstmt.setString(4, registDto.getRcode());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

	}

	@Override
	public List<RegistDto> listRegist(Map<String, String> map) throws SQLException {
		List<RegistDto> list = new ArrayList<RegistDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select ccode, cname, patient, c.rcode, rname ");
			sql.append(" from country_status c, region r ");
			sql.append(" where c.rcode=r.rcode ");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RegistDto registDto = new RegistDto();
				registDto.setCcode(rs.getString("ccode"));
				registDto.setCname(rs.getString("cname"));
				registDto.setPatient(rs.getInt("patient"));
				registDto.setRcode(rs.getString("rcode"));
				registDto.setRname(rs.getString("rname"));
				list.add(registDto);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		System.out.println(list);
		return list;
	}

	@Override
	public RegistDto getRegist(int ccode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRegist(int ccode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("delete from country_status \n");
			insertMember.append("where ccode = ?");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setInt(1, ccode);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

}
