<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h2>확진자 현황 등록</h2>
	<form id="registForm" action="${root }regist" method="post">
		<label for="ccode" class="inputtitle">국가 코드</label>
		<input type="text" name="ccode" id="ccode">
		<br>
		<label for="cname" class="inputtitle">국가명</label>
		<input type="text" name="cname" id="cname">
		<br>
		<label for="patient" class="inputtitle">확진자수</label>
		<input type="number" name="patient" id="patient">
		<br>
		<label for="rcode" class="inputtitle">지역</label>
		<select id="rcode" name="rcode">
			<option value="eu">유럽
			<option value="na">북아메리카
			<option value="as">아시아
		</select>
		<br>
		<input type="submit" value="확진자 현황 등록">
		<input type="reset" value="초기화">
	</form>
</body>

</html>