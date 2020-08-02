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
		//1.设置请求参数的编码
		//request.setCharacterEncoding("utf8");
		//2.得到请求参数
		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");
		String sScore = request.getParameter("score");
		double score = Double.parseDouble(sScore);
		
		//3.创建实体对象
		Student stu = new Student();
		stu.setName(name);
		stu.setMyclass(myclass);
		stu.setScore(score);
		
		//4.借助IStudentDao将信息添加到DB中
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int i = stuDao.add(stu);
			
		if(i == 1){
			response.sendRedirect("../main/Success.jsp");
		}		
		
	}
}
