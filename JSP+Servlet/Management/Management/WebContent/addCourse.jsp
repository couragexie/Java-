<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>添加课程</title>
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
                overflow:auto;
            }
        

        .addInfo {
            margin-top:9px;
            width:250px;
            height:28px;
            font-size: 16px;
        }
        .submit{
            margin-top:16px;
            width:60px;
            height:30px;
            margin-left:68px;
        }

        form{
            margin-top:78px;
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
        <div class="header">
            <h3 class="headline">添加课程</h3>
            <a class="backword" href="TeacherIndex.jsp">点击返回上一页</a>
        </div>
        <div class="main">
            <div class="main-sector">
                <!-- <ul class="option-ul"> -->
                <form action="ModifyServlet?action=addCourse" method="POST"> 
                    <label>课程代号:</label>&nbsp;&nbsp;<input class="addInfo" type="text" name="cid"  placeholder="C20xx" ></br>
                    <label>课程名称:</label>&nbsp;&nbsp;<input class="addInfo" type="text" name="cname" placeholder=""></br>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学分:&nbsp;</label>&nbsp;&nbsp;<input class="addInfo" type="text" name="credit" ></br>      
                    <input class= "submit" type="submit" >
                </form>
                
            </div>

        </div>
    </body>
</html>