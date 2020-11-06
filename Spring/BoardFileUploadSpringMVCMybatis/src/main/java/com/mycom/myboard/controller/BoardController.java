package com.mycom.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;
import com.mycom.myboard.service.BoardService;

@RestController
public class BoardController {

	@Autowired
	BoardService service;

	private static final int SUCCESS = 1;
	private static final int FAIL = -1;

	@GetMapping(value = "/boards")
	private ResponseEntity<BoardResultDto> boardList(BoardParamDto boardParamDto) {

		BoardResultDto boardResultDto;
		if (boardParamDto.getSearchWord().isEmpty()) {
			boardResultDto = service.boardList(boardParamDto);
		} else {
			boardResultDto = service.boardListSearchWord(boardParamDto);
		}

		if (boardResultDto.getResult() == SUCCESS) {
			System.out.println(boardResultDto.getDto());

			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/boards")
	private ResponseEntity<BoardResultDto> boardInsert(BoardDto boardDto,
			@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
		BoardResultDto boardResultDto = service.boardInsert(boardDto, file);

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// PUT + multipart/form-data (X)
	// In RESTful,
	// PUT & DELETE methods are defined to be idempotent
	// 만약 글만 수정한다면?? PUT mapping OK  여러 번 수정해도 back-end 결과가 같음
	// 첨부파일이 포함되면 idempotent 하지 않음.

	@PostMapping(value="/boards/{boardId}") 
	private ResponseEntity<BoardResultDto> boardUpdate(
	        BoardDto boardDto, 
	        @RequestParam(value="file", required = false) MultipartFile file){

	    BoardResultDto boardResultDto = service.boardUpdate(boardDto, file);
	    
	    if( boardResultDto.getResult() == SUCCESS ) {
	        return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
	    }else {
	        return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
	    }        
	}
	
}