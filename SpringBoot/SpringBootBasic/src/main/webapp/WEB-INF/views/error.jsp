<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>error jsp</title>
</head>
<body>
   <h1>Error Page</h1>
   <p>서비스에 문제가 발생했습니다.</p>


   Failed URL: ${url} Exception: ${exception.message}
   <c:forEach items="${exception.stackTrace}" var="ste">  ${ste} </c:forEach>

</body>
</html>