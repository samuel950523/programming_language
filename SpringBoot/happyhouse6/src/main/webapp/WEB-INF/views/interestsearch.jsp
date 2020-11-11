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
<link rel="stylesheet"
	href="css/common.css">
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
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
	height: 1000px;
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
	height: 45%;
	float: left;
	margin: 30px 0 0 0;
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

.notice_detail {
	height: 750px;
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

.notice_content {
	width: 90%;
	margin: 50px auto 50px auto;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp" />
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<jsp:include page="nav.jsp" />
	</nav>

	<div class="search" style="margin: 0 0 0 40px; height: 130px;">
		<form action="/action_page.php">
			<div style="float: left;">
				<label for="cars" class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">음식
					정보/ 대기 오염 정보</label> <select name="cars" id="cars">
					<option value="gwanakgu">음식</option>
					<option value="dongjakgu">대기 오염</option>
				</select>
			</div>
			<div style="float: left;">
				<label for="cars" class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">군
					/ 구</label> <select name="cars" id="cars">
					<option value="gwanakgu">관악구</option>
					<option value="dongjakgu">동작구</option>
					<option value="ddangddanggu">땡땡구</option>
				</select>
			</div>
			<div style="float: left;">
				<label for="cars" class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">동</label>
				<select name="cars" id="cars">
					<option value="sillimdong">신림동</option>
					<option value="hangundong">행운동</option>
					<option value="sadangdong">사당동</option>
				</select>
			</div>
			<input type="submit" value="검색" class="btn btn-dark"
				style="margin: 50px 0 0 50px;">
		</form>
	</div>
	<div class="interest_content"
		style="height: 1000px; width: 92%; margin: 0 auto 40px auto;">
		<div class="interest_what"
			style="border-top: 10px solid black; float: left; width: 20%; height: 100%;">
			<div style="font-size: 40px; font-weight: bold; margin: 20px 0 0 0">
				관심 지역 목록</div>
			<div
				style="border-top: 1px solid black; font-size: 30px; font-weight: bold; margin: 20px 0 0 0">
				궁동 / 구로구</div>
			<div
				style="margin: 5px 0 0 0; font-size: 20px; width: 40%; font-weight: bold; height: 50px;; width: 100%">
				<div style="float: left;">
					<a href="#">메인으로 설정</a>
				</div>
				<div style="float: right;">
					<a href="#">삭제</a>
				</div>
			</div>
			<div
				style="border-top: 1px solid black; font-size: 30px; font-weight: bold; margin: 20px 0 0 0">
				신림동 / 관악구</div>
			<div
				style="margin: 5px 0 0 0; font-size: 20px; width: 40%; font-weight: bold; height: 50px;; width: 100%">
				<div style="float: left;">
					<a href="#">메인으로 설정</a>
				</div>
				<div style="float: right;">
					<a href="#">삭제</a>
				</div>
			</div>
			<div
				style="border-top: 1px solid black; font-size: 30px; font-weight: bold; margin: 20px 0 0 0">
				동작동 / 동작구</div>
			<div
				style="margin: 5px 0 0 0; font-size: 20px; width: 40%; font-weight: bold; height: 50px;; width: 100%">
				<div style="float: left;">
					<a href="#">메인으로 설정</a>
				</div>
				<div style="float: right;">
					<a href="#">삭제</a>
				</div>
			</div>
		</div>
		<div class="interest_map"
			style="float: left; width: 60%; height: 100%; margin: 0 0 0 200px;">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25334.38581948137!2d126.92673827451796!3d37.46548567125698!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ffac52c471b%3A0x4db3138b56ffcdc9!2z7ISc7Jq47Yq567OE7IucIOq0gOyVheq1rA!5e0!3m2!1sko!2skr!4v1600246573212!5m2!1sko!2skr"
				width="100%" height="100%" frameborder="0" style="border: 0;"
				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
		</div>
	</div>
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
