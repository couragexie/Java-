<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改成功</title>
</head>
<body>
<% 
	String msg = (String)session.getAttribute("msg"); 
	String path = (String) session.getAttribute("path");
	
%>
<% if(msg!=null){ %>
<h3><%=msg %></h3>
<a href = "<%=path %>">点击返回！</a>
<%}else{ %>
	<a href="login.jsp">出错啦！！！</a>
<%} %>
</body>
</html>