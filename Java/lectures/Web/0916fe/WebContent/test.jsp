<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");

	out.write("Hello SSAFY || " + fname + " " + lname);
%>
