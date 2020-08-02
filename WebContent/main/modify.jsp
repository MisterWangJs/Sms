<%@page import="com.djg.sms.domain.Student"%>
<%@page import="com.djg.sms.dao.impl.StudentDaoJDBCImpl"%>
<%@page import="com.djg.sms.dao.IStudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
    <link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">
<title>修改学生页面</title>
</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	

<%
	//得到要修改学生的学号
	String sId = request.getParameter("id");
	int sNo = Integer.parseInt(sId);
	
	IStudentDao stuDao = new StudentDaoJDBCImpl();
	
	Student s = stuDao.findById(sNo);
	pageContext.setAttribute("s",s,pageContext.REQUEST_SCOPE);
	
%>

 <div>
        <div class="header">
            <h1 class="page-title" align="center">修改学生</h1>
        </div>         	  
		<div class="well" align="center">
			<form id="tab" method="post" action="stu_modify">
			
				<input type="hidden" name="id" class="input-xlarge" value="<%=s.getSno()%>"/>
			
				<label>姓名</label>
				<input type="text" name="name" class="input-xlarge" value="<%=s.getName()%>"/>
				<label>班级</label>
				<input type="text" name="myclass"  class="input-xlarge" value="<%=s.getMyclass() %>"/>
				<label>成绩</label>
				<input type="text" name="score"  class="input-xlarge" value="<%=s.getScore() %>"/>
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