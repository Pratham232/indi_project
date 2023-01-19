package com.revature.menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.poms.config.DatabaseConnection;
import com.revature.dao.impl.UserDaoImpl;

public class UserAuthentication extends UserDaoImpl{
	private static final Logger logger = Logger.getLogger(UserAuthentication.class);
	public static void main(String[] args) {
		Connection con=null;
		con = DatabaseConnection.getConnection();
		UserAuthentication ua=new UserAuthentication();
		int choice=0;
		Scanner s=new Scanner(System.in);
		do {
			int c=0;

			logger.info("\n!!!!!!!!!!!!User Authentication!!!!!!!!!!!!!");
			logger.info("\nEnter choice\n1.Sign In \n2.Display\nEnter your choice:");
			c=s.nextInt();
			s.nextLine();
			switch(c)
			{
			case 1:ua.getUser();
				break;
			case 2:ua.DisplayUser();
				break;
			}
			logger.info("\n\nUser Authentication Page\nPress 1 to continue\nPress 0 to terminate the program\nEnter your choice:");
			choice=s.nextInt();
			s.nextLine();
		} while (choice==1);
		
		try{
			con.close();
		}catch(SQLException e) {
			
		}
		
		logger.info("\n*********Log in program Terminated********");
	}
}
