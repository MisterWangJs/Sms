package com.djg.sms.test;

import java.util.List;

import org.junit.Test;

import com.djg.sms.dao.IStudentDao;
import com.djg.sms.dao.impl.StudentDaoJDBCImpl;
import com.djg.sms.domain.Student;

public class StudentDaoTest {
	IStudentDao stuDao = new StudentDaoJDBCImpl();
	
	
	//����findAll()����
	@Test
	public void test01(){
		List<Student> stuList = stuDao.findAll();
		
		System.out.println("DB������ѧ����¼���£�");
		for(Student s : stuList){
			System.out.println(s);
		}
	}
	
	//����findById()����
	@Test
	public void test02(){
		Student student = stuDao.findById(74);
		System.out.println(student);
	}
	
	//����add()����
	@Test
	public void test03(){
		Student s = new Student();
		s.setName("�����");
		s.setMyclass("���缼��18��1��");
		s.setScore(90);
		
		int i = stuDao.add(s);
		System.out.println("i = " + i);
	}
	
	//����deleteById()����
	@Test
	public void test04(){
		int i = stuDao.deleteById(74);
		System.out.println("i = " + i);
	}
	
	//����update()����
	@Test
	public void test05(){
		Student s = stuDao.findById(22);
		s.setMyclass("������1��");
		s.setScore(78);
		
		stuDao.modify(22, s);
	}
	
	//����findTotalCount()����
	@Test
	public void test06(){
		int totalcount = stuDao.findTotalCount();
		System.out.println("��¼��������" + totalcount);
	}
	
	
	//����findOnePage()����
	@Test
	public void test07(){
		List<Student> stuList = stuDao.findOnePage(2, 10);
		
		System.out.println("��2ҳ�ļ�¼���£�");
		for(Student s : stuList){
			System.out.println(s);
		}
	}
	
}
