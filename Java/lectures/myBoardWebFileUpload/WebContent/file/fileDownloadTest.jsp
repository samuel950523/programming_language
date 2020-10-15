<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Download Test</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
</head>
<body>
	<h4>파일 download</h4>
	<a href="../img/CH0005.jpg" download>이름 그대로 받기</a>
	<a href="../img/CH0005.jpg" download="file1.jpg">이름 바꿔서 받기</a>
	<a href="./파일다운로드_테스트.xlsx" download>Excel 파일 받기</a>
</body>
</html>