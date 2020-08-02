package com.djg.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.djg.sms.dao.IUserDao;
import com.djg.sms.dao.impl.UserDaoJDBCImpl;
import com.djg.sms.domain.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.������������ı���
		//request.setCharacterEncoding("utf8");
		//2.�õ��������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String validateCode = request.getParameter("validateCode");
		
		//3.����IUserDao���в�ѯ
		IUserDao userDao = new UserDaoJDBCImpl();
		User loginUser = userDao.findByName(username);
		
		//4.����û�������
		if(loginUser == null){
			request.setAttribute("loginError", "�û�����" +username + " �����ڣ������µ�¼��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		//5.����û������ڣ��������벻��
		if(!loginUser.getPassword().equals(password)){
			request.setAttribute("loginError", "�û�����" +username + ",������������µ�¼��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		//6.�ж���֤���Ƿ���ȷ
		String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
		if(!sessionValidateCode.equals(validateCode)){
			request.setAttribute("loginError", "��֤����������µ�¼��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//.7��¼�ɹ�
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		
		//�޸�֮ǰ�Ĵ���
		//response.sendRedirect("./main/stu_list");
		
		//�޸�֮��Ĵ���
		response.sendRedirect("./main/main.jsp");
	}
}
