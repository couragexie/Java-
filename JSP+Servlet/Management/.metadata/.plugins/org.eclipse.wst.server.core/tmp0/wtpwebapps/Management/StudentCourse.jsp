<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.manage.domain.*" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>成绩打分</title>
</head>
<body>
<script src="js/jquery-3.4.0.min.js"></script>
<script>
    $(function () {
        $("#submit").click(function () {
            var grade = $("#grade").val();
            var href_ = $("#submit").attr("href");
            $.trim(grade);
            var href_all = href_ + grade
            $("#submit").attr("href", href_all);
        })
    })
</script>
<style>
    html {
        margin: 0;
        width: 100%;
        height: 100%;
    }

    body {
        margin: 0
    }

    a {
        text-decoration: none;
    }

    li {
        list-style-type: none;
    }

    .header {
        width: 100%;
        height: 90px;
        border: 1px solid #cccccc;
        /* margin:auto 0; */
        background-color: #c8e4f0;
        text-align: center;
    }

    .header .headline {
        margin-right: 62px;
        margin-left: 70px;
        margin-top: 36px;
        font-size: 28px;
    }

    .main {
        width: 100%;
        height: 470px;
        background-color: whitesmoke;
        margin-top: 2px;

    }

    .main-sector {
        width: 888px;
        height: 470px;
        margin: 0 auto;
        background-color: #fff;
        text-align: center;
        border: 1px solid #c0c0c0;
        position: relative;

    }

    .option-ul {
        position: absolute;
        top: 30px;
        left: 98px;
        margin: 0 auto;
        /* background-color:blueviolet; */
    }

    .option-ul li {
        height: 52px;
        border-bottom: 1px solid #c0c0c0;
        text-align: center;
        line-height: 62px;
    }

    table th, td {
        background: #FFF;
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;

    }

    .table-d {
        /* margin:0 auto; */
        margin-left: 105px;
        margin-top: 28px;
    }

    .backword {
        /* float:right; */
        margin-right: 50px;
        position: absolute;
        top: 68px;
        right: 138px;
    }

    .grade {
        width: 100%;
        border: none;
        text-align: center;
    }

    /* .a-botton{
        position: absolute;
        bottom: 10px;
        right:188px;
    }
    button{
        width: 75px; height: 35px; font-size: 16px;
    } */
    /*
    css注释：设置table背景为红色，td背景为白色 */

</style>

<%
    List<StudentCourse> scs = (List<StudentCourse>) session.getAttribute("studentCourse");
    List<StudentInfo> sInfos = (List<StudentInfo>) session.getAttribute("students");
    if (scs != null && sInfos != null)
        for (StudentCourse sc : scs) {
            for (StudentInfo sInfo : sInfos) {
                if (sc.getSid().equals(sInfo.getsId()))
                    sc.setSname(sInfo.getName());
            }
        }
    else {
%>
<h3>sc3 == 0 sInfo ==0</h3>
<% } %>

<div class="header">
    <h3 class="headline">成绩打分</h3>
    <a class="backword" href="TeacherIndex.jsp">点击返回上一页</a>
</div>
<div class="main">
    <div class="main-sector">
        <!-- <ul class="option-ul"> -->

        <div class="table-d">
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>课程代号</th>
                    <th>课程名</th>
                    <th>学分</th>
                    <th>成绩</th>
                    <th></th>
                </tr>
                <%
                    if (scs != null) {
                        for (StudentCourse sc : scs) {
                            if (sc.getGrade() == 0) {
                %>
                <tr>
                    <td><%=sc.getSid() %>
                    </td>
                    <td><%=sc.getSname() %>
                    </td>
                    <td><%=sc.getCid() %>
                    </td>
                    <td><%=sc.getCname() %>
                    </td>
                    <td><%=sc.getCredit() %>
                    </td>
                    <td><input id="grade" type="text" name="grade" class="grade" value=""></td>
                    <td><a id="submit"
                           href="ModifyServlet?action=modifyGrade&cid=<%=sc.getCid()%>&sid=<%=sc.getSid()%>&grade=">修改</a>
                    </td>
                    <!-- <a class="a-botton" href="#"><button >提交</button></a> -->
                </tr>
                <%
                            }
                        }
                    }
                %>
            </table>
        </div>
    </div>

</div>
</body>
</html>