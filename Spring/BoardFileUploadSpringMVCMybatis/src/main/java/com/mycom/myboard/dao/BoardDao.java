package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	public int boardInsert(BoardDto dto);

	public int boardFileInsert(BoardFileDto dto);

	public List<BoardDto> boardList(BoardParamDto boardParamDto);

	public int boardListTotalCount();

	public List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);

	public int boardListSearchWordTotalCount(BoardParamDto boardParamDto);

}
