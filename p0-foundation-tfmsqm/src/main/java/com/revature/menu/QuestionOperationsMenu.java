package com.revature.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.impl.QuestionManagementDaoImpl;

public class QuestionOperationsMenu 
{	private static final Logger logger = Logger.getLogger(UserAuthentication.class);

	public static void main(String[] args) 
	{
		menuAppForQuestion();
	}

	public static void menuAppForQuestion() 
	{
		int choice=0;
		int choices=0;
		Scanner sc=new Scanner(System.in);
		QuestionManagementDaoImpl qms=new QuestionManagementDaoImpl();
		do {
			logger.info("\n!!!!!!!!!!!!!!!Question Operation Menu!!!!!!!!!!!!!!!");
			logger.info("\n1.Add Questions\n2.Display Questions\nEnter you choice here:");
			choices=sc.nextInt();
			sc.nextLine();
			switch(choices) 
			{
				case 1:	qms.getUserInput();
					break;
				case 2: qms.displayQuestionDetails();
					break;
				
				default:
					logger.info("\n!!!!!!!!!!!!!Please enter the valid option!!!!!!!!!!!!!!!");
			}
			
			logger.info("\n!!!!!!!!!!!!!Question Menu Page!!!!!!!!!!!\n\nPress 1 to continue to go back to menu\nPress 0 to exit this page\nEnter your choice here:");
			choice=sc.nextInt();
			sc.nextLine();
			} while (choice==1);
		logger.info("\n\n!!!!!!!!!!!!Outside the Question Operations!!!!!!!!!!!!!!");
	}
}

