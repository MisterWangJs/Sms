package com.djg.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djg.sms.dao.IStudentDao;
import com.djg.sms.dao.impl.StudentDaoJDBCImpl;
import com.djg.sms.domain.Student;

@WebServlet("/main/stu_add")
public class StudentAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.������������ı���
		//request.setCharacterEncoding("utf8");
		//2.�õ��������
		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");
		String sScore = request.getParameter("score");
		double score = Double.parseDouble(sScore);
		
		//3.����ʵ�����
		Student stu = new Student();
		stu.setName(name);
		stu.setMyclass(myclass);
		stu.setScore(score);
		
		//4.����IStudentDao����Ϣ��ӵ�DB��
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int i = stuDao.add(stu);
			
		if(i == 1){
			response.sendRedirect("../main/Success.jsp");
		}		
		
	}
}
