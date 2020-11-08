package com.mycom.myboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mycom.myboard.dao.BoardDao;
import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	String uploadFolder = "upload";

	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	/* for eclipse development code */
	
	// C:\SpringBoot\BoardFileUploadSpringBootMyBatis
	
	String uploadPath = "C:" + File.separator + "SpringBoot" + File.separator +"BoardFileUploadSpringBootMyBatis"
			+ File.separator + "src" + File.separator + "main" + File.separator
			+ "webapp" + File.separator + "resources" + File.separator + "static";
	
	@Override
	public BoardResultDto boardInsert(BoardDto dto, MultipartFile uploadFile) throws IOException {

		BoardResultDto boardResultDto = new BoardResultDto();

		try {
			dao.boardInsert(dto); // useGeneratedKeys="true" keyProperty="boardId"

			if (uploadFile != null && !uploadFile.isEmpty()) {
				int boardId = dto.getBoardId();

				File uploadDir = new File(uploadPath + File.separator + uploadFolder);
				if (!uploadDir.exists())
					uploadDir.mkdir();

				// String s = null; s.length();

				String fileName = uploadFile.getOriginalFilename();

				// Random File Id
				UUID uuid = UUID.randomUUID();

				// file extension
				String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()

				String savingFileName = uuid + "." + extension;

				File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);

				System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
				uploadFile.transferTo(destFile);

				// Table Insert
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setBoardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(uploadFile.getSize());
				boardFileDto.setFileContentType(uploadFile.getContentType());
				String boardFileUrl = uploadFolder + "/" + savingFileName;
				boardFileDto.setFileUrl(boardFileUrl);

				dao.boardFileInsert(boardFileDto);
			}

			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
			// throw e; // Need For Rollback!
		}
		return boardResultDto;
	}

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
			int count = dao.boardListSearchWordTotalCount(boardParamDto);

			boardResultDto.setList(list);
			boardResultDto.setCount(count);

			boardResultDto.setResult(SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

}
