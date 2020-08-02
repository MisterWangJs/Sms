	package com.djg.sms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djg.sms.dao.IStudentDao;
import com.djg.sms.dao.impl.StudentDaoJDBCImpl;
import com.djg.sms.domain.Student;
import com.djg.sms.util.PageBean;

public class StudentListServlet extends HttpServlet {
	private int pageSize;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String sPageSize = config.getInitParameter("pageSize");
		if(sPageSize != null){
			this.pageSize = Integer.parseInt(sPageSize);
		}else{
			this.pageSize = 10;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���������������
		request.setCharacterEncoding("utf-8");
		
		//2.���������� - �����������Ҫ��ʾ�� ҳ��pageIndex
		String sPageIndex = request.getParameter("pageIndex");
		
		//3.�Բ���Ҫ�����ж�
		if(sPageIndex == null)
			sPageIndex = "1";
		
		//4.���������ַ�������  ת���� int����
		int pageIndex = Integer.parseInt(sPageIndex);
		
		//5.���� ��ҳ����PageBean
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		int count = stuDao.findTotalCount();
		List<Student> list = stuDao.findOnePage(pageIndex, this.pageSize); 
		
		PageBean<Student> pageBean = new PageBean<Student>(pageIndex, count, this.pageSize, list);
 		pageBean.init();
 		
 		//6.��ת�� ѧ���б�ҳ�� list_stu.jsp
 		request.setAttribute("pageBean", pageBean);
 		RequestDispatcher rd = request.getRequestDispatcher("stu_list.jsp");
 		rd.forward(request, response);
		
		
	}
}
