package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.dto.BoardDto;
import board.service.BoardService;
import board.service.BoardServiceImpl;

/*
 * contextPath 고려
 */
@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// met
	BoardService service = new BoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String contextPath = request.getContextPath();
		String path = request.getRequestURI().substring(contextPath.length());

		System.out.println(path);
		
		switch(path) {
			case "/board/boardMain"				: boardMain(request, response); break;
			case "/board/boardList"				: boardList(request, response); break;
			case "/board/boardListTotalCnt"		: boardListTotalCnt(request, response); break;
			case "/board/boardInsert"		: boardInsert(request, response); break;
			case "/board/boardDetail"		: boardDetail(request, response); break;
			case "/board/boardUpdate"		: boardUpdate(request, response); break;
			case "/board/boardDelete"		: boardDelete(request, response); break;
			default : notValidUrl();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	private void boardMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/board/boardMain.jsp"); 
		dispatcher.forward(request, response);
	}
	
	private void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String strLimit = request.getParameter("limit");
		int limit = Integer.parseInt(strLimit);
		String strOffset = request.getParameter("offset");
		int offset = Integer.parseInt(strOffset);
		String searchWord = request.getParameter("searchWord");
		
		List<BoardDto> boardList;
		
		if( "".equals(searchWord) ) {
			boardList = service.boardList(limit, offset);
		}else {
			boardList = service.boardListSearchWord(limit, offset, searchWord);
		}

		Gson gson = new Gson();
		String jsonStr = gson.toJson(boardList);
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(jsonStr);
		System.out.println("BoardServlet boardList jsonStr : " + jsonStr);
	}
	
	private void boardListTotalCnt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String searchWord = request.getParameter("searchWord");
		
		int totalCnt;
		if( "".equals(searchWord) ) {
			totalCnt = service.boardListTotalCnt();
		}else {
			totalCnt = service.boardListSearchWordTotalCnt(searchWord);
		}
		
		response.setContentType("text/html; charset=utf-8");
		Gson gson = new Gson();
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("totalCnt", totalCnt);
		
		String jsonStr = gson.toJson(jsonObject);
		
		response.getWriter().write(jsonStr);
		System.out.println("BoardServlet boardListTotalCnt totalCnt : " + totalCnt);
	}

	private void boardInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		BoardDto boardDto = new BoardDto();
		String strUserSeq = request.getParameter("userSeq");
		int userSeq = Integer.parseInt(strUserSeq);
		boardDto.setUserSeq(userSeq);
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setContent(request.getParameter("content"));
		
		int ret = service.boardInsert(boardDto);
		
		// if cnt != 1 Exception ...
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		if (ret == 1) {
			jsonObject.addProperty("result", "success");
		} else {
			jsonObject.addProperty("result", "fail");
		}
		
		String jsonStr = gson.toJson(jsonObject);
		response.getWriter().write(jsonStr);
	}
	
	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String strBoardId = request.getParameter("boardId");
		// if strBoardId == null or "" Exception ...
		int boardId = Integer.parseInt(strBoardId);
		BoardDto boardDto = service.boardDetail(boardId);

		Gson gson = new Gson();

		String jsonStr = gson.toJson(boardDto, BoardDto.class);
		response.getWriter().write(jsonStr);
	}
	
	private void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		BoardDto boardDto = new BoardDto();
		String strBoardId = request.getParameter("boardId");

		int boardId = Integer.parseInt(strBoardId);
		boardDto.setBoardId(boardId);
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setContent(request.getParameter("content"));
		
		int ret = service.boardUpdate(boardDto);

		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		if (ret == 1) {
			jsonObject.addProperty("result", "success");
		} else {
			jsonObject.addProperty("result", "fail");
		}
		
		String jsonStr = gson.toJson(jsonObject);
		response.getWriter().write(jsonStr);
	}
	
	private void boardDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String strBoardId = request.getParameter("boardId");
		// if strBoardId == null or "" Exception ...
		int boardId = Integer.parseInt(strBoardId);
		int ret = service.boardDelete(boardId);

		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		if (ret == 1) {
			jsonObject.addProperty("result", "success");
		} else {
			jsonObject.addProperty("result", "fail");
		}
		
		String jsonStr = gson.toJson(jsonObject);
		response.getWriter().write(jsonStr);
	}

	private void notValidUrl() {
		System.out.println("BoardServlet - Not Valid URL Request !");
	}
}