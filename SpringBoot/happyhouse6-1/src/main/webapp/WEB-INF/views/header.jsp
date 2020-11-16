<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <c:set value="${pageContext.request.contextPath}" var="root" /> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="root" />


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/common.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<div class="title">HappyHouse</div>
		<c:if test="${empty userDto}">
			<div class="findPassword">
				<button type="button" id="btnFindPassword" class="btn btn-danger"
					data-toggle="modal" data-target="#findPassword">비밀번호찾기</button>
			</div>

			<!-- The Modal -->
			<div class="modal fade" id="findPassword">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">비밀번호 찾기</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<div class="form-group" style="float: left; width: 75%">
								<label for="userName">ID</label> <input type="text"
									class="form-control" name="userName"
									placeholder="본인의 아이디를 입력하세요. (4자리 이상)" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group" id="user" style="float: left; width: 75%">
								<label for="user">이름</label> <input type="text"
									class="form-control" id="user" name="user"
									placeholder="본인의 이름을 입력하세요." required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" id="btnfindPassword"
								class="btn btn-success" value="Send">찾기</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>

			<div class="login">
				<button type="button" class="btn btn-dark" data-toggle="modal"
					data-target="#Login">로그인</button>
			</div>

			<!-- login modal -->
			<div id="Login" class="modal fade">
				<div class="modal-dialog modal-login">
					<div class="modal-content">
						<div class="modal-header">
							<div class="avatar">
								<img
									src="https://www.tutorialrepublic.com/examples/images/avatar.png"
									alt="Avatar" />
							</div>
							<h4 class="modal-title">Member Login</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<form name="loginForm" action="">
								<div class="form-group">
									<input type="text" class="form-control" id="Lusername"
										name="Lusername" placeholder="Username" required="required" />
								</div>
								<div class="form-group">
									<input type="password" class="form-control" id="Lpassword"
										name="Lpassword" placeholder="Password" required="required" />
								</div>
								<div class="form-group">
									<button type="button"
										class="btn btn-primary btn-lg btn-block login-btn"
										id="ModalLoginbutton">Login</button>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<a href="#">비밀번호 찾기</a>
						</div>
					</div>
				</div>
			</div>


			<div class="signup">
				<button type="button" class="btn btn-secondary" data-toggle="modal"
					data-target="#myModal">회원가입</button>
			</div>

			<!-- Signin Modal -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog modal-login">
					<div class="modal-content">
						<div class="modal-header">
							<div class="avatar">
								<img
									src="https://www.tutorialrepublic.com/examples/images/avatar.png"
									alt="Avatar" />
							</div>
							<h4 class="modal-title">Member Sign up</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<form name="SignForm" action="">
								<div class="form-group">
									<input type="text" class="form-control" id="Susername"
										name="Susername" placeholder="Username" required="required" />
									<div class="inputcondition" id="UserCondition">8글자 이상의
										영대소문자</div>
									<div class="valid-feedback">Valid.</div>
									<div class="invalid-feedback">Please fill out this field.</div>
								</div>
								<div class="form-group">
									<input type="password" class="form-control" id="Spassword"
										name="Spassword" placeholder="Password" required="required" />
									<div class="inputcondition" id="PWCondition">4글자 이상</div>
									<div class="valid-feedback">Valid.</div>
									<div class="invalid-feedback">Please fill out this field.</div>
								</div>
								<div class="form-group">
									<input type="password" class="form-control" id="Spassword2"
										name="Spassword2" placeholder="Password confirm"
										required="required" />
									<div class="valid-feedback">Valid.</div>
									<div class="invalid-feedback">비밀번호가 같지 않습니다.</div>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" id="Sphone"
										name="Sphone" placeholder="Phone number" required="required" />
									<div class="inputcondition" id="PhoneCondition">
										010-000-0000</div>
									<div class="valid-feedback">Valid.</div>
									<div class="invalid-feedback">Please fill out this field.</div>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" id="Semail"
										name="Semail" placeholder="Email" required="required" />
									<div class="valid-feedback">Valid.</div>
									<div class="invalid-feedback">Please fill out this field.</div>
								</div>
								<div class="form-group">
									<button type="button"
										class="btn btn-primary btn-lg btn-block login-btn"
										id="ModalSignbutton">Sign up</button>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<div id="signTologin">
								<a href="#">이미 회원이십니까?</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>

		<c:if test="${not empty userDto}">
			<div>
				<div class="manage">
					<strong> ${userDto.userName} </strong>님 환영합니다.
					<button type="button" class="btn btn-secondary" id="Managebutton">회원관리</button>
				</div>

				<div class="logout">
					<button type="button" onclick="location.href='/logout'"
						class="btn btn-secondary" id="Logoutbutton">로그아웃</button>
				</div>
			</div>
			<!-- Modal detail-->
			<div class="modal fade" id="userInfoDetailModal">
				<div class="modal-dialog modal-simple">
					<div class="modal-content">
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">회원정보</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<div class="modal-body">

							<div class="example table-responsive">
								<table class="table table-hover">
									<tbody>
										<tr>
											<td>아이디</td>
											<td id="userNameDetail">#</td>
										</tr>
										<tr>
											<td>비밀번호</td>
											<td id="passwordDetail">#</td>
										</tr>
										<tr>
											<td>이메일</td>
											<td id="emailDetail">#</td>
										</tr>
									</tbody>
								</table>
							</div>
							<button type="button" id="btnUserInfoUpdateForm" class="btn btn-sm btn-primary btn-outline"
								data-dismiss="modal">회원정보 수정하기</button>
							<button type="button" id="btnUserInfoUpdateForm2"
								class="btn btn-sm btn-primary btn-outline" data-dismiss="modal">회원정보
								수정하기</button>
							<button type="button" id="btnUserInfoDeleteConfirm" class="btn "
								data-dismiss="modal">탈퇴하기</button>
							<button id="btnUserInfoDeleteConfirm2"
								class="btn btn-sm btn-warning btn-outline" data-dismiss="modal"
								type="button">탈퇴하기</button>

						</div>
					</div>
				</div>
			</div>
			<!-- End Modal -->

			<!-- Modal update-->
			<div class="modal fade" id="UserInfoUpdateModal">
				<div class="modal-dialog modal-simple">
					<form class="modal-content">
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">회원정보 변경</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xl-12 form-group">
									<input id="passwordUpdate" type="text" class="form-control"
										name="passwordupdate" placeholder="비밀번호">
								</div>
								<div class="col-xl-12 form-group">
									<textarea id="emailUpdate" class="form-control" rows="5"
										placeholder="이메일"></textarea>
								</div>
								<div class="col-md-12 float-right">
									<button id="btnUserInfoUpdate"
										class="btn btn-sm btn-primary btn-outline"
										data-dismiss="modal" type="button">수정</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- End Modal -->
		</c:if>
	</div>

</body>
</html>