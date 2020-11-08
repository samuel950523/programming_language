package com.mycom.myboard.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

public interface BoardService {
	public BoardResultDto boardInsert(BoardDto boardDto, MultipartFile file) throws IOException;

	public BoardResultDto boardList(BoardParamDto boardParamDto);

	public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);
}
