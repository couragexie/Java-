<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.manage.domain.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>修改学生信息</title>
    </head>
    <body>
        <style>
             html{
                margin:0;
                width:100%;
                height:100%;
            }
            body{
                margin:0
            }
            a{
                text-decoration: none;
            }
            li {
                list-style-type: none;
            }
            
            .header{
                width: 100%; 
                height:90px; 
                border: 1px solid #cccccc;
                /* margin:auto 0; */
                background-color:#c8e4f0;
                text-align: center;
            }
            .header .headline{
                margin-right:62px;
                margin-left: 70px;
                margin-top:36px;
                font-size: 28px;
            }
            .main{
                width:100%;
                height:470px;
                background-color:whitesmoke; 
                margin-top:2px;
                
            }
            .main-sector{
                width:888px;
                height:470px;
                margin:0 auto;
                background-color:#fff;
                text-align: center;
                border: 1px solid #c0c0c0;
                position:relative;
                
            }
    
        .fixInfo {
            margin-top:9px;
            width:250px;
            height:28px;
            font-size: 16px;
        }
        .submit{
            margin-top:10px;
            width:60px;
            height:30px;
        }
        .backword{
            /* float:right; */
            margin-right: 50px;
            position: absolute;
            top:68px;
            right:138px;
        }
/* 
css注释：设置table背景为红色，td背景为白色 */ 
        </style>
        <%
        
        	String sid = request.getParameter("sid");
        	List<StudentInfo> sInfos = (List<StudentInfo>)session.getAttribute("students");
        	StudentInfo sInfo = null;
        	if(sid != null && sInfos != null){
        		for(StudentInfo s : sInfos){
        			if(s.getsId().equals(sid))
        				sInfo = s;
        		}
        		
        	}
        
        %>
        
        <div class="header">
            <h3 class="headline">修改信息</h3>
            <a class="backword" href="StudentInfo.jsp">点击返回上一页</a>
        </div>
        <div class="main">
            <div class="main-sector">
                <!-- <ul class="option-ul"> -->
                <form action="ModifyServlet?action=modifyInfo" method="POST"> 
                <% if(sInfo != null){ %>
                    <label>学号:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="sid" value="<%=sInfo.getsId()%>"  disabled="disabled"></br>
                    <label>姓名:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="name" value="<%=sInfo.getName() %>"></br>
                    <label>专业:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="major" value="<%=sInfo.getMajor() %>"></br>
                    <label>年龄:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="age" value="<%=sInfo.getAge() %>"></br>
                    <label>性别:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="sex" value="<%=sInfo.getSex() %>"></br>
                    <label>班级:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="class_" value="<%=sInfo.getClass_() %>"></br>
                    <label>职位:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="position" value="<%=sInfo.getPosition() %>"></br>
                    <label>宿舍:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="dormitory" value="<%=sInfo.getDormitory() %>"></br>
                    <label>电话:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="phoneNum" value="<%=sInfo.getPhoneNum() %>"></br>
                    <label>邮箱:</label>&nbsp;&nbsp;<input class="fixInfo" type="text" name="email" value="<%=sInfo.getEmail() %>"> </br>       
                    
                    <input class= "submit" type="submit" >
                <%}else{
                %>
                <h3>系统出错！无数据加载！</h3>
                <%} %>
                </form>
                
            </div>

        </div>
    </body>
</html>