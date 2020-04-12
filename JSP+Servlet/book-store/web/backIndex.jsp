<%--
  Created by IntelliJ IDEA.
  User: xj138
  Date: 2019/5/2
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <!-- Bootstrap CSS -->
    <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/backIndex.css" rel="stylesheet">
</head>
<body>
<script src="js/jquery-3.4.0.min.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>

<script src="js/backIndex.js"></script>


<%
    String username = (String) session.getAttribute("adUsername");

    if (username == null) {
%>
<script>
    alert("你还没有登录，请先登录");
    <%response.sendRedirect("backLogin.jsp");%>
</script>

<%


    }
%>

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


<div class="header">
    <nav class="top navbar navbar-default ">
        <div class=" container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="nav_logoBox ">
                <a href="#">
                    <img src="img/logo.png" class="logo">
                </a>
                <h3 class="words">欢迎到来购书商城后台管理系统</h3>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="nav-box collapse navbar-collapse" id="bs-example-navbar-collapse-1 ">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp">首页</a></li>
                    <!-- <li><a href="#"></a></li> -->
                    <li><a href="#" id="logOut">退出管理</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->

        </div><!-- /.container-fluid -->
    </nav>
</div>


<div class="main">
    <div class="aside-left">
        <div class="box"></div>
        <ul>
            <li><a>添加图书</a></li>
            <li><a>查看图书</a></li>
            <li><a>修改图书</a></li>

        </ul>

    </div>

    <div class="section">
        <div class="headline"><p>添加图书</p></div>
        <hr>
        <div class="content">
            <form class="form-inline" method="post" action="${pageContext.request.contextPath}/StoreBookServlet"
                  enctype="multipart/form-data">
                <!-- 图片上传 -->
                <div class="showImg">
                    <a class=" thumbnail book_img" href="#">
                        <img src="" alt="..." id="bookImg">
                    </a>
                    <div class="uploads" id="uploads">
                                <span>点击上传<br>
                                    <i class="glyphicon glyphicon-plus"></i>
                                </span>

                        <input type='file' id="file" class="filepath" name="picture">
                    </div>

                </div>


                <!-- 书籍添加信息处 -->
                <div class="info">
                    <div class="form-group">
                        <label class='exampleInputName2'>书名&nbsp;：</label>
                        <input type="text" class="form-control input" name="bookName" placeholder="请输入书名">
                    </div>
                    <br>
                    <div class="form-group">
                        <label class='exampleInputName2'>价格&nbsp;：</label>
                        <input type="text" class="form-control input" name="price" placeholder="请输入书名">
                    </div>
                    <br>
                    <div class="form-group">
                        <label class='exampleInputName2'>作者&nbsp;：</label>
                        <input type="text" class="form-control input" name="author" placeholder="请输入作者">
                    </div>
                    <br>
                    <div class="form-group">
                        <label class='exampleInputName2'>出版社:</label>
                        <input type="text" class="form-control input" name="press" placeholder="请输入出版社">
                    </div>

                </div>
                <label class='classify_words'>分类:</label>
                <select class="choice form-control" name="classifyID">
                    <option selected="selected">=请选择=</option>
                    <option value="1">计算机</option>
                    <option value="2">文学</option>
                    <option value="3">传记</option>
                    <option value="4">经管</option>
                    <option value="5">成功励志</option>
                    <option value="6">历史</option>
                    <option value="7">宗教哲学</option>
                    <option value="8">生活</option>
                    <option value="9">电子书</option>
                </select>
                <div>
                    <textarea class="intro form-control " name="intro" placeholder="请输入书籍简介"></textarea>
                </div>
                <button type="submit" id="submit" class="btn btn-primary">提交</button>
            </form>
        </div>
    </div>


    <div class=""></div>
</div>

<div class="footer"></div>


</body>
</html>