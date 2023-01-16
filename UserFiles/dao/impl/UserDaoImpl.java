package com.revature.dao.impl;
import com.revature.dao.UserDao;
import com.revature.menu.UserAuthentication;
import com.revature.model.User;
import com.revature.service.impl.UserServiceImpl;

import java.util.Scanner;
public class UserDaoImpl implements UserDao {

	@Override
	public void getUser(String username, String password) {
		Scanner s=new Scanner(System.in);
		User u=new User();
		System.out.println("Enter the Username:");
		String a=s.nextLine();
		System.out.println("Enter the Password:");
		String b=s.nextLine();
		if(checkAuthorization(a,b)) {
		System.out.println("Login Successfull");
			
		}
		UserInfo.add(u);	
	}

	private boolean checkAuthorization(String a,String b) {
		User u4=new User("pp","mb","Admin");
		User u1=new User("ps","mb","Trainer");
		User u2=new User("pd","mb","Trainee");
		UserDao.UserInfo.add(u1);
		UserDao.UserInfo.add(u4);
		UserDao.UserInfo.add(u2);
		
		for(User r:UserDao.UserInfo) {
			if(r.getUsername().equals(a) && r.getPassword().equals(b)&&r.getRole().equals("Admin")) {
				System.out.println("Admin");
				UserServiceImpl.postAuthenticationGetUser();
				return true;			}
			else if(r.getUsername().equals(a) && r.getPassword().equals(b)&&r.getRole().equals("Trainer")) {
				System.out.println("Trainer");
				return true;			}
			else if(r.getUsername().equals(a) && r.getPassword().equals(b)&&r.getRole().equals("Trainee")) {
				System.out.println("Trainee");
				return true;			}
		}
		System.out.println("not autheticated");
		
		return false;
	}
	@Override
	public void DisplayUser() {
		for(User i:UserInfo) {
		String a=i.getUsername();
		String b=i.getPassword();
		System.out.println(a+" "+b);
		}
	}
}