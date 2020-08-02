package com.djg.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djg.sms.dao.IUserDao;
import com.djg.sms.dao.impl.UserDaoJDBCImpl;
@WebServlet("/main/user_delete")
public class UserDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.����������
		String uId = request.getParameter("id");
		int id = Integer.parseInt(uId);
		
		//2.����DAOʵ��ɾ��ѧ����ҵ���߼�
		IUserDao userDao = new UserDaoJDBCImpl();
		int i = userDao.deleteById(id);
		
		//3.���ɾ���ɹ�������ת��ѧ���б�servlet
		if(i == 1){
			response.sendRedirect("./userdelSuccess.jsp");
		}
	}
}
