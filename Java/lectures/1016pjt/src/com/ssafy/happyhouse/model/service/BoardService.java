package com.ssafy.happyhouse.model.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardFileDto;

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

	// New for FileUpload
	public int boardFileInsert(BoardFileDto dto);

	public List<BoardFileDto> boardDetailFileList(int boardId);

	public int boardFileDelete(int boardId);

	public List<String> boardFileUrlDeleteList(int boardId);

	// New for ReadCnt
	public int boardUserReadCount(int boardId, int userSeq);

	public int boardUserReadInsert(int boardId, int userSeq);

	public int boardReadCountUpdate(int boardId);

}