
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Cookie Test</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	for (Cookie cookie : cookies) {
		out.println("<h4>쿠키 : " + cookie.getName() + "</h4>");
	}
	%>
</body>
</html>