<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SSAFY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>


<c:if test="${userinfo == null}">
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<h3>${msg}</h3>
<%@ include file="/WEB-INF/views/user/login.jsp" %>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</c:if>

<c:if test="${userinfo != null}">
<%@ include file="/WEB-INF/views/include/regist.jsp"%>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</c:if>
</body>
</html>