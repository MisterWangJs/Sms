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

@WebServlet("/main/stu_modify")
public class StudentModifyServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.������������ı���
		//request.setCharacterEncoding("utf8");
		//2.�õ��������
		String sId = request.getParameter("id");
		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");
		String sScore = request.getParameter("score");
		
		
		
		
		int id = Integer.parseInt(sId);
		double score = Double.parseDouble(sScore);
		
		System.out.println(id);
		
		System.out.println(name);
		
		System.out.println(myclass);
		
		System.out.println(score);
		
		
		//3.����ʵ�����
		Student stu = new Student();
		stu.setName(name);
		stu.setMyclass(myclass);
		stu.setScore(score);
		
		//4.����IStudentDao����Ϣ��ӵ�DB��
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int i = stuDao.modify(id, stu);
		
		if(i == 1){
			response.sendRedirect("./Success.jsp");
		}
		else{
			response.sendRedirect("./Defeat.jsp");
		}
		
	}
}
