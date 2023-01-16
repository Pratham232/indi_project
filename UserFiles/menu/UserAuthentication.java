package com.revature.menu;
import java.util.Scanner;
import com.revature.dao.impl.UserDaoImpl;

public class UserAuthentication extends UserDaoImpl{

	public static void main(String[] args) {
		UserAuthentication ua=new UserAuthentication();
		int choice=0;
		Scanner s=new Scanner(System.in);
		do {
			int c=0;
			System.out.println("Enter choice\n1.Sign In \n2.Display");
			c=s.nextInt();
			s.nextLine();
			switch(c)
			{
			case 1:
				ua.getUser(null,null);
				break;
			case 2:ua.DisplayUser();
				break;
			}
			System.out.println("If you want to continue press 1 or press 0 to terminate it");
			choice=s.nextInt();
			s.nextLine();
		} while (choice==1);
		
		System.out.println("Program Terminated");
	}
}
