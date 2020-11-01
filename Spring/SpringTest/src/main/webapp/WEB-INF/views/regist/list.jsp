<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
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
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>국가번호</th>
				<th>국가명</th>
				<th>확진자수</th>
				<th>지역</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="countrystatus" items="${countrystatuss}">
				<tr>
					<td><a href="${root}/list/${countrystatus.ccode}">${countrystatus.ccode}</a>
					</td>
					<td>${countrystatus.cname}</td>
					<td>${countrystatus.patient}</td>
					<td>${countrystatus.rcode}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>