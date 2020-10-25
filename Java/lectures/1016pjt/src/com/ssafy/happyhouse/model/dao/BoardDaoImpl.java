package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardFileDto;
import com.ssafy.util.DBUtil;

//
public class BoardDaoImpl implements BoardDao {

	StringBuilder sb = new StringBuilder();

	@Override
	public int boardInsert(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			conn = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("INSERT INTO BOARD ( USER_SEQ, TITLE, CONTENT, REG_DT, READ_COUNT ) ");
			sb.append(" VALUES ( ?, ?, ?, now(), 0 ) ");

			pstmt = conn.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, boardDto.getUserSeq());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getContent());

			pstmt.executeUpdate();

			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			ret = tableKeys.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return ret;
	}

	@Override
	public int boardFileInsert(BoardFileDto boardFileDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("INSERT INTO BOARD_FILE ( BOARD_ID, FILE_NAME, FILE_SIZE, FILE_CONTENT_TYPE, FILE_URL ) ");
			sb.append(" VALUES ( ?, ?, ?, ?, ? ) ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardFileDto.getBoardId());
			pstmt.setString(2, boardFileDto.getFileName());
			pstmt.setLong(3, boardFileDto.getFileSize());
			pstmt.setString(4, boardFileDto.getFileContentType());
			pstmt.setString(5, boardFileDto.getFileUrl());

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
	public int boardUpdate(BoardDto boardDto) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("UPDATE BOARD SET TITLE = ?, CONTENT = ? ");
			sb.append(" WHERE BOARD_ID = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getBoardId());

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
	public int boardDelete(int boardId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("DELETE FROM BOARD ");
			sb.append(" WHERE BOARD_ID = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);

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
	public int boardFileDelete(int boardId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("DELETE FROM BOARD_FILE ");
			sb.append(" WHERE BOARD_ID = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);

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
	public List<String> boardFileUrlDeleteList(int boardId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<String> list = new ArrayList<String>();

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("SELECT FILE_URL ");
			sb.append("	 FROM BOARD_FILE ");
			sb.append("	WHERE BOARD_ID = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("FILE_URL"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return list;
	}

	@Override
	public List<BoardDto> boardList(int limit, int offset) {

		List<BoardDto> list = new ArrayList<BoardDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append(
					"SELECT b.BOARD_ID, b.USER_SEQ, u.USER_NAME, b.TITLE, b.CONTENT, b.REG_DT, b.READ_COUNT ");
			sb.append("  FROM BOARD b, USER u");
			sb.append(" WHERE b.USER_SEQ = u.USER_SEQ");
			sb.append(" ORDER BY b.BOARD_ID DESC");
			sb.append(" LIMIT ? OFFSET ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardId(rs.getInt("BOARD_ID"));
				boardDto.setUserSeq(rs.getInt("USER_SEQ"));
				boardDto.setUserName(rs.getString("USER_NAME"));
				boardDto.setTitle(rs.getString("TITLE"));
				boardDto.setContent(rs.getString("CONTENT"));
				boardDto.setReadCount(rs.getInt("READ_COUNT"));
				// boardDto.setRegDt(rs.getDate("REG_DT"));
				// boardDto.setRegDt(rs.getDate("REG_DT").toLocalDate ());
				boardDto.setRegDt(rs.getTimestamp("REG_DT").toLocalDateTime());
				list.add(boardDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return list;
	}

	@Override
	public int boardListTotalCnt() {
		int totalCnt = -1;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM BOARD");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return totalCnt;
	}

	@Override
	public List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord) {
		List<BoardDto> list = new ArrayList<BoardDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append(
					"SELECT b.BOARD_ID, b.USER_SEQ, u.USER_NAME, b.TITLE, b.CONTENT, b.REG_DT, b.READ_COUNT ");
			sb.append("  FROM BOARD b, USER u");
			sb.append(" WHERE b.USER_SEQ = u.USER_SEQ");
			sb.append("   AND b.TITLE like ? ");
			sb.append(" ORDER BY b.BOARD_ID DESC");
			sb.append(" LIMIT ? OFFSET ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, "%" + searchWord + "%");
			pstmt.setInt(2, limit);
			pstmt.setInt(3, offset);

			System.out.println("pstmt" + pstmt);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardId(rs.getInt("BOARD_ID"));
				boardDto.setUserSeq(rs.getInt("USER_SEQ"));
				boardDto.setUserName(rs.getString("USER_NAME"));
				boardDto.setTitle(rs.getString("TITLE"));
				boardDto.setContent(rs.getString("CONTENT"));
				boardDto.setReadCount(rs.getInt("READ_COUNT"));
				// boardDto.setRegDt(rs.getDate("REG_DT"));
				// boardDto.setRegDt(rs.getDate("REG_DT").toLocalDate ());
				boardDto.setRegDt(rs.getTimestamp("REG_DT").toLocalDateTime());
				list.add(boardDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return list;
	}

	@Override
	public int boardListSearchWordTotalCnt(String searchWord) {
		int totalCnt = -1;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM BOARD WHERE TITLE LIKE ? ");
			pstmt.setString(1, "%" + searchWord + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return totalCnt;
	}

	@Override
	public BoardDto boardDetail(int boardId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BoardDto boardDto = null;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("SELECT b.BOARD_ID, b.USER_SEQ, u.USER_NAME, ");
			sb.append("       b.TITLE, b.CONTENT, b.REG_DT, b.READ_COUNT ");
			sb.append("  FROM BOARD b, USER u ");
			sb.append(" WHERE b.BOARD_ID = ? ");
			sb.append("   AND b.USER_SEQ = u.USER_SEQ ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setBoardId(rs.getInt("BOARD_ID"));
				boardDto.setUserSeq(rs.getInt("USER_SEQ"));
				boardDto.setUserName(rs.getString("USER_NAME"));
				boardDto.setTitle(rs.getString("TITLE"));
				boardDto.setContent(rs.getString("CONTENT"));
				// boardDto.setRegDt(rs.getDate("REG_DT"));
				// boardDto.setRegDt(rs.getDate("REG_DT").toLocalDate ());
				boardDto.setRegDt(rs.getTimestamp("REG_DT").toLocalDateTime());
				boardDto.setReadCount(rs.getInt("READ_COUNT"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return boardDto;
	}

	// New for ReadCnt

	@Override
	public List<BoardFileDto> boardDetailFileList(int boardId) {

		List<BoardFileDto> list = new ArrayList<BoardFileDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();

			sb.setLength(0);
			sb.append("SELECT BOARD_ID, FILE_ID, FILE_NAME, FILE_SIZE, FILE_CONTENT_TYPE, FILE_URL, REG_DT ");
			sb.append("  FROM BOARD_FILE ");
			sb.append(" WHERE BOARD_ID = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setBoardId(rs.getInt("BOARD_ID"));
				boardFileDto.setFileId(rs.getInt("FILE_ID"));
				boardFileDto.setFileName(rs.getString("FILE_NAME"));
				boardFileDto.setFileSize(rs.getInt("FILE_SIZE"));
				boardFileDto.setFileContentType(rs.getString("FILE_CONTENT_TYPE"));
				boardFileDto.setFileUrl(rs.getString("FILE_URL"));
				// boardDto.setRegDt(rs.getDate("REG_DT"));
				// boardDto.setRegDt(rs.getDate("REG_DT").toLocalDate ());
				boardFileDto.setRegDt(rs.getTimestamp("REG_DT").toLocalDateTime());
				list.add(boardFileDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return list;
	}

	@Override
	public int boardUserReadCount(int boardId, int userSeq) {
		int userReadCnt = -1;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT count(*) FROM board_user_read WHERE board_id = ? and user_seq = ? ");
			pstmt.setInt(1, boardId);
			pstmt.setInt(2, userSeq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userReadCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return userReadCnt;
	}

	@Override
	public int boardUserReadInsert(int boardId, int userSeq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("INSERT INTO board_user_read ( board_id, user_seq ) VALUES ( ?, ? ) ");
			pstmt.setInt(1, boardId);
			pstmt.setInt(2, userSeq);

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
	public int boardReadCountUpdate(int boardId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int ret = -1;

		try {
			con = DBUtil.getConnection();
			System.out.println(boardId);
			pstmt = con.prepareStatement("UPDATE board set READ_COUNT = READ_COUNT + 1 WHERE BOARD_ID = ? ");
			pstmt.setInt(1, boardId);

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