
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Index</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

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
       
    </style>
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>


  <body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
 		
<div>
        
        <div class="header">
        
 			
        	
            <h1 class="page-title" align="center">欢迎使用学生信息管理系统</h1>
        </div>
        
        

        <div class="container-fluid">
            <div class="row-fluid">
                    

			<div class="row-fluid">

				<div class="block">
					<a href="#page-stats" class="block-heading" data-toggle="collapse">学生总体统计</a>
					<div id="page-stats" class="block-body collapse in">

						<div class="stat-widget-container">
							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">2,222</p>
									<p class="detail">学生总人数</p>
								</div>
							</div>

							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">1,111</p>
									<p class="detail">男生人数</p>
								</div>
							</div>

							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">1,111</p>
									<p class="detail">女生人数</p>
								</div>
							</div>

							<div class="stat-widget">
								<div class="stat-button">
									<p class="title">999</p>
									<p class="detail">毕业生人数</p>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
               
                 <%
        	String date=new java.util.Date().toLocaleString();
        	%>
			<h3><font size="20px" color="pink">本次登录系统时间是：<%=date %></font></h3>
                    
			<footer>
				<hr>
				
				<p  style="color:white" class="pull-right">My sms <a style="color:white" href="author.jsp" title="Mysms" target="_blank">@Wjs</a></p>

				<p style="color:white" >&copy; 2018 <a style="color:white" href="author.jsp" target="_blank">Design by Wjs</a></p>
			</footer>
                    
            </div>
        </div>
    </div>
  </body>
</html>


