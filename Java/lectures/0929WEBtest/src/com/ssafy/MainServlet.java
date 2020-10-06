package com.ssafy;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equals("count")) {
			count(request, response);
		} else if (action.equals("pororo")) {
			pororo(request, response);
		}
	}

	private void count(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		// 구현 하세요.
		String words = request.getParameter("words");
		int num = Integer.parseInt(words);
		int result = Count.execute(num);
	
		request.setAttribute("result", result);
	    request.getRequestDispatcher("Result.jsp").forward(request, response);

	
	}
	private void pororo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String fname=request.getParameter("fname");
		String path=request.getServletContext().getRealPath("/res");
		System.out.println(path);
		File f = new File(path, fname);
		int result = Pororo.execute(f);
	
		request.setAttribute("result", result);
	    request.getRequestDispatcher("Result.jsp").forward(request, response);
	}
}
