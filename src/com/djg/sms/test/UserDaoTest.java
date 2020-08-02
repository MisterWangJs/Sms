package com.djg.sms.test;

import org.junit.Test;

import com.djg.sms.dao.IUserDao;
import com.djg.sms.dao.impl.UserDaoJDBCImpl;
import com.djg.sms.domain.User;

public class UserDaoTest {
	private IUserDao userDao = new UserDaoJDBCImpl();
	
	@Test
	public void test01(){
	//	User u = userDao.findByName("admin");
		//System.out.println(u);
	}
}
