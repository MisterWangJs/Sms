package com.djg.sms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.djg.sms.dao.IUserDao;
import com.djg.sms.dao.impl.UserDaoJDBCImpl;
import com.djg.sms.domain.User;

@WebServlet("/main/user_modify")
public class UserModifyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置请求编码
		//request.setCharacterEncoding("utf-8");
		
		//2.获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password1 =request.getParameter("password1");
		String password2 =request.getParameter("password2");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password1);
		
		
		//String validateCode2 = (String)session.getAttribute("SESSION_VALIDATECODE");
				
				
		//4.使用IUserDao的方法，去db中查询登录用户的信息
		IUserDao userDao = new UserDaoJDBCImpl();
		User user2 = userDao.findByName(username);
				
		//5.跳转逻辑:如果用户信息合法，则跳转到后台主页面main.jsp;否则，跳转到登录页面login.jsp
		boolean flag = false;
		StringBuffer error_msg = new StringBuffer();
				
		//如果输入的用户名在DB中不存在
		if(user2 == null){
			error_msg.append("用户名不正确！");
		}else if(!user2.getPassword().equals(password)){
			error_msg.append("密码不正确！");
		}else if(user2.getPassword().equals(password1)){
			error_msg.append("新旧密码不可相同！");
		}else if(!password1.equals(password2)){
			error_msg.append("两次密码不相同！");
		}
		else{
			flag = true;
		}
		HttpSession session = request.getSession();	
		if(flag){
			
			IUserDao userDao1=new UserDaoJDBCImpl();
			userDao1.modify(user, username);
			
			request.setAttribute("opMsg", "修改信息成功！");
			request.setAttribute("user", user);
			//session.setAttribute("user", user);
			
			//response.sendRedirect("seeuser.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./seeuser.jsp");
			dispatcher.forward(request, response);
		}else{
			//把具体错误信息存储到requestScope,之后请求转发到登录页面login.jsp
			request.setAttribute("error", error_msg);
			//response.sendRedirect("admin_modify.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./modify_user.jsp");
			dispatcher.forward(request, response);
		}		
	
	}
}
