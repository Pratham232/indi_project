package com.revature.service.impl;

import com.revature.dao.impl.UserDaoImpl;
import com.revature.menu.QuestionOperationsMenu;
import com.revature.service.UserService;

public class UserServiceImpl extends UserDaoImpl implements UserService {

	public static void postAuthenticationGetUser() {
		int choice=0;
		
		do {
			QuestionOperationsMenu.menuAppForQuestion();
			System.out.println("If you want to continue then press 1 otherwise press 0");
		} while (choice==1);
		System.out.println("Outside Loop");
	}

}
