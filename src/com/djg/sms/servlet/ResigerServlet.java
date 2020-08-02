package com.djg.sms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import com.djg.sms.dao.IUserDao;
import com.djg.sms.dao.impl.UserDaoJDBCImpl;
import com.djg.sms.domain.User;

@WebServlet("/register")
public class ResigerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.������������ı���
		//request.setCharacterEncoding("utf8");
		//2.�õ��������
		/*String newname = request.getParameter("newname");
		String newemail = request.getParameter("newemail");
		String newusername = request.getParameter("newusername");
		String newuserpwd = request.getParameter("newuserpwd");
	
	
		//3.����ʵ�����		
		User nuse = new User();
		nuse.setNewname(newname);
		nuse.setNewemail(newemail);
		nuse.setNewusername(newusername);
		nuse.setNewuserpwd(newuserpwd);
		*/
		//1.�����������
		//request.setCharacterEncoding("utf-8");
		
		//2.��ȡ�������:username,password,validateCode
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		int i = 0;
		/*
		//3.����ʵ�����
		User user = new User();
		
		
		
		
		//4.��װʵ�����
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setSex(sex);
		user.setEmail(email);
		user.setTel(tel);*/
			
		
		//5.����DAO��ʵ�������ӵ�DB��
		IUserDao  userDao =  new UserDaoJDBCImpl();
		
		
		User u =null;
		try{
			u = userDao.findByName(username);
			
			if(!"".equals(u.getUsername())){
				request.setAttribute("adduserError", "�û���" + username + "�Ѵ���");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			
		}catch(NullPointerException e){
			u = new User();
			
			u.setUsername(username);
			u.setPassword(password);
			u.setName(name);
			u.setSex(sex);
			u.setEmail(email);
			u.setTel(tel);
			
			 i = userDao.add(u);
				
				//6.ͨ������ת�� ����ת�� �����ɹ���Ϣ��ʾҳ��		
				//request.setAttribute("opMsg", "����û��ɹ���");	
				
				if(i == 1){
				
					response.sendRedirect("./UserRegSuccess.jsp");
				}	
			
		}
		
		
		
		
	}
}
