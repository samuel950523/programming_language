package com.ssafy.happyhouse.model.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardFileDto;
import com.ssafy.happyhouse.model.dao.BoardDao;
import com.ssafy.happyhouse.model.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {

	BoardDao dao = new BoardDaoImpl();
	String uploadFolder = "upload";
	
	/* for production code */
	//String uploadPath = getServletContext().getRealPath("/") + File.separator + uploadFolder;
	
	/* for eclipse development code */
	// D:\VSCode\language\Java\lectures\myBoardWebFileUpload
	String uploadPath = "D:" + File.separator + "VSCode" + File.separator + "language" + File.separator + "Java" + File.separator + 
			"lectures" + File.separator + "1016pjt" + File.separator + "WebContent";
	//String uploadPath = "D:\\SSAFY\\java\\eclipse\\ssafy4\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BoardWebFileUpload";
	
	@Override
	public int boardInsert(BoardDto dto, Collection<Part> parts) throws IOException{
		int boardId =  dao.boardInsert(dto);

		File uploadDir = new File(uploadPath + File.separator + uploadFolder);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		// 첨부 파일 여러개 고려
		for ( Part part : parts ) {
		    String fileName = getFileName(part);
	    
		    if("".equals(fileName)) continue;
		    
		    //Random File Id
			UUID uuid = UUID.randomUUID();
			
			//file extension
			String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()
			
			String savingFileName = uuid + "." + extension;
			System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
		    part.write(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
		    
		    // Table Insert
		    BoardFileDto boardFileDto = new BoardFileDto();
		    boardFileDto.setBoardId(boardId);
		    boardFileDto.setFileName(fileName);
		    boardFileDto.setFileSize(part.getSize());
			boardFileDto.setFileContentType(part.getContentType());
			String boardFileUrl = uploadFolder + "/" + savingFileName;
			boardFileDto.setFileUrl(boardFileUrl);

			dao.boardFileInsert(boardFileDto);
		}
		
		return boardId;
	}
	
	// utility method
	private String getFileName(Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename"))
	            return content.substring(content.indexOf("=") + 2, content.length() - 1);
	    }
	    return "";
	}
	
	

	@Override
	public int boardUpdate(BoardDto dto, Collection<Part> parts) throws IOException{
		
		int ret = dao.boardUpdate(dto);
		
		File uploadDir = new File(uploadPath + File.separator + uploadFolder);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		// 새로운 파일이 첨부되어 있으면 기존 파일을 삭제해야 하는데 삭제 작업을 loop 에서 매번 하지 않고 한번 만 하기 위한 변수
		boolean isFileDeleted = false;
		
		// 첨부파일 여러개 고려
		for ( Part part : parts ) {
		    String fileName = getFileName(part);
	    
		    if("".equals(fileName)) continue;
		    
		    // 새로운 파일이 첨부되어 있으면
		    if( ! isFileDeleted ) {
		    	
		    	// 물리 파일 삭제
		    	// 첨부파일 여러개 고려
		    	List<String> fileUrlList = dao.boardFileUrlDeleteList(dto.getBoardId());

				for(String fileUrl : fileUrlList) {

					File file = new File(uploadPath + File.separator, fileUrl);
					if(file.exists()) {
						file.delete();
					}
				}
				
				// 테이블 파일 삭제
		    	dao.boardFileDelete(dto.getBoardId());
		    	isFileDeleted = true;
		    }
		    
		    //Random File Id
			UUID uuid = UUID.randomUUID();
			
			//file extension
			String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()
			
			String savingFileName = uuid + "." + extension;
			
		    part.write(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
		    
		    // Table Insert
		    BoardFileDto boardFileDto = new BoardFileDto();
		    boardFileDto.setBoardId(dto.getBoardId());
		    boardFileDto.setFileName(fileName);
		    boardFileDto.setFileSize(part.getSize());
			boardFileDto.setFileContentType(part.getContentType());
			String boardFileUrl = uploadFolder + "/" + savingFileName;
			boardFileDto.setFileUrl(boardFileUrl);

			dao.boardFileInsert(boardFileDto);
		}
		return ret;
	}

	@Override
	public int boardDelete(int boardId) {
		List<String> fileUrlList = dao.boardFileUrlDeleteList(boardId);
		for(String fileUrl : fileUrlList) {
			File file = new File(uploadPath + File.separator, fileUrl);
			
			if(file.exists()) {
				file.delete();
			}
		}
		
		dao.boardFileDelete(boardId);
		int ret = dao.boardDelete(boardId);

		return ret;
	}

	@Override
	public BoardDto boardDetail(int boardId, int userSeq) {
		// New for ReadCnt
		int userReadCnt = dao.boardUserReadCount(boardId, userSeq);
		
		if( userReadCnt == 0 ) {
			dao.boardUserReadInsert(boardId, userSeq);
		}
		dao.boardReadCountUpdate(boardId);
		
		BoardDto dto = dao.boardDetail(boardId);
		System.out.println("dto = " + dto);
		System.out.println("boardId = " + boardId);
		
		List<BoardFileDto> fileList = dao.boardDetailFileList(dto.getBoardId());
		dto.setFileList(fileList);
		
		return dto;
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

	@Override
	public int boardFileInsert(BoardFileDto dto) {
		return dao.boardFileInsert(dto);
	}

	@Override
	public List<BoardFileDto> boardDetailFileList(int boardId) {
		return dao.boardDetailFileList(boardId);
	}

	@Override
	public int boardFileDelete(int boardId) {
		return dao.boardFileDelete(boardId);
	}

	@Override
	public List<String> boardFileUrlDeleteList(int boardId) {
		return dao.boardFileUrlDeleteList(boardId);
	}

	@Override
	public int boardUserReadCount(int boardId, int userSeq) {
		return dao.boardUserReadCount(boardId, userSeq);
	}

	@Override
	public int boardUserReadInsert(int boardId, int userSeq) {
		return dao.boardUserReadInsert(boardId, userSeq);
	}

	@Override
	public int boardReadCountUpdate(int boardId) {
		return dao.boardReadCountUpdate(boardId);
	}

}