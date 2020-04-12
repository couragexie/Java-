<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.manage.domain.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生成绩管理系统</title>
</head>
<body>
<%
    //Student student = (Student)session.getAttribute("student");
    String sName = (String) session.getAttribute("sName");
    if (sName == null)
        response.sendRedirect("login.jsp");
    StudentInfo studentInfo = (StudentInfo) session.getAttribute("studentInfo");
    List<StudentCourse> scs = (List<StudentCourse>) session.getAttribute("StudentCourses");
    List<Course> chooseC = (List<Course>) session.getAttribute("chooseCourse");
%>

<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/Main.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<!-- <div class="wrapper"> -->
<div class="header">
    <h2 class="headline">学生信息综合管理系统</h2>
</div>
<div class="main">
    <div class="left-section">

        <div class="left-inner-top">
            <img class="head-img" src="images/52873718.png"/> <span><%=sName%><span>你好！
						<a href="LoginServlet?action=logout">退出</a>
        </div>

        <div class="inner-option">
            <ul>
                <li><input class="option" type="radio" name="nav2" id="a1">
                    <label class="op_label" for="a1">个人信息</label>
                    <div class="content">
                        <h3>个人信息</h3>
                        <div class="info">
                            <table border=0 cellpadding="0" cellspacing="0">
                                <tr>
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th>专业</th>
                                    <th>年龄</th>
                                    <th>性别</th>
                                    <th>班级</th>
                                    <th>职位</th>
                                    <th>宿舍</th>
                                    <th>电话</th>
                                    <th>邮箱</th>
                                </tr>
                                <%
                                    if (studentInfo != null) {
                                %>
                                <tr>
                                    <td><%=studentInfo.getsId()%>
                                    </td>
                                    <td><%=studentInfo.getName()%>
                                    </td>
                                    <td><%=studentInfo.getMajor()%>
                                    </td>
                                    <td><%=studentInfo.getAge()%>
                                    </td>
                                    <td><%=studentInfo.getSex()%>
                                    </td>
                                    <td><%=studentInfo.getClass_()%>
                                    </td>
                                    <td><%=studentInfo.getPosition()%>
                                    </td>
                                    <td><%=studentInfo.getDormitory()%>
                                    </td>
                                    <td><%=studentInfo.getPhoneNum()%>
                                    </td>
                                    <td><%=studentInfo.getEmail()%>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>
                        </div>
                    </div>
                </li>
                <li><input class="option" type="radio" name="nav2" id="a3">
                    <label class="op_label" for="a3">修改密码</label>
                    <div class="content">
                        <h3>修改密码</h3>
                        <div class="modifyPW">
                            <form method="POST" name="modifyPw"
                                  action="ModifyServlet?action=modifyPw"
                                  onsubmit="return modifyPw();">
                                <label>新密码</label> <input type="password" id="pw1"
                                                          name="newPassword"></br>
                                <div class="pw2">
                                    <label>再一次输入新密码</label> <input type="password" id="pw2"
                                                                   name="rePassword"></br>
                                </div>
                                <input type="hidden" name="sid"
                                       value="<%if (studentInfo != null) {%><%=studentInfo.getsId()%><%}%>">
                                <input type="submit" value="submit">
                            </form>
                        </div>
                    </div>
                </li>
                <li><input class="option" type="radio" name="nav2" id="a4">
                    <label class="op_label" for="a4">选课信息</label>
                    <div class="content">
                        <h3>选课信息</h3>
                        <div class="table-info">
                            <table border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <th>课程代号</th>
                                    <th>课程名称</th>
                                    <th>学分</th>
                                    <th></th>
                                </tr>
                                <% if (studentInfo != null && chooseC != null && !chooseC.isEmpty()) {
                                    for (Course c : chooseC) {

                                %>
                                <tr>
                                    <td><%=c.getCid() %>
                                    </td>
                                    <td><%=c.getCname() %>
                                    </td>
                                    <td><%=c.getCredit() %>
                                    </td>
                                    <td>
                                        <a href="ChooseCourseServlet?action=choose&cid=<%=c.getCid()%>&sid=<%=studentInfo.getsId() %>">选课</a>
                                    </td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </table>
                        </div>
                    </div>
                </li>
                <li><input class="option" type="radio" name="nav2" id="a5">
                    <label class="op_label" for="a5">课程成绩</label>
                    <div class="content">
                        <h3>课程成绩</h3>
                        <div class="table-info">
                            <table border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <th>课程代号</th>
                                    <th>课程名称</th>
                                    <th>学分</th>
                                    <th>成绩</th>
                                </tr>
                                <% if (scs != null && !scs.isEmpty()) {
                                    for (StudentCourse sc : scs) {
                                        if (sc.getGrade() != 0) {
                                %>
                                <tr>
                                    <td><%=sc.getCid() %>
                                    </td>
                                    <td><%=sc.getCname() %>
                                    </td>
                                    <td><%=sc.getCredit() %>
                                    </td>
                                    <td><%=sc.getGrade() %>
                                    </td>
                                </tr>
                                <%
                                            }
                                        }
                                    }
                                %>
                            </table>
                        </div>
                    </div>
                </li>
                <li><input class="option" type="radio" name="nav2" id="a6">
                    <label class="op_label" for="a6">已选课程</label>
                    <div class="content">
                        <h3>已选课程</h3>
                        <div class="table-info">
                            <table border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <th>课程号</th>
                                    <th>课程名</th>
                                    <th>学分</th>
                                    <th></th>
                                </tr>
                                <% if (scs != null && !scs.isEmpty()) {
                                    for (StudentCourse sc : scs) {
                                        if (sc.getGrade() == 0) {
                                %>
                                <tr>
                                    <td><%=sc.getCid() %>
                                    </td>
                                    <td><%=sc.getCname() %>
                                    </td>
                                    <td><%=sc.getCredit() %>
                                    </td>
                                    <td>
                                        <a href="ChooseCourseServlet?action=giveup&cid=<%=sc.getCid()%>&sid=<%=studentInfo.getsId() %>">弃选</a>
                                    </td>
                                </tr>
                                <%
                                            }
                                        }
                                    }
                                %>
                            </table>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>

    <div class="right-section"></div>
</div>
<!-- <div class="footer"></div> -->
<!-- </div> -->
</body>
</html>