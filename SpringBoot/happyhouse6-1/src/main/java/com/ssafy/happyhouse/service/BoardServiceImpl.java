package com.ssafy.happyhouse.service;


import com.ssafy.happyhouse.dao.BoardDao;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.BoardFileDto;
import com.ssafy.happyhouse.dto.BoardParamDto;
import com.ssafy.happyhouse.dto.BoardResultDto;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BoardServiceImpl implements BoardService {

    BoardDao dao;

    public BoardServiceImpl(final BoardDao boardDao) {
        this.dao = boardDao;
    }

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    private final String uploadPath = System.getProperty("user.dir");
    private final String uploadFolder = "upload";

    @Override
    public BoardResultDto boardList(BoardParamDto boardParamDto) {

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            List<BoardDto> list = dao.boardList(boardParamDto);
            int count = dao.boardListTotalCount();

            boardResultDto.setList(list);
            boardResultDto.setCount(count);

            boardResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        return boardResultDto;
    }

    @Override
    public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            List<BoardDto> list = dao.boardListSearchWord(boardParamDto);
            int count = dao.boardListSearchWordTotalCount(boardParamDto.getSearchWord());

            boardResultDto.setList(list);
            boardResultDto.setCount(count);

            boardResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        return boardResultDto;
    }

    @Override
    public BoardResultDto boardInsert(BoardDto dto, MultipartFile uploadFile) throws IOException {

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            dao.boardInsert(dto);

            if (uploadFile != null && !uploadFile.isEmpty()) {
                File uploadDir = new File(uploadPath + File.separator + uploadFolder);
                if (!uploadDir.exists()) uploadDir.mkdir();

                //String s = null; s.length();

                String fileName = uploadFile.getOriginalFilename();

                //Random File Id
                UUID uuid = UUID.randomUUID();

                //file extension
                String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()

                String savingFileName = uuid + "." + extension;

                File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);

                uploadFile.transferTo(destFile);

                // Table Insert
                BoardFileDto boardFileDto = new BoardFileDto();
                boardFileDto.setBoardId(dto.getBoardId());
                boardFileDto.setFileName(fileName);
                boardFileDto.setFileSize(uploadFile.getSize());
                boardFileDto.setFileContentType(uploadFile.getContentType());
                boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName);

                dao.boardFileInsert(boardFileDto);
            }

            boardResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
            //throw e; // Need For Rollback!
        }
        return boardResultDto;
    }

    @Override
    public BoardResultDto getBoard(int boardId) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			BoardDto boardDto = dao.findByBoardId(boardId);
			boardDto.setFileList(dao.findByBoardFileId(boardId));

			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);
		}catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}

        return boardResultDto;
    }

    @Override
    public BoardResultDto boardDelete(int boardId) throws IOException {
        BoardResultDto boardResultDto = new BoardResultDto();

        try {
             dao.boardDelete(boardId);
            boardResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        return boardResultDto;
    }

    @Override
    public BoardResultDto boardUpdate(BoardDto dto, MultipartFile uploadFile){

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            dao.boardUpdate(dto);

            if( uploadFile != null && ! uploadFile.isEmpty() ) {

                File uploadDir = new File(uploadPath + File.separator + uploadFolder);
                if (!uploadDir.exists()) uploadDir.mkdir();

                // 물리 파일 삭제, 첨부파일 여러개 고려
                List<String> fileUrlList = dao.boardFileUrlDeleteList(dto.getBoardId());
                for(String fileUrl : fileUrlList) {
                    File file = new File(uploadPath + File.separator, fileUrl);
                    if(file.exists()) {
                        file.delete();
                    }
                }

                dao.boardFileDelete(dto.getBoardId()); // 테이블 파일 삭제

                String fileName = uploadFile.getOriginalFilename();

                //Random File Id
                UUID uuid = UUID.randomUUID();

                //file extension
                String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()

                String savingFileName = uuid + "." + extension;

                File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
                System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
                uploadFile.transferTo(destFile);

                // Table Insert
                BoardFileDto boardFileDto = new BoardFileDto();
                boardFileDto.setBoardId(dto.getBoardId());
                boardFileDto.setFileName(fileName);
                boardFileDto.setFileSize(uploadFile.getSize());
                boardFileDto.setFileContentType(uploadFile.getContentType());
                String boardFileUrl = uploadFolder + "/" + savingFileName;
                boardFileDto.setFileUrl(boardFileUrl);

                dao.boardFileInsert(boardFileDto);
            }
            boardResultDto.setResult(SUCCESS);

        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }

        return boardResultDto;
    }


}
