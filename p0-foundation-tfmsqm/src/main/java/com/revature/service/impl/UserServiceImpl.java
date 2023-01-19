package com.revature.service.impl;

import org.apache.log4j.Logger;

import com.revature.dao.impl.UserDaoImpl;
import com.revature.menu.QuestionOperationsMenu;
import com.revature.menu.UserAuthentication;
import com.revature.service.UserService;

public class UserServiceImpl extends UserDaoImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserAuthentication.class);

	public void postAuthenticationGetUser() {
		int choice=0;
		
		do {
			QuestionOperationsMenu.menuAppForQuestion();
			logger.info("If you want to continue then press 1 otherwise press 0");
		} while (choice==1);
		logger.info("Outside Loop");
	}

}
