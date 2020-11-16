package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.BoardParamDto;
import com.ssafy.happyhouse.dto.BoardResultDto;
import com.ssafy.happyhouse.service.BoardService;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class BoardController {

    final BoardService service;

    public BoardController(final BoardService boardService) {
        service = boardService;
    }

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @GetMapping("/boards")
    private ResponseEntity<BoardResultDto> boardList(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto;
        if (boardParamDto.getSearchWord().isEmpty()) {
            boardResultDto = service.boardList(boardParamDto);
        } else {
            boardResultDto = service.boardListSearchWord(boardParamDto);
        }
        if (boardResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<>(boardResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/boards/{boardId}")
    private ResponseEntity<BoardResultDto> getBoard(@PathVariable int boardId) {
        BoardResultDto boardResultDto = service.getBoard(boardId);
        if (boardResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<>(boardResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/boards")
    private ResponseEntity<BoardResultDto> boardInsert(BoardDto boardDto, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        BoardResultDto boardResultDto = service.boardInsert(boardDto, file);

        if (boardResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<>(boardResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/boards/{boardId}")
    private ResponseEntity<BoardResultDto> boardDelete(@PathVariable int boardId) throws IOException {

        BoardResultDto boardResultDto = service.boardDelete(boardId);
        if (boardResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<>(boardResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/boards/{boardId}")
    private ResponseEntity<BoardResultDto> boardUpdate(BoardDto boardDto, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        BoardResultDto boardResultDto = service.boardUpdate(boardDto, file);
        if (boardResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<>(boardResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
