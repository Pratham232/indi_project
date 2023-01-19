package com.poms.dao.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;

public class UserDaoImplTest {
	UserDao userDao=new UserDaoImpl();
	User result=new User();
	@Test
	public void userAuthenticateTest() {
		User uu=new User("pp","mb","");
		result=userDao.getUserForTest(uu);
		assertEquals(result.getUsername(),uu.getUsername());
	}
}
