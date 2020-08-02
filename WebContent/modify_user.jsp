<%@page import="com.djg.sms.domain.User"%>
<%@page import="com.djg.sms.dao.impl.UserDaoJDBCImpl"%>
<%@page import="com.djg.sms.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>学生信息管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>


	

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

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
 
  
  
  <body class="" style="background: url(images/111_jpg_002.jpg)"> 
  <!--<![endif]-->
    
    
    <%
		//1.设置请求参数的编码
		//request.setCharacterEncoding("utf-8");
		
		//2.获取请求参数
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		
		//3.借助DAO完成删除学生记录操作
		IUserDao  userDao =  new UserDaoJDBCImpl();
		User user = userDao.findByName(username);
		
	%>
    
    
    <div>
        
        <div class="header">
            <h1 class="page-title" align="center">管理员信息修改</h1>
        </div>
               
        <div class="container-fluid">
            <div class="row-fluid">
              
			  
		<!--
		<div class="btn-toolbar">
			<button class="btn btn-primary"><i class="icon-save"></i> Save</button>
			<a href="#myModal" data-toggle="modal" class="btn">Delete</a>
		</div>
		-->
	
		
			<form id="form1" name="form1" method="post" action="./user_modify">
			<div align="center">
	    	<table border="0" cellspacing="0" font-size="10">
	       		<label align="center">${requestScope.error}</label>
	      		<tr height="7px"></tr>
	      		<tr>
	        		<td align="right">用户名</td>
	        		<td >
	          			<input type="text"  name="username" />
	          		</td>
	      		</tr>
	      		<tr height="7px"></tr>
	      		<tr>
	        		<td align="right">旧密码</td>
	        		<td>
	          			<input type="text" name="password"  />
	         		</td>
	      		</tr>
	      		<tr height="7px"></tr>
	      		<tr>
	        		<td align="right">新密码</td>
	        		<td>
	          			<input type="text" name="password1" onkeyup="check()" />
	         		</td>
	      		</tr>
	      		<tr height="7px"></tr>
	      		<tr>
	        		<td align="right">确认密码</td>
	        		<td>
	          			<input type="text" name="password2" onkeyup="check()" />
	         		</td>
	      		</tr>
	      		<tr height="7px"></tr>
	      		<tr >
	        		<td colspan="2" align="center">
	        			<div >
	          				<input type="submit" style="font-size:15px" class="btn btn-primary pull-right" name="Submit" value="修改信息" />
	        			</div>
	        		</td>
	      		</tr>
	      	</table>
	  	</div>
	</form>
	
	
			
		<footer>
			<hr>
			<p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
			<p>&copy; 2018 <a href="#" target="_blank">Portnine</a></p>
		</footer>
		
            </div>
        </div>
    </div>
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


