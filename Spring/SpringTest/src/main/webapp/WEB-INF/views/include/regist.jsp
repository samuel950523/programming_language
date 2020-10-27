<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#writeBtn").click(
						function() {
							if ($("#ccode").val() == "") {
								alert("국가 코드 입력!!!");
								return;
							} else if ($("#cname").val() == "") {
								alert("국가명 입력!!!");
								return;
							} else if ($("#patient").val() == "") {
								alert("확진자수 입력!!!");
								return;
							} else if ($("#rcode").val() == "") {
								alert("지역 입력!!!");
								return;
							} else {
								$("#writeform").attr("action",
										"${root}/article/write").submit();
							}
						});
			});
</script>
</head>
<title>SSAFY</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h2>확진자 현황 등록</h2>
	<form id="registForm" action="${root }regist" method="post">
		<label for="ccode" class="inputtitle">국가 코드</label> <input type="text"
			name="ccode" id="ccode"> <br> <label for="cname"
			class="inputtitle">국가명</label> <input type="text" name="cname"
			id="cname"> <br> <label for="patient" class="inputtitle">확진자수</label>
		<input type="number" name="patient" id="patient"> <br> <label
			for="rcode" class="inputtitle">지역</label> <select id="rcode"
			name="rcode">
			<option value="eu">유럽
			<option value="na">북아메리카
			<option value="as">아시아
		</select> <br> 
		<button type="button" id="writeBtn" class="btn btn-primary">확진자 현황 등록</button>
		<button type="reset" class="btn btn-warning">초기화</button>
	</form>
</body>

</html>