<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.mycom.mvcdbhw.dto.QuizDto"%>
<%
	QuizDto quizDto = (QuizDto) request.getAttribute("quizDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=quizDto.getFirst_name()%>
</body>
</html>