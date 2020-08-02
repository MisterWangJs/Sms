<%@page import="com.djg.sms.domain.User"%>
<%@page import="com.djg.sms.dao.impl.UserDaoJDBCImpl"%>
<%@page import="com.djg.sms.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
    <link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">
<title>修改用户页面</title>
</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	

<%
	//得到要修改用户的序号
	String id = request.getParameter("id");
	int uid = Integer.parseInt(id);
	
	IUserDao userDao = new UserDaoJDBCImpl();
	
	User user = userDao.findById(uid);
	pageContext.setAttribute("user",user,pageContext.REQUEST_SCOPE);
	
%>

 <div>
        <div class="header">
            <h1 class="page-title" align="center">修改用户</h1>
        </div>         	  
		<div class="well" align="center">
			<form method="post" action="user_modify">
			
			
				<input id="id" type="hidden" name="id" class="input-xlarge" />

				
				<label>用户名</label>
				<input id="username" type="text" name="username" class="input-xlarge"/>
				<label>密码</label>
				<input id="password" type="text" name="password"  class="input-xlarge"/>					
				
				
	
				<br>
				<input class="btn btn-primary" type="submit" value="修改" />
			</form>
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