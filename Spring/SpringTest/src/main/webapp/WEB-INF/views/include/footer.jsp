<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:set var="root" value="${pageContext.request.contextPath }/"
	scope="session"></c:set>

<c:if test="${userinfo == null}">
	<a href="#">홈으로</a>
</c:if>
<c:if test="${userinfo != null}">
	<a href="">홈으로2</a>
</c:if>
<a href="#">국가별 확진자 등록</a>
<a href="${root}/regist/list" id="showList">목록 보기</a>
