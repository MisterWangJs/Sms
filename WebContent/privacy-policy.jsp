<%@page import="com.djg.sms.util.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.djg.sms.dao.IStudentDao"%>
<%@page import="com.djg.sms.dao.impl.StudentDaoJDBCImpl"%>
<%@page import="com.djg.sms.domain.Student"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.header {
color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人权利</title>
</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	
 		 <div class="header">
            <h1 class="page-title" align="center">版权所有，违者必究</h1>
             
        </div>
        
        
        <a href="register.jsp"><button><h1>返回</h1></button></a>
</body>
</html>