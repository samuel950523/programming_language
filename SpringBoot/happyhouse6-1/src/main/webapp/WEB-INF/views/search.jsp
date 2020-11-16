<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy House</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="/js/loginAndUser.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/common.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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

	<div class="content">
		<div class="map" id="map"></div>
		<script
			src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
		<script defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2Mf7aRtZp2euvicLt6TTPUuC-vqDlk88&callback=initMap"></script>
		<script>
			var multi = {
				lat : 37.5665734,
				lng : 126.978179
			};
			var map;
			function initMap() {
				map = new google.maps.Map(document.getElementById('map'), {
					center : multi,
					zoom : 12
				});
				var marker = new google.maps.Marker({
					position : multi,
					map : map
				});
			}
			function addMarker(tmpLat, tmpLng, aptName) {
				var marker = new google.maps.Marker({
					position : new google.maps.LatLng(parseFloat(tmpLat),
							parseFloat(tmpLng)),
					label : aptName,
					title : aptName
				});
				marker.addListener('click', function() {
					map.setZoom(17);
					map.setCenter(marker.getPosition());
					callHouseDealInfo();
				});
				marker.setMap(map);
			}
			function callHouseDealInfo() {
				alert("목록에서 클릭하여 확인하세요.");
			}
		</script>


		<div class="search">
			<form action="/action_page.php">
				<label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">시</label>
				<select id="sido">
					<option value="0">선택</option>
				</select> <br> <br> <label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">군
					/ 구</label> <select id="gugun">
					<option value="0">선택</option>
				</select> <br> <br> <label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">동</label>
				<select id="dong">
					<option value="0">선택</option>
				</select> <label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">아파트이름</label>
				<input type="text" id="aptdetail" name="aptdetail"
					style="margin: 50px 20px 0 50px"><br>
			</form>
		</div>

		<div class="list">
			<table class="table table-hover mt-2">
				<thead>
					<tr>
						<th>법정동</th>
						<th>아파트이름</th>
						<th>지번</th>
						<th>지역코드</th>
						<th>위도</th>
						<th>경도</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

			<div id="gethouse" class="w3-modal">
				<div class="w3-modal-content">
					<div class="w3-container">
						<span
							onclick="document.getElementById('gethouse').style.display='none'"
							class="w3-button w3-display-topright">&times;</span>
						<div class="house_detail">
							<div class="house_detail_img">
								<img src="img/house1.jpg">
							</div>
							<div class="house_detail_content">
								<label class="badge badge-secondary"
									style="margin: 60px 20px 0 50px; height: 30px; font-size: 20px;">주택명</label>
								태양아파트 <label for="cars" class="badge badge-secondary"
									style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">거래금액</label>
								480,000 <label for="cars" class="badge badge-secondary"
									style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">월세금액</label>
								없음 <label for="cars" class="badge badge-secondary"
									style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">건축연도</label>
								1995 <label for="cars" class="badge badge-secondary"
									style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">전용면적</label>
								84.9 <label for="cars" class="badge badge-secondary"
									style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">거래일</label>
								2019년 1월 5일 <label for="cars" class="badge badge-secondary"
									style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">법정동</label>
								명륜2가 <label for="cars" class="badge badge-secondary"
									style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">지번</label>
								4
							</div>
						</div>
					</div>
				</div>
			</div>

			<button type="button" title="등록" id="write">등록</button>

		</div>

	</div>

	<script>
		$(document).ready(
				function() {
					$.get("${pageContext.request.contextPath}/map", {
						act : "sido"
					}, function(data, status) {
						$.each(data, function(index, vo) {
							$("#sido").append(
									"<option value='"+vo.sido_code+"'>"
											+ vo.sido_name + "</option>");
						});//each
					}//function
					, "json");//get
				});//ready
		$(document)
				.ready(
						function() {
							$("#sido")
									.change(
											function() {
												$
														.get(
																"${pageContext.request.contextPath}/map",
																{
																	act : "gugun",
																	sido : $(
																			"#sido")
																			.val()
																},
																function(data,
																		status) {
																	$("#gugun")
																			.empty();
																	$("#gugun")
																			.append(
																					'<option value="0">선택</option>');
																	$
																			.each(
																					data,
																					function(
																							index,
																							vo) {
																						$(
																								"#gugun")
																								.append(
																										"<option value='"+vo.gugun_code+"'>"
																												+ vo.gugun_name
																												+ "</option>");
																					});//each
																}//function
																, "json");//get
											});//change
							$("#gugun")
									.change(
											function() {
												$
														.get(
																"${pageContext.request.contextPath}/map",
																{
																	act : "dong",
																	gugun : $(
																			"#gugun")
																			.val()
																},
																function(data,
																		status) {
																	$("#dong")
																			.empty();
																	$("#dong")
																			.append(
																					'<option value="0">선택</option>');
																	$
																			.each(
																					data,
																					function(
																							index,
																							vo) {
																						$(
																								"#dong")
																								.append(
																										"<option value='"+vo.dong+"'>"
																												+ vo.dong
																												+ "</option>");
																					});//each
																}//function
																, "json");//get
											});//change
							$("#dong")
									.change(
											function() {
												$
														.get(
																"${pageContext.request.contextPath}/map",
																{
																	act : "apt",
																	dong : $(
																			"#dong")
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
																						let str = "<tr onclick=detailClick(\""
																								+ vo.aptName
																								+ "\", \""
																								+ vo.dong
																								+ "\")>"
																								+ "<td>"
																								+ vo.dong
																								+ "</td>"
																								+ "<td>"
																								+ vo.aptName
																								+ "</td>"
																								+ "<td>"
																								+ vo.jibun
																								+ "</td>"
																								+ "<td>"
																								+ vo.code
																								+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
																						$(
																								"tbody")
																								.append(
																										str);
																						$(
																								"#searchResult")
																								.append(
																										vo.dong
																												+ " "
																												+ vo.aptName
																												+ " "
																												+ vo.jibun
																												+ "<br>");
																					});//each
																	geocode(data);
																}//function
																, "json");//get
											});//change
							$("#aptdetail")
									.change(
											function() {
												$
														.get(
																"${pageContext.request.contextPath}/map",
																{
																	act : "aptdetail",
																	aptdetail : $(
																			"#aptdetail")
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
																						let str = "<tr onclick=detailClick(\""
																								+ vo.aptName
																								+ "\", \""
																								+ vo.dong
																								+ "\")>"
																								+ "<td>"
																								+ vo.dong
																								+ "</td>"
																								+ "<td>"
																								+ vo.aptName
																								+ "</td>"
																								+ "<td>"
																								+ vo.jibun
																								+ "</td>"
																								+ "<td>"
																								+ vo.code
																								+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
																						$(
																								"tbody")
																								.append(
																										str);
																						$(
																								"#searchResult")
																								.append(
																										vo.dong
																												+ " "
																												+ vo.aptName
																												+ " "
																												+ vo.jibun
																												+ "<br>");
																					});//each
																	geocode(data);
																}//function
																, "json");//get
											});//change
						});//ready

		function geocode(jsonData) {
			let idx = 0;
			$.each(jsonData, function(index, vo) {
				let tmpLat;
				let tmpLng;
				$.get("https://maps.googleapis.com/maps/api/geocode/json", {
					key : 'AIzaSyD2Mf7aRtZp2euvicLt6TTPUuC-vqDlk88',
					address : vo.dong + "+" + vo.aptName + "+" + vo.jibun
				}, function(data, status) {
					//alert(data.results[0].geometry.location.lat);
					tmpLat = data.results[0].geometry.location.lat;
					tmpLng = data.results[0].geometry.location.lng;
					$("#lat_" + index).text(tmpLat);
					$("#lng_" + index).text(tmpLng);
					addMarker(tmpLat, tmpLng, vo.aptName);
				}, "json");//get
			});//each
		}

		function detailClick(aptName, dongCode) {
			$.get("${pageContext.request.contextPath}/map", {
				act : "aptDeal",
				aptName : aptName,
				dongCode : dongCode
			}, function(data, status) {
				//     	        	let str = "<tr onclick=\"detailClick()\""
				//     	                  + "<td>" + vo.no + "</td>"
				//     	                  + "<td>" + vo.dong + "</td>"
				//     	                  + "<td>" + vo.aptName + "</td>"
				//     	                  + "<td>" + vo.jibun + "</td>"
				//     	                  + "<td>" + vo.code
				//     	                  + "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
				//     	                  $("tbody").append(str);
				//     	                  $("#searchResult").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");

				console.log(data);
			}//function
			, "json");//get
		}
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