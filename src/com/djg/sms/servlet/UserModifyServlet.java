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
		//1.�����������
		//request.setCharacterEncoding("utf-8");
		
		//2.��ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password1 =request.getParameter("password1");
		String password2 =request.getParameter("password2");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password1);
		
		
		//String validateCode2 = (String)session.getAttribute("SESSION_VALIDATECODE");
				
				
		//4.ʹ��IUserDao�ķ�����ȥdb�в�ѯ��¼�û�����Ϣ
		IUserDao userDao = new UserDaoJDBCImpl();
		User user2 = userDao.findByName(username);
				
		//5.��ת�߼�:����û���Ϣ�Ϸ�������ת����̨��ҳ��main.jsp;������ת����¼ҳ��login.jsp
		boolean flag = false;
		StringBuffer error_msg = new StringBuffer();
				
		//���������û�����DB�в�����
		if(user2 == null){
			error_msg.append("�û�������ȷ��");
		}else if(!user2.getPassword().equals(password)){
			error_msg.append("���벻��ȷ��");
		}else if(user2.getPassword().equals(password1)){
			error_msg.append("�¾����벻����ͬ��");
		}else if(!password1.equals(password2)){
			error_msg.append("�������벻��ͬ��");
		}
		else{
			flag = true;
		}
		HttpSession session = request.getSession();	
		if(flag){
			
			IUserDao userDao1=new UserDaoJDBCImpl();
			userDao1.modify(user, username);
			
			request.setAttribute("opMsg", "�޸���Ϣ�ɹ���");
			request.setAttribute("user", user);
			//session.setAttribute("user", user);
			
			//response.sendRedirect("seeuser.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./seeuser.jsp");
			dispatcher.forward(request, response);
		}else{
			//�Ѿ��������Ϣ�洢��requestScope,֮������ת������¼ҳ��login.jsp
			request.setAttribute("error", error_msg);
			//response.sendRedirect("admin_modify.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./modify_user.jsp");
			dispatcher.forward(request, response);
		}		
	
	}
}
