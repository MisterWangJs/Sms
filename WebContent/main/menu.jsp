<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
    <title>菜单页面</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<script language="javascript"></script>
    <link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
    <link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">

    <script src="../lib/jquery-1.7.2.min.js" type="text/javascript"></script>

	
    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
        .sidebar-nav .nav-list  > li > a:hover {
 			 background:pink;
 			 color:red;
		}
        .sidebar-nav .nav-list  > li > a:focus {
  			background: red;
  			color:white;
		}
		.sidebar-nav .nav-list  > li > a:active {
 			 background: black;
		}
    </style>

    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
	
	
	
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<div class="sidebar-nav">
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-heart"></i>学生管理</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="./stu_list" target="content" autofoucus>浏览学生</a></li>
			<li><a href="./addStu.jsp" target="content">添加学生</a></li>
			<li><a href="./data2xls.jsp" target="content">导入数据</a></li>
			<li><a href="./data2excel.jsp" target="content">导出数据</a></li>
		</ul>
		
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-plane"></i>用户管理</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="./user_list" target="content" >浏览用户</a></li>
			<li><a href="http://localhost:8080/sms_0.1/register.jsp" target="blank">添加用户</a></li>
		</ul>
		
		<a href="#" class="nav-header" ><i class="icon-question-sign"></i>系统帮助</a>
	</div>
	
	<script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>