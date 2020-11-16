package com.ssafy.happyhouse.service;


import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.BoardParamDto;
import com.ssafy.happyhouse.dto.BoardResultDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BoardService {

	BoardResultDto boardList(BoardParamDto boardParamDto);

	BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);

	BoardResultDto boardInsert(BoardDto boardDto, MultipartFile file) throws IOException;

	BoardResultDto getBoard(int boardId);

	BoardResultDto boardDelete(int boardId) throws IOException;


	BoardResultDto boardUpdate(BoardDto boardDto, MultipartFile file) throws IOException;
}
