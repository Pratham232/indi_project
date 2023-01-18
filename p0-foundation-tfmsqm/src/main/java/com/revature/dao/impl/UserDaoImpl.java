package com.revature.dao.impl;
import com.revature.dao.UserDao;
import com.revature.menu.QuestionOperationsMenu;
import com.revature.model.User;
import com.revature.service.impl.UserServiceImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class UserDaoImpl implements UserDao {
	private String userid=null;
	private String password=null;
	

	@Override
	public void getUser() {
		QuestionOperationsMenu pp=new QuestionOperationsMenu();
		Scanner s=new Scanner(System.in);
		User u=new User();
		System.out.print("\nEnter the Username:");
		userid=s.nextLine();
		System.out.print("\nEnter the Password:");
		password=s.nextLine();	
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pp", "root", "admin");
			//System.out.println("Connection Established");

			System.out.print("\nPlease enter userId from the table:");
			userid = s.nextLine();

			System.out.print("\nPlease enter password from the table:");
			password = s.nextLine();

			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM User");
			if (rs.next()) {
				if (userid.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					QuestionOperationsMenu.menuAppForQuestion();
				} else {
					System.err.println("\tInvalid userid or password");
				}
			} else {
				System.err.println("\tInvalid userid or password");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception" + e.getMessage());
		}
		try {
			con.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public void DisplayUser() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pp","root","admin");
			//System.out.println("Connection Established");
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM User");
			while(rs.next()) {
				String username=rs.getString("username");
				String password=rs.getString("password");
				System.out.println("\n"+username+" "+password);
			}
			
		}catch(ClassNotFoundException | SQLException e ){
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} 
		catch (SQLException e) {}
		
	}
}