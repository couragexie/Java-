<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.manage.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
     <title>查看课程</title>
    </head>
    <body>
    <link rel="stylesheet" type="text/css" href="css/main.css">
        <style>
                  
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
            .option-ul{
                position: absolute;
                top:30px;
                left:98px;
                margin:0 auto;
                /* background-color:blueviolet; */
            }
            .option-ul li{
                height:52px;
                border-bottom: 1px solid #c0c0c0;
                text-align: center;
                line-height: 62px;
            }
        
       table th,td{ background:#FFF;
            border-width: 1px;
        	padding: 8px;
	        border-style: solid;
	        border-color: #a9c6c9;

        } 
        .table-d{
            /* margin:0 auto; */
             margin-left:288px;
            margin-top:28px; 
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
        	List<Course> cs = (List<Course>)session.getAttribute("courses");
        %>
        
        <div class="header">
            <h3 class="headline">查看课程</h3>
            <a class="backword" href="TeacherIndex.jsp">点击返回上一页</a>
        </div>
        <div class="main">
            <div class="main-sector">
                <!-- <ul class="option-ul"> -->
                    
                <div class="table-d">
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <th>课程代号</th>
                        <th>课程名</th>
                        <th>学分</th>
                       
                        <th></th>
                    </tr>
                    <% if(cs != null && !cs.isEmpty()){
                    	for(Course c:cs){
                 		
                    	%>
                    <tr>
                        <td><%=c.getCid() %></td>
                        <td><%=c.getCname() %></td>
                        <td><%=c.getCredit() %></td>
                        <td><a href="ModifyServlet?action=delCourse&cid=<%=c.getCid()%>">删除</a></td>
                    </tr>
                    <%}} %>
                </table>
                </div>
            </div>

        </div>
    </body>
</html>