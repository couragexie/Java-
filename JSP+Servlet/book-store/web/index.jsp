<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>购书商城</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="css/index.css" rel="stylesheet">
</head>

<body>

<div class="header">
    <!-- header 中的上部 -->
    <div class="topnav">
        <div class="container">
            <ul>
                <li><a href="backIndex.jsp">上传页面</a></li>
                <li><a href="#">我的评论</a></li>
                <li><a href="#">我的收藏</a></li>
                <c:choose>
                    <c:when test="${userID == null}">
                        <li><a href="register.jsp">成为会员</a></li>
                        <li><a href="login.jsp">登录</a></li>
                    </c:when>

                    <c:otherwise>
                        <li><a id="log_out">退出登录</a></li>
                        <p class="login-success">Hi, <span>${username}</span>&nbsp;Welcome to bookstore</p>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

    <!-- header 的中 -->
    <div class="header-main">
        <div class="container">
            <a href="index.jsp" class="logo">
                <img src="img/logo.png">
            </a>
            <div class="search">

                <input type="search-box" class="search-box">
                <div class="button-box">
                    <i class="search-icon" id="img"></i>
                    <input type="button" class="button">
                </div>
            </div>

            <div class="shopping-car">
                <a href="#" class="shopping-a">
                    <i class="icon"></i>
                    <span class="words">购物车<b id="count">&nbsp0</b></span>
                </a>
            </div>

            <div class="shopping-order">
                <a href="#">我的订单</a>
            </div>

        </div>
    </div>
    <!-- header 的底部 -->
    <div class="header-bottom">
        <div class="container">
            <ul>
                <li id="computer"><a href="#">计算机</a></li>
                <li id="literature"><a href="#">文学</a></li>
                <li id="memoirist"><a href="#">传记</a></liid>
                <li id="ec_ma"><a href="#">经管</a></li>
                <li id="success"><a href="#">成功励志</a></li>
                <li id="history"><a href="#">历史</a></li>
                <li id="religion"><a href="#">宗教哲学</a></li>
                <li id="life"><a href="#">生活</a></li>
            </ul>
        </div>
    </div>

</div>


<div class="main">
    <div class="main-left">
        <ul class="shop-list">
            =
            <%--                <li>--%>
            <%--                    <a class="book-img"><img src="img/计算机/1.jpg"></a>--%>
            <%--                    <div class="book-info">--%>
            <%--                        <label>书名：</label>--%>
            <%--                        <a href="#" class="book-n">深入理解计算机系统(原书第三版)</a><br>--%>
            <%--                        <label>作者：</label>--%>
            <%--                        <span class="author">（美）兰德尔E.布莱恩特（Randal E.Bryant）等</span><br>--%>
            <%--                        <label>出版社：</label>--%>
            <%--                        <span class="press">机械工业出版社</span><br>--%>
            <%--                        <label>简介</label>--%>
            <%--                        <p class="intro">程序员必读经典著作！理解计算机系统*书目，10万程序员共同选择。第二版销售突破100000册，第三版重磅上市！ </p>--%>
            <%--                    </div>--%>
            <%--                    <div class="purchase">--%>
            <%--                        <a class="add-shopping">加入购物车</a>--%>
            <%--                        <a class="collect">收藏</a>--%>
            <%--                    </div>--%>
            <%--                </li>--%>
            <%--                <li>--%>
            <%--                    <a class="book-img"><img src="img/计算机/1.jpg"></a>--%>
            <%--                    <div class="book-info">--%>
            <%--                        <label>书名：</label>--%>
            <%--                        <a href="#" class="book-n">深入理解计算机系统(原书第三版)</a><br>--%>
            <%--                        <label>作者：</label>--%>
            <%--                        <span class="author">（美）兰德尔E.布莱恩特（Randal E.Bryant）等</span><br>--%>
            <%--                        <label>出版社：</label>--%>
            <%--                        <span class="press">机械工业出版社</span><br>--%>
            <%--                        <label>简介</label>--%>
            <%--                        <p class="intro">程序员必读经典著作！理解计算机系统*书目，10万程序员共同选择。第二版销售突破100000册，第三版重磅上市！ </p>--%>
            <%--                    </div>--%>
            <%--                    <div class="purchase">--%>
            <%--                        <a class="add-shopping">加入购物车</a>--%>
            <%--                        <a class="collect">收藏</a>--%>
            <%--                    </div>--%>
            <%--                </li>--%>
        </ul>
    </div>
</div>

<div class="footer"></div>

<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/index.js"></script>
</body>

</html>