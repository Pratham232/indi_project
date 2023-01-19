package com.revature.dao.impl;
import com.poms.config.DatabaseConnection;
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
		Connection con = null;
		con = DatabaseConnection.getConnection();

		try {
			System.out.print("\nPlease enter userId from the table:");
			userid = s.nextLine();

			System.out.print("\nPlease enter password from the table:");
			password = s.nextLine();

			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM User");
			if (rs.next()) {
				if (userid.equals(rs.getString(1)) && password.equals(rs.getString(2))&& rs.getString(3).equals("Admin")) {
					QuestionOperationsMenu.menuAppForQuestion();
				} else {
					System.err.println("\tInvalid userid or password");
				}
			} else {
				System.err.println("\tInvalid userid or password");
			}

		} catch (SQLException e) {
			System.out.println("Exception" + e.getMessage());
		}
		try {
			con.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public void DisplayUser() {
		Connection con = null;
		con = DatabaseConnection.getConnection();
		
		try {
			
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM User");
			while(rs.next()) {
				User uu=new User();
				String username=rs.getString("username");
				uu.setUsername(rs.getString("username"));
				String password=rs.getString("password");
				System.out.println("\n"+username+" "+password);
			}
			
		}catch(SQLException e ){
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} 
		catch (SQLException e) {}
		
	}

	@Override
	public User getUserForTest(User uu) {
		Connection con = null;
		con = DatabaseConnection.getConnection();
		try {
			
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM User");
			while(rs.next()) {
				
				if (uu.getUsername().equals(rs.getString(1)) && uu.getPassword().equals(rs.getString(2))){
				uu.setUsername(rs.getString(1));
				uu.setPassword(rs.getString(2));
				uu.setRole(rs.getString(3));
				}
				
			}
			
		}catch(SQLException e ){
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		}catch (SQLException e) {}
		
		return uu;
		
	}
}