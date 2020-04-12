<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>注册页面</title>
    <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/register.css" rel="stylesheet">
</head>

<body>
<script src="js/jquery-3.4.0.min.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="js/register.js"></script>

<%--    // java 代码--%>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
%>
<script>
    alert("<%=msg%>")
</script>

<%
    }
%>

<%--    form 表单代码--%>
<form class="form-horizontal register" method="POST" action="${pageContext.request.contextPath}/RegisterServlet">
    <div class="register-box">
        <div class="box-top">
            <a href="index.jsp"><img src="img/logo.png"></a>
            <h3>New user registration</h3>

        </div>

        <div class="regi-content">
            <div class="form-group location">
                <label class="col-sm-2 control-label">手机号码</label>
                <input type="number" class="form-control input" placeholder="Telephone" name="telephone">
            </div>
            <div class="form-group location">
                <label class="col-sm-2 control-label">用户名</label>
                <input type="text" class="form-control input" placeholder="Username" name="username">

            </div>
            <div class="form-group location">
                <label class="col-sm-2 control-label">密码</label>
                <input type="password" class="form-control input" placeholder="Password" name="password">
            </div>
            <div class="form-group location">
                <label class="col-sm-2 control-label">确定密码</label>
                <input type="password" class="form-control input" placeholder="Password">
            </div>

            <div class="checkbox">
                <input type="checkbox" id="checked">
                <span>我已阅读并同意 《交易条款》和 《社区条款》</span>
            </div>
            <button type="submit" class="btn btn-default btn-primary" id="regist-b">立即注册</button>
        </div>
    </div>

</form>


</body>

</html>