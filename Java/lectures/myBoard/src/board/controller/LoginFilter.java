package board.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dto.UserDto;

// no exclude
@WebFilter("/*")
public class LoginFilter implements Filter{

@Override
public void destroy() {}

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    HttpServletResponse httpServletResponse = (HttpServletResponse) res;
    
    String contextPath = httpServletRequest.getContextPath();
    String path = httpServletRequest.getRequestURI();
    
    System.out.println("BoardWebAjaxJson - doFilter path : " + path ); 

    HttpSession session = httpServletRequest.getSession();

    // exclude
    // /html/
    // /img/
    // /login
    if( ! path.contains("/img/") && ! path.contains("/register") &&! path.contains("/login") ) {
        UserDto userDto = (UserDto) session.getAttribute("userDto");

        if(userDto == null) {
            httpServletResponse.sendRedirect(contextPath + "/jsp/login.jsp");
            return;
        }
    }

    chain.doFilter(req, res);
}

@Override
public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub
    
}
}