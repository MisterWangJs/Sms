package com.djg.sms.dao;

import java.util.List;

import com.djg.sms.domain.Student;

public interface IStudentDao {

	public int add(Student s);
	
	public int deleteById(int id);
	
	public int modify(int id,Student s);
	
	public Student findById(int id);
	
	
	
	
	
	
	
	//查询记录的总条数
	public int findTotalCount();
	
	public List<Student> findAll();
		
	//查询一页的记录
	public List<Student> findOnePage(int pageIndex,int pageSize);
	
	public List<Student> query();
}
