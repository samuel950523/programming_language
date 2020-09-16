<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

out.write("done");
%>