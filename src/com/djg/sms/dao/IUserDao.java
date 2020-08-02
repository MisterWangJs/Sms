package com.djg.sms.dao;

import java.util.List;

import com.djg.sms.domain.Student;
import com.djg.sms.domain.User;

public interface IUserDao {


	public int add(User user);
	
	public int deleteById(int id);
		


	public User findByName(String username);

	public User findById(int id);

	public int findTotalCount();
	
	public List<User> findAll();

	public List<User> findOnePage(int pageIndex, int pageSize);


	int modify(User user, String username);

	int modify(int id, User user);


}
