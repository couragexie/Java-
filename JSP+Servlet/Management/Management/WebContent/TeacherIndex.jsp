<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.manage.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>教师管理管理页面</title>
</head>
<body>
<%
	Teacher teacher = (Teacher)session.getAttribute("teacher");
	if(teacher == null)
		response.sendRedirect("login.jsp");
%>


	<link rel="stylesheet" type="text/css" href="css/main.css">
	<style>
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
	width: 370px;
	height: 370px;
	margin: 0 auto;
	background-color: #fff;
	text-align: center;
	border: 1px solid #c0c0c0;
	position: relative;
}

.option-ul {
	position: absolute;
	top: 88px;
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

.option-ul li:hover {
	background-color: khaki;
}

.teacherInfo {
	height: 78px;
	border-bottom: 1px solid #c0c0cc;
}

.teacherInfo div {
	padding-top: 48px;
}

.teacherInfo a:hover {
	background-color: khaki;
}
</style>
	<div class="header">
		<h3 class="headline">教师管理系统</h3>
	</div>
	<div class="main">
		<div class="main-sector">
			<div class="teacherInfo">
				<div>
					<%if(teacher!=null){%><%=teacher.getName() %><%} %>老师，你好！<a href="LoginServlet?action=logout">退出</a>
				</div>

			</div>
			<ul class="option-ul">
				<a href="StudentInfo.jsp"><li>查看学生信息</li></a>
				<!-- <li><a href="">修改学生信息</a href=""></li> -->
				<a href="addCourse.jsp"><li>添加课程</li></a>
				<a href="Courses.jsp"><li>查看课程</l href=""i></a>
				<a href="StudentCourse.jsp"><li>成绩打分</l href=""i></a>
			</ul>
		</div>

	</div>
</body>
</body>
</html>