<%@page import="com.djg.sms.domain.User"%>
<%@page import="com.djg.sms.util.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
    <title>列表页面</title>
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
        
        .pagination ul li a:hover{
			background-color:pink;
			color:red;
		}
        
        .pagination ul li a:active{
			background-color:red;
			color:white;
		}
         .pagination ul li a:focus{
			background-color:red;
			color:white;
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
            <h1 class="page-title" align="center">用户列表</h1>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="./addUser.jsp"><button class="btn btn-primary"><i class="icon-plus"></i>添加用户</button></a>
    
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>序号</th>
          <th>账号</th>
          <th>密码</th>
          <th>姓名</th>
          <th>性别</th>
          <th>邮箱</th>
          <th>电话</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      	
      <c:forEach var="user" items="${requestScope.pageBean.list}">
        <tr>
          <td>${user.id }</td>
          <td>${user.username }</td>
          <td>${user.password }</td>
          <td>${user.name }</td>
          <td>${user.sex }</td>
          <td>${user.email }</td>
          <td>${user.tel }</td>
          <td>
              <a href="./modify_user.jsp?id=${user.id }"><i class="icon-pencil"></i></a>
             <a href="user_delete?id=${user.id }" onClick="return confirm('真的要删除该用户吗?')" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
</div>   
		
<div onclick="style"  class="pagination" align="center">
    <ul>
        <li><a href="user_list?pageIndex=1">首页</a></li>
        
      <%
      	PageBean<User> pageBean = (PageBean<User>)request.getAttribute("pageBean");
      	for(int i = 1;i <= pageBean.getPageCount(); i++){
      %>
        
        <li><a href="user_list?pageIndex=<%=i %>"><%=i %></a></li>
        
       <%
       	}// end of for
       %>
        <li><a href="user_list?pageIndex=<%=pageBean.getPageCount() %>">尾页</a></li>
    </ul>
</div>

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