<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>HappyHouse</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/loginAndUser.js" type="text/javascript"></script>
<script
	src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css" />
<link rel="stylesheet" href="css/common.css">
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
</head>
<style>
.header {
	width: 100%;
	height: 150px;
	background-repeat: no-repeat;
	background-size: 100% 100%;
	background-image: url('img/happyhousebanner.PNG');
}

.title {
	float: left;
	margin: 40px 0 0 100px;
	font-weight: bold;
	font-size: 50px;
	color: black;
	opacity: 0.8;
}

.login {
	float: right;
	margin: 100px 30px 0 0;
	font-weight: bold;
	position: absolute;
	top: 0px;
	right: 5px;
}

.findPassword {
	margin: 40px 30px 0 0;
	font-weight: bold;
	position: absolute;
	top: 0px;
	right: 5px;
}

.signup {
	float: right;
	margin: 100px 30px 0 0;
	position: absolute;
	top: 0px;
	right: 120px;
}

.navbar_bold {
	font-weight: bold;
	color: white;
}

.content {
	width: 90%;
	margin: 30px 0 50px 100px;
}

.content .map {
	float: left;
	width: 70%;
	height: 500px;
}

.content .search {
	float: left;
	width: 20%;
	height: 500px;
	margin: 0 0 0 30px;
}

.content .search .search_city, .content .search .search_gu, .content .search .search_dong
	{
	float: left;
	width: 100%;
	height: 20%;
}

.content .search .search_select .select_apartment, .content .search .search_select .select_jutaek
	{
	float: left;
	width: 50%;
	height: 100%;
}

.content .list {
	width: 100%;
	float: left;
	margin: 30px 0 30px 0;
}

.information {
	height: 250px;
}

.information-title {
	text-align: center;
	background-color: cadetblue;
	padding: 5px;
}

#page>ul li a {
	padding: 8px;
	margin-right: 8px;
	width: 15px;
	color: #000;
	font: 15px tahoma;
	border: 1px solid #eee;
	text-align: center;
}

#write {
	border: 1px solid #eee;
	padding: 7px;
	margin-left: 90%;
	background-color: darkgray;
	color: white;
	font: 15px tahoma;
}

.house_detail {
	height: 750px;
}

.house_detail .house_detail_img {
	float: left;
	width: 60%;
	height: 100%;
	margin: 0 20px 0 0;
}

.house_detail .house_detail_img img {
	width: 100%;
	height: 60%;
	margin: 120px 0 0 0;
}

.house_detail .house_detail_content {
	float: left;
	width: 35%;
	height: 100%;
}

.modal-title {
	margin-left: 110px;
	font-weight: bold;
}

label {
	font-weight: bold;
}

footer {
	border-top: 2px solid black;
	height: 200px;
	width: 100%;
	float: left;
}
</style>
<body>
	<jsp:include page="header.jsp" />

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<jsp:include page="nav.jsp" />
	</nav>

	<div class="content"
		style="margin-bottom: 10px; font-size: 30px; font-weight: bold;">
		코로나 선별 진료소</div>


	<input type="text" id="coronaget" name="coronaget"
		style="margin: 50px 20px 0 50px">
	<br>

	<table class="table table-hover mt-2">
		<thead>
			<tr>
				<th>날짜</th>
				<th>가능여부</th>
				<th>시도</th>
				<th>군구</th>
				<th>보건소이름</th>
				<th>주소</th>
				<th>평일진료시간</th>
				<th>토요일진료시간</th>
				<th>일요일/공휴일진료시간</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<script>
		$(document)
				.ready(
						function() {
							$("#coronaget")
									.change(
											function() {
												$
														.get(
																"${pageContext.request.contextPath}/coronamap",
																{
																	act : "coronaget",
																	coronaget : $(
																			"#coronaget")
																			.val()
																},
																function(data,
																		status) {
																	$(
																			"#searchResult")
																			.empty();
																	$("tbody")
																			.empty();
																	$
																			.each(
																					data,
																					function(
																							index,
																							vo) {
																						let str = "<tr>"
																								+ "<td>"
																								+ vo.date
																								+ "</td>"
																								+ "<td>"
																								+ vo.available
																								+ "</td>"
																								+ "<td>"
																								+ vo.sido
																								+ "</td>"
																								+ "<td>"
																								+ vo.gungu
																								+ "</td>"
																								+ "<td>"
																								+ vo.name
																								+ "</td>"
																								+ "<td>"
																								+ vo.address
																								+ "</td>"
																								+ "<td>"
																								+ vo.weekdays
																								+ "</td>"
																								+ "<td>"
																								+ vo.saturday
																								+ "</td>"
																								+ "<td>"
																								+ vo.sunday
																								+ "</td>"
																								+ "<td>"
																								+ vo.phone
																								+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
																						$(
																								"tbody")
																								.append(
																										str);
																						$(
																								"#searchResult")
																								.append(
																										vo.date
																												+ " "
																												+ vo.available
																												+ " "
																												+ vo.sido
																												+ " "
																												+ vo.gungu
																												+ " "
																												+ vo.name
																												+ " "
																												+ vo.address
																												+ " "
																												+ vo.weekdays
																												+ " "
																												+ vo.saturday
																												+ " "
																												+ vo.sunday
																												+ " "
																												+ vo.phone
																												+ "<br>");
																					});//each
																}//function
																, "json");//get
											});//change
						});//ready
	</script>

	<footer>
		<jsp:include page="footer.jsp" />
	</footer>


	<script>
		$(document).ready(function() {

			$("#userName").focus();

			$("#userName").blur(function() {
				if (validateUserName($(this))) {
					$(this).removeClass("is-invalid").addClass('is-valid');
				} else {
					$(this).removeClass("is-valid").addClass('is-invalid');
				}
			});

			$("#userPassword").blur(function() {
				if (validatePassword($(this))) {
					$(this).removeClass("is-invalid").addClass('is-valid');
				} else {
					$(this).removeClass("is-valid").addClass('is-invalid');
				}
			});

			$("#userPassword2").blur(function() {
				if (validatePassword2($(this))) {
					$(this).removeClass("is-invalid").addClass('is-valid');
				} else {
					$(this).removeClass("is-valid").addClass('is-invalid');
				}
			});

			$("#userEmail").blur(function() {
				if (validateEmail($(this))) {
					$(this).removeClass("is-invalid").addClass('is-valid');
				} else {
					$(this).removeClass("is-valid").addClass('is-invalid');
				}
			});

			$("#userPhone").blur(function() {
				if (validatePhone($(this))) {
					$(this).removeClass("is-invalid").addClass('is-valid');
				} else {
					$(this).removeClass("is-valid").addClass('is-invalid');
				}
			});

			$(":input").focus(function() {
				$(this).removeClass('is-valid is-invalid');
			});

			//submit
			$("#btnSignUp").click(function() {
				if ($("form").find(".is-invalid").length > 0) {
					alert("입력이 올바르지 않습니다.")
				} else {
					register();
				}
			});
		})
	</script>
</body>
</html>