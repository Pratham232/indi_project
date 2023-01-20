package com.revature.menu;

import java.util.Scanner;

import com.revature.dao.impl.QuestionManagementService;

public class QuestionOperationsMenu {
	public static void main(String[] args) {
		menuAppForQuestion();
	}

	public static void menuAppForQuestion() {
		int choice=0;
		int choices=0;
		Scanner sc=new Scanner(System.in);
		QuestionManagementService qms=new QuestionManagementService();
		do {
			System.out.println("Choose 1 Question Management Operation\n1.Add Questions\n2.Display Questions");
			choices=sc.nextInt();
			sc.nextLine();
			switch(choices) {
			case 1:		qms.getUserInput();
				break;
			case 2:		qms.displayQuestionDetails();
				break;			
			default:
			System.out.println("Please enter the valid option");}
			System.out.println("If you want to continue press 1 otherwise press 0 to terminate the program");
			choice=sc.nextInt();
			sc.nextLine();
		} while (choice==1);
		System.out.println("program terminated1");
	}
}

