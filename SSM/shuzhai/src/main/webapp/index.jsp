<%--
  Created by IntelliJ IDEA.
  User: xj138
  Date: 2019/9/29
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>

<script src="jquery-3.4.0.min.js">
</script>

<script>
    $(function () {

        $("#getUserID").click(function () {
            alert("点击啦啦啦 + " + $("#telephone").val() + " 密码" + $("#password").val());
            $.ajax({
                url: "user/login",
                method: "GET",
                dataType: "json",
                data: {
                    "telephone": $("#telephone").val(),
                    "password": $("#password").val()
                },
                success: function (rec) {
                    alert("收到消息啦");
                    $("#showID").textContent = rec;
                }

            });
        })


        // $("#getUserInfo").click(function(){
        //     $.ajax({
        //         url:"userInfo",
        //         method:"GET",
        //         dataType:"json",
        //         data{
        //             "p"
        //         }
        //     })

        $("#modifiedUser").click(function () {
            var json = {
                "username": $("#username").val(),
                "age": $("#age").val(),
                "sex": $("#sex").val(),
                "region": $("#region").val(),
                "intro": $("#intro").val()
            };
            var jsonStr = JSON.stringify(json);
            alert(jsonStr);
            $.ajax({
                url: "userinfos/userinfo/modified",
                type: "POST",
                dataType: "json",
                contentType: "application/json",
                data: {
                    "userid": "1",
                    "userInfo": json
                },
                success: function (rec) {

                    console.log(rec);
                }
            })

        })


    })


</script>


<%--<h3>用户登录测试模块</h3>--%>
<%--<input type="text" id="showID">--%>
<%--账号：<input  type="text" name="telephone" id="telephone">--%>
<%--密码：<input type="password" name="password" id="password">--%>
<%--<input type="button" id="getUserID">--%>

<%--<h3>图书发布</h3>--%>
<%--<form method="POST" action="${pageContext.request.contextPath}/books" enctype="multipart/form-data">--%>
<%--    书名： <input type="text" name="bookName" /><br/>--%>
<%--    介绍： <input type="text" name="bookIntro"/><br/>s--%>
<%--    发布地点: <input type="text" name="pubRegion"/><br/>--%>
<%--    价格: <input type="text" name="price"/><br/>--%>
<%--    分类: <input type="text" name="category"/><br/>--%>
<%--    交易方式: <input type="text" name="tradingWay"/><br/>--%>

<%--    <input type="file" name="picture"/><br/>--%>
<%--    <input type="file" name="picture"/><br/>--%>
<%--    <input type="file" name="picture"/><br/>--%>
<%--    <input type="file" name="picture"/><br/>--%>
<%--    <input type="file" name="picture"/><br/>--%>
<%--    <input type="file" name="picture"/><br/>--%>

<%--    <input type="submit"/>--%>
<%--</form>--%>


<%--<h3>再测试测试更新啦1112222--%>
<%--</h3>--%>

<h3>用户信息修改模块</h3>

用户名：<input type="text" name="username" id="username"/><br/>
年龄：<input type="text" name="age" id="age"/><br/>
性别：<input type="text" name="sex" id="sex"/><br/>
简介：<input type="text" name="intro" id="intro"/><br/>
地区：<input type="text" name="region" id="region"/><br/>
<input type="button" id="modifiedUser"/>


<h3>用户上传图片</h3>
<form action="${pageContext.request.contextPath}/userinfo/picture" method="POST" enctype="multipart/form-data">
    <input name="_method" value="put"/>
    <input type="hidden" name="userId" value="1">
    <input type="file" name="userPicture"/>
    <input type="submit"/>
</form>
</body>
</html>
