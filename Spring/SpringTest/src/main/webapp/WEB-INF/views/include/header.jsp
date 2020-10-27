<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
#loginInfo {
	text-align: right;
}

#head {
	text-align: center;
}

.inputtitle {
	display: inline-block;
	width: 100px;
	background: silver;
	text-align: center;
}
</style>
<%-- context에 대한 정보를 session에 저장해둔다. --%>
<c:set var="root" value="${pageContext.request.contextPath }/"
	scope="session"></c:set>
<div id="loginInfo">
	<c:if test="${userinfo == null}">
		<a href="${root }">로그인 해주세요.</a>
	</c:if>
	<c:if test="${userinfo != null}">
				${userinfo.username}님 로그인되었습니다. <a href="${root}/user/logout">로그아웃</a>
	</c:if>
</div>
<h1 id="head">국가별 확진자 현황</h1>
<hr>
