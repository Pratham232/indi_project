package com.revature.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.poms.config.DatabaseConnection;
import com.revature.dao.QuestionManagementDao;
import com.revature.menu.UserAuthentication;
import com.revature.model.QuestionManagement;


public class QuestionManagementDaoImpl extends QuestionManagement implements QuestionManagementDao 
{
	public static int v=0;

	private static final Logger logger = Logger.getLogger(UserAuthentication.class);

	public  void getUserInput() {
		Scanner s=new Scanner(System.in);
		Connection con = null;
		con = DatabaseConnection.getConnection();

	try {
		logger.info("\nEnter questionId:");
		String questionId=s.nextLine();
		logger.info("\nEnter questionSection:");
		String questionSection=s.nextLine();
		logger.info("\nEnter questionText:");
		String questionText=s.nextLine();
		
		java.sql.Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM QuestionManagement");
		if(rs.next()) {
			if(questionId.equals(rs.getString("question_id"))){
			logger.info("\nEnter another questionId");
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
		
	} catch (SQLException e) {
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
		con = DatabaseConnection.getConnection();
		try {

			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM QuestionManagement");
			while(rs.next()) {
								v=v+1;
								String questionId=rs.getString("question_id");
								String questionSection=rs.getString("question_section");
								String questionText=rs.getString("question_text");
								logger.info("\n"+questionId+" "+questionSection+" "+questionText);
								
							 }
			System.out.println(v);
		
			}
		catch(SQLException e) {}
		
		try {
				con.close();
			} 
		catch (SQLException e) {}
		}

	@Override
	public void addQuestion(QuestionManagement q) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			con = DatabaseConnection.getConnection();
			
			java.sql.Statement stm = con.createStatement();
			
					String sql="INSERT into QuestionManagement(question_id,question_section,question_text)values(?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, q.getQuestionId());
					ps.setString(2, q.getQuestionSection());
					ps.setString(3, q.getQuestionText());
					ps.executeUpdate();

			
		} catch (SQLException e) {
		}
		
		
	}

	@Override
	public QuestionManagement getQuestionObj(QuestionManagement qtobeInserted) {
		Connection con = null;
		con = DatabaseConnection.getConnection();
		boolean found=false;
		QuestionManagement obj=new QuestionManagement();
		try {
			String qid=qtobeInserted.getQuestionId();
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM QuestionManagement");
			
			while(rs.next()) {
				if(qid.equals(rs.getString(1))) {
					found=true;
					obj.setQuestion_id(qid);
					obj.setQuestionSection(rs.getString(2));
					obj.setQuestionText(rs.getNString(3));
				}
			}
			
			
		} catch (SQLException e) {
		}
		// TODO Auto-generated method stub
		if(found==true) {
			return obj;
		}
		return null;
	}
		

}


