package com.djg.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djg.sms.dao.IStudentDao;
import com.djg.sms.dao.impl.StudentDaoJDBCImpl;

@WebServlet("/main/stu_delete")
public class StudentDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.����������
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		//2.����DAOʵ��ɾ��ѧ����ҵ���߼�
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int i = stuDao.deleteById(id);
		
		//3.���ɾ���ɹ�������ת��ѧ���б�servlet
		if(i == 1){
			response.sendRedirect("./Success.jsp");
		}
	}
}
