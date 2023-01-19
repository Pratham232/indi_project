package com.revature.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.QuestionManagementDao;
import com.revature.model.QuestionManagement;
import com.revature.model.User;


public class QuestionManagementService extends QuestionManagement implements QuestionManagementDao 
{

	public  void getUserInput() {
		Scanner s=new Scanner(System.in);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pp", "root", "admin");
			//System.out.println("Connection Established");

		System.out.println("Enter questionId:");
		String questionId=s.nextLine();
		System.out.println("Enter questionSection:");
		String questionSection=s.nextLine();
		System.out.println("Enter questionText:");
		String questionText=s.nextLine();
		
		java.sql.Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM QuestionManagement");
		if(rs.next()) {
			if(questionId.equals(rs.getString("question_id"))){
			System.out.println("Enter another questionId");
		}
			else {
				String sql="INSERT into QuestionManagement(question_id,question_section,question_text)values(?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, questionId);
				ps.setString(2, questionSection);
				ps.setString(3, questionText);
				ps.executeUpdate();

			}
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
	public void displayQuestionDetails() 
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pp","root","admin");
			//System.out.println("Connection Established");
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM QuestionManagement");
			while(rs.next()) {
				String questionId=rs.getString("question_id");
				String questionSection=rs.getString("question_section");
				String questionText=rs.getString("question_text");
				System.out.println(questionId+" "+questionSection+" "+questionText);
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


