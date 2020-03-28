<%@page import="com.zq.javaweb.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Person per = new Person();
		System.out.println(per.getInfo());
	
	%>

</body>
</html>