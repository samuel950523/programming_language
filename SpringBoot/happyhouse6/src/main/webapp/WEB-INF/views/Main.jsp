<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.happyhouse.dto.*, java.util.*"%>
<%
// 	UserDto userDto = (UserDto) session.getAttribute("userDto");
// 	String userNameVar = null;
// 	if(userDto==null)
// 		userDto.setUserName(userNameVar);
// 	userNameVar = userDto.getUserName();
%>
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

<script
	src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>

<script src="/js/loginAndUser.js" type="text/javascript"></script>

<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css" />
<link rel="stylesheet" href="css/common.css">
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
	margin: 30px 0 0 100px;
}

.content .hot_apartment {
	width: 100%;
	margin: 30px 5% 30px 0;
	float: left;
}

.content .hot_apartment .hot_title, .content .nownews .nownews_title {
	width: 180px;
	height: 40px;
	margin: 0 0 20px 10px;
	padding: 8px 0 0 10px;
	color: white;
	background-color: #343A40;
	border-radius: 20px 20px;
	border: 1px solid #343A40;
	position: relative;
}

.content .hot_apartment .hot_images {
	height: 300px;
	width: 310px;
	float: left;
	margin: 0 0 0 10px;
}

.content .hot_apartment .hot_images img {
	width: 300px;
	height: 250px;
	float: left;
	margin: 0 0 10px 0;
}

.content .hot_apartment .hot_images .hot_images_title {
	text-align: center;
	font-weight: bold;
	font-size: 20px;
}

.content .nownews {
	float: left;
	width: 100%;
	height: 50%;
	margin: 30px 0 0 0;
	overflow-y: scroll;
	overflow-x: hidden
}

.nownews_nextbtn {
	border: 1px solid black;
	width: 200px;
	float: left;
	margin: 5px 0 0 30px;
}

.content .nownews .nownews_content {
	width: 100%;
	height: 300px;
	margin: 0 0 0 10px;
	float: left;
}

.content .nownews .nownews_content .nownews_image {
	float: left;
}

.content .nownews .nownews_content .nownews_image img {
	height: 300px;
	margin: 0 20px 0 0;
}

.content .nownews .nownews_content .nownews_image_story {
	float: left;
	width: 1100px;
	height: 300px;
	margin: 20px 0 0 0;
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

</head>
<body>
	<jsp:include page="header.jsp" />

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<jsp:include page="nav.jsp" />
	</nav>

	<div class="content">
		<div class="hot_apartment">
			<div class="hot_title">최근 인기 매물 TOP 5</div>
			<div class="map" style="height: 500px; margin: 0 0 50px 0;">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25334.38581948137!2d126.92673827451796!3d37.46548567125698!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ffac52c471b%3A0x4db3138b56ffcdc9!2z7ISc7Jq47Yq567OE7IucIOq0gOyVheq1rA!5e0!3m2!1sko!2skr!4v1600246573212!5m2!1sko!2skr"
					width="100%" height="100%" frameborder="0" style="border: 0;"
					allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
			</div>
			<div class="hot_images">
				<img src="img/house1.jpg">
				<div class="hot_images_title">관악구 봉천동 123-45</div>
			</div>
			<div class="hot_images">
				<img src="img/house2.jpg">
				<div class="hot_images_title">종로구 종로동 123-45</div>
			</div>
			<div class="hot_images">
				<img src="img/house3.jpg">
				<div class="hot_images_title">동대문구 동대문동 101호</div>
			</div>
			<div class="hot_images">
				<img src="img/house4.jpg">
				<div class="hot_images_title">광진구 광진동 12-45</div>
			</div>
			<div class="hot_images">
				<img src="img/house5.jpg">
				<div class="hot_images_title">성동구 성동동 111-11</div>
			</div>

		</div>

		<div class="nownews">
			<div class="nownews_title" style="width: 155px; float: left;">
				실시간 뉴스<span class="badge badge-secondary"
					style="margin: 0 0 0 10px;">New</span>
			</div>
			<div class="nownews_content">
				<div class="nownews_image">
					<img src="img/mainnews.PNG">
				</div>
				<div class="nownews_image_story">
					<p style="font-size: 25px; font-weight: bold;">부동산 실거래 조사 때
						등기·과세 등 금융정보 적극 활용하는 법안 나온다</p>
					<p style="font-size: 10px;">서울경제 | 2020.09.16 15:18</p>
					<p style="font-size: 18px;">
						허영 민주당 의원 대표발의<br> <br> 실거래 신고내용 조사 위한 자료 명확히<br> <br>
						개인정보 오·남용 방지 위한 내용도 담겨
					</p>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>

	<script>
		$(document).ready(function() {

			$("#userName").focus();

			$("#ModalSignbutton").click(function() {
				if ($("form").find(".is-invalid").length > 0) {
					alert("입력이 올바르지 않습니다.");
				} else {
					// 성공
					register();

					$("#SignModal").modal("hide");
					$("form").each(function() {
						this.reset();
					});
					$("#Susername").removeClass("is-valid");
					$("#Spassword").removeClass("is-valid");
					$("#Spassword2").removeClass("is-valid");
					$("#Sphone").removeClass("is-valid");
					$("#Semail").removeClass("is-valid");
				}
			});

			$("#signTologin").click(function() {
				$("#SignModal").modal("hide");
				$("#loginModal").modal();
			});

			$("#Susername").focus();

			// manually check
			$("#Susername").blur(function() {
				if (validateUserName($(this))) {
					$("#UserCondition").hide();
					$(this).removeClass("is-invalid").addClass("is-valid");
				} else {
					$("#UserCondition").show();
					$(this).removeClass("is-valid").addClass("is-invalid");
				}
			});

			$("#Spassword").blur(function() {
				if (validatePassword($(this))) {
					$("#PWCondition").hide();
					$(this).removeClass("is-invalid").addClass("is-valid");
				} else {
					$("#PWCondition").show();
					$(this).removeClass("is-valid").addClass("is-invalid");
				}
			});

			$("#Spassword2").blur(function() {
				if (validatePassword2($(this))) {
					$(this).removeClass("is-invalid").addClass("is-valid");
				} else {
					$(this).removeClass("is-valid").addClass("is-invalid");
				}
			});

			$("#Sphone").blur(function() {
				if (validatePhone($(this))) {
					$("#PhoneCondition").hide();
					$(this).removeClass("is-invalid").addClass("is-valid");
				} else {
					$("#PhoneCondition").show();

					$(this).removeClass("is-valid").addClass("is-invalid");
				}
			});

			$("#Semail").blur(function() {
				if (validateEmail($(this))) {
					$(this).removeClass("is-invalid").addClass("is-valid");
				} else {
					$(this).removeClass("is-valid").addClass("is-invalid");
				}
			});

			$(":input").focus(function() {
				$(this).removeClass("is-valid is-invalid");
			});

			$("#ModalLoginbutton").click(function() {

				if (loginValidate()) {
					login();
				}
			});

			//detail
			$("#Managebutton").click(function() {
				var userName = "lovessafy";
				if(userName!=null)
					userInfoDetail(userName);
			});

// 			// update
			$("#btnUserInfoUpdateForm2").click(function() {
				$("#passwordUpdate").val($("#passwordDetail").html());
				$("#emailUpdate").val($("#emailDetail").html());
				console.log(1111);
				$("#userInfoDetailModal").modal("hide");
				$("#UserInfoUpdateModal").modal("show");
			});

			$("#btnUserInfoUpdate").click(function() {
				if (validateUpdate()) {
					var userName = "lovessafy";
					userInfoUpdate(userName);
				}
			});

// 			// delete
			$("#btnUserInfoDeleteConfirm2").click(function() {
				alertify.confirm('삭제 확인', '정~말로 탈퇴하시겠습니까?', function() {
					var userName = "lovessafy";
					userInfoDelete(userName);
				}, function() {
					console.log('cancel');
				});
			});

		})
	</script>

</body>
</html>