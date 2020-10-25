<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.mycom.mvcdbhw.dto.QuizDto"%>
<%
	QuizDto empDto = (QuizDto) request.getAttribute("empDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=empDto.getFirstName()%>
</body>
</html>