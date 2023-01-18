package com.revature.menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.dao.impl.UserDaoImpl;
//User Implementation
public class UserAuthentication extends UserDaoImpl{

	public static void main(String[] args) {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pp","root","admin");
			//System.out.println("Connection Established");
			
		}catch(ClassNotFoundException | SQLException e ){
			System.out.println(e.getMessage());
			
		}
		
		UserAuthentication ua=new UserAuthentication();
		int choice=0;
		Scanner s=new Scanner(System.in);
		do {
			int c=0;
			System.out.print("!!!!!!!!!!!!User Authentication!!!!!!!!!!!!!");
			System.out.print("\nEnter choice\n1.Sign In \n2.Display\nEnter your choice:");
			c=s.nextInt();
			s.nextLine();
			switch(c)
			{
			case 1:ua.getUser();
				break;
			case 2:ua.DisplayUser();
				break;
			}
			System.out.print("\n\nUser Authentication Page\nPress 1 to continue\nPress 0 to terminate the program\nEnter your choice:");
			choice=s.nextInt();
			s.nextLine();
		} while (choice==1);
		
		try{
			con.close();
		}catch(SQLException e) {
			
		}
		
		System.out.println("*********Log in program Terminated********");
	}
}
