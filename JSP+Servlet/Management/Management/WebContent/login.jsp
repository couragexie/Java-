<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String inumber = "";
    String password = "";

    //System.out.println("num " + inumber +" pw " + password);
%>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<div id="login">
    <h1>欢迎登录</h1>
    <form action="LoginServlet?action=login" method="post">
        <!-- required表示该字段必填 -->
        <p>
            <input class="input" type="text" placeholder="账号"
                   required="required" name="inumber" value="<%=inumber%>"/>
        </p>
        <p>
            <input class="input" type="password" placeholder="密码"
                   required="required" name="password" value="<%=password%>"/>
        </p>
        <p>
            <label>选择登录身份：</label> <select name="identity">
            <option value="student">学生</option>
            <option value="teacher">教师</option>
            <option value="admin">管理员</option>
        </select>
        </p>
        <p>
            <input type="checkbox" name="isUseCookie"/>记住密码(非本人电脑请勿勾选)
        </p>
        <p id="button">
            <button type="submit">登录</button>
        </p>
    </form>
</div>

</body>
</html>