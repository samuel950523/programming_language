package servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

/jsp/cookieTest.jsp
*/
@WebServlet("/CookieMakeServlet")
public class CookieMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie c1 = new Cookie("c1", "v1");
		c1.setPath("/");
		response.addCookie(c1);

		Cookie c2 = new Cookie("c2", "v2");
		c2.setMaxAge(-1);
		c2.setPath("/jsp/");
		response.addCookie(c2);

		System.out.println("Cookies are sent");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}