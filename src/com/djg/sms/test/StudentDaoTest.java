package com.djg.sms.test;

import java.util.List;

import org.junit.Test;

import com.djg.sms.dao.IStudentDao;
import com.djg.sms.dao.impl.StudentDaoJDBCImpl;
import com.djg.sms.domain.Student;

public class StudentDaoTest {
	IStudentDao stuDao = new StudentDaoJDBCImpl();
	
	
	//测试findAll()方法
	@Test
	public void test01(){
		List<Student> stuList = stuDao.findAll();
		
		System.out.println("DB中所有学生记录如下：");
		for(Student s : stuList){
			System.out.println(s);
		}
	}
	
	//测试findById()方法
	@Test
	public void test02(){
		Student student = stuDao.findById(74);
		System.out.println(student);
	}
	
	//测试add()方法
	@Test
	public void test03(){
		Student s = new Student();
		s.setName("孙悟空");
		s.setMyclass("网络技术18级1班");
		s.setScore(90);
		
		int i = stuDao.add(s);
		System.out.println("i = " + i);
	}
	
	//测试deleteById()方法
	@Test
	public void test04(){
		int i = stuDao.deleteById(74);
		System.out.println("i = " + i);
	}
	
	//测试update()方法
	@Test
	public void test05(){
		Student s = stuDao.findById(22);
		s.setMyclass("大数据1班");
		s.setScore(78);
		
		stuDao.modify(22, s);
	}
	
	//测试findTotalCount()方法
	@Test
	public void test06(){
		int totalcount = stuDao.findTotalCount();
		System.out.println("记录总条数：" + totalcount);
	}
	
	
	//测试findOnePage()方法
	@Test
	public void test07(){
		List<Student> stuList = stuDao.findOnePage(2, 10);
		
		System.out.println("第2页的记录如下：");
		for(Student s : stuList){
			System.out.println(s);
		}
	}
	
}
