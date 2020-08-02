<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录学生管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

	<!-- 自己添加的js代码 -->
	<script type="text/javascript">
		//验证码的更换
		function changeValidateCode() {
			document.getElementById("validateCode").src = "ValidateCodeServlet?rand=" + Math.random();
		}
	</script>
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录学生管理系统</span>    
    <ul>
    <li><a href="./author2.jsp">作者</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    
    
    
    
    </div>
   <!-- --> 
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form  method="post" action="login" >
    <ul>
    <li><input style="color:black" placeholder="输入账号" name="username" type="text" class="loginuser"  onclick="JavaScript:this.value=''"/></li>
    <li><input style="color:black" placeholder="输入密码 " name="password" type="text" class="loginpwd"  onclick="JavaScript:this.value=''"/></li>
    <li><input style="color:black" placeholder="验证码" name="validateCode" type="text" class="loginyzm"  onclick="JavaScript:this.value=''"/> <img id="validateCode" src="./ValidateCodeServlet" title="点击换一换" onclick="changeValidateCode()" CLASS="PULL-RIGHT">
			<a href="javascript:changeValidateCode();">看不清？</a><br><br></li>
    
   
    <li><input type="submit" class="loginbtn" value="登录" />
    <label><a href="register.jsp" target="blank" style="color:grey" >新用户?</a></label><label><a href="reset-password.jsp">忘记密码？</a></label></li>
     ${requestScope.loginError}
   
    </ul>
    </div>
    </form>
    </div>
    
    
    
    <div class="loginbm">版权所有  2018 @Wjs</div>
</body>
</html>