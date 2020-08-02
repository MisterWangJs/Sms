package com.djg.sms.dao;

import java.util.List;

import com.djg.sms.domain.Student;

public interface IStudentDao {

	public int add(Student s);
	
	public int deleteById(int id);
	
	public int modify(int id,Student s);
	
	public Student findById(int id);
	
	
	
	
	
	
	
	//��ѯ��¼��������
	public int findTotalCount();
	
	public List<Student> findAll();
		
	//��ѯһҳ�ļ�¼
	public List<Student> findOnePage(int pageIndex,int pageSize);
	
	public List<Student> query();
}
