package board.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import board.dto.BoardDto;
import javax.servlet.http.Part;

public interface BoardService {
	// Changes for FileUpload
	public int boardInsert(BoardDto dto, Collection<Part> parts) throws IOException;
	public int boardUpdate(BoardDto dto, Collection<Part> parts) throws IOException;
	
	public int boardDelete(int boardId);
	
	public BoardDto boardDetail(int boardId, int userSeq);
	
	public List<BoardDto> boardList(int limit, int offset);
	public int boardListTotalCnt();
	
	public List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord);
	public int boardListSearchWordTotalCnt(String searchWord);
}