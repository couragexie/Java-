<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="${pageContext.request.contextPath }/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap-3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath }/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet">

    <!-- Bootstrap CSS -->

</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
%>
<script type="text/javascript" charset="UTF-8">
    alert("<%=msg%>");
</script>
<%
    }
%>


<form class="login" method="POST" action="${pageContext.request.contextPath}/adlogin">
    <div class="login-box">
        <div class="logo">
            <a href="../index.jsp"><img src="${pageContext.request.contextPath }/img/logo.png"></a>
        </div>

        <span class="words">管理员登录</span>

        <div class="form-group">
            <label class="sr-only">Username</label>
            <input type="text" class="form-control input" placeholder="Username" name="username" value="${username}">
        </div>
        <div class="form-group">
            <label class="sr-only">Password</label>
            <input type="password" class="form-control input" placeholder="Password" name="password">
        </div>
        <div class="checkbox">
            <input type="checkbox"><span>Remember me</span>
        </div>
        <button type="submit" class="btn btn-default btn-primary">Submit</button>
    </div>
</form>

</body>
</html>