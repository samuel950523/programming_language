package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.dto.BoardDto;

public class BoardServiceImpl implements BoardService {

	BoardDao dao = new BoardDaoImpl();

	@Override
	public int boardInsert(BoardDto dto) {
		return dao.boardInsert(dto);
	}

	@Override
	public int boardUpdate(BoardDto dto) {
		return dao.boardUpdate(dto);
	}

	@Override
	public int boardDelete(int boardId) {
		return dao.boardDelete(boardId);
	}

	@Override
	public BoardDto boardDetail(int boardId) {
		return dao.boardDetail(boardId);
	}

	@Override
	public List<BoardDto> boardList(int limit, int offset) {
		return dao.boardList(limit, offset);
	}

	@Override
	public int boardListTotalCnt() {
		return dao.boardListTotalCnt();
	}

	@Override
	public List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord) {
		return dao.boardListSearchWord(limit, offset, searchWord);
	}

	@Override
	public int boardListSearchWordTotalCnt(String searchWord) {
		return dao.boardListSearchWordTotalCnt(searchWord);
	}

}
