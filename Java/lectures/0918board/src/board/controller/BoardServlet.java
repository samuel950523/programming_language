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

import board.dto.BoardDto;
import board.service.BoardService;
import board.service.BoardServiceImpl;

@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	BoardService service = new BoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String contextPath= request.getContextPath();
		String path = request.getRequestURI().substring(contextPath.length());
		
		System.out.println(path);
		
		switch (path) {
		case "/board/boardMain": boardMain(request,response); break;
		case "/board/boardList": boardList(request,response); break;
		case "/board/boardListTotalcnt": boardListTotalcnt(request,response); break;
		case "/board/boardInsert": boardInsert(request,response); break;
		case "/board/boardDetail": boardDetail(request,response); break;
		case "/board/boardUpdate": boardUpdate(request,response); break;
		case "/board/boardDelete": boardDelete(request,response); break;
		default: notValidUrl();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	private void boardMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/board/boardMain.jsp");
		dispatcher.forward(request, response);
	}

	private void boardList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String strLimit = request.getParameter("limit");
		int limit = Integer.parseInt(strLimit);
		String strOffset = request.getParameter("offset");
		int offset = Integer.parseInt(strOffset);
		String searchWord = request.getParameter("searchWord");
		
		List<BoardDto> boardList;
		
		if("".equals(searchWord)) {
			boardList = service.boardList(limit, offset);
		}else {
			boardList = service.boardListSearchWord(limit, offset, searchWord);
		}
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(boardList);
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(jsonStr);
		System.out.println("BoardServlet boarList jsonStr : " + jsonStr);
	}

	private void boardListTotalcnt(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void boardInsert(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String strBoardId = request.getParameter("boardId");
		int boardId = Integer.parseInt(strBoardId);
		BoardDto boardDto = service.boardDetail(boardId);
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(boardDto,BoardDto.class);
		response.getWriter().write(jsonStr);
	}

	private void boardUpdate(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void boardDelete(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void notValidUrl() {
		
	}

	

}
