package com.revature.menu;

import java.util.Scanner;

import com.revature.dao.impl.QuestionManagementService;

public class QuestionOperationsMenu 
{
	public static void main(String[] args) 
	{
		menuAppForQuestion();
	}

	public static void menuAppForQuestion() 
	{
		int choice=0;
		int choices=0;
		Scanner sc=new Scanner(System.in);
		QuestionManagementService qms=new QuestionManagementService();
		do {
			System.out.println("\n!!!!!!!!!!!!!!!Question Operation Menu!!!!!!!!!!!!!!!");
			System.out.print("1.Add Questions\n2.Display Questions\nEnter you choice here:");
			choices=sc.nextInt();
			sc.nextLine();
			switch(choices) 
			{
				case 1:	qms.getUserInput();
					break;
				case 2: qms.displayQuestionDetails();
					break;
				
				default:
					System.out.println("!!!!!!!!!!!!!Please enter the valid option!!!!!!!!!!!!!!!");
			}
			
			System.out.print("\n!!!!!!!!!!!!!Question Menu Page!!!!!!!!!!!\n\nPress 1 to continue to go back to menu\nPress 0 to exit this page\nEnter your choice here:");
			choice=sc.nextInt();
			sc.nextLine();
			} while (choice==1);
		System.out.print("\n\n!!!!!!!!!!!!Outside the Question Operations!!!!!!!!!!!!!!");
	}
}

