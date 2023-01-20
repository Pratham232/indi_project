package com.revature.dao.impl;
import com.revature.dao.QuestionManagementDao;
import com.revature.menu.QuestionOperationsMenu;
import com.revature.model.QuestionManagement;
import com.revature.util.QuestionsSection;
import java.util.Scanner;


public class QuestionManagementService extends QuestionManagement implements QuestionManagementDao {

	public  void getUserInput() {
		
		int choice=0;
		int choices=0;
		int switcher=0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("What do you want to do?\n1.Add question in section\n2.Go back too previous menu\n3.Termination Condition");
			switcher=sc.nextInt();
			sc.nextLine();
			switch(switcher) {
			case 1:do {
				QuestionManagement q=new QuestionManagement();
				System.out.println("Which section do you want to add question?\n 1.INSTRUCTOR\n 2.COURSE MATERIAL \n 3.LEARNING EFFECTIVENESS \n 4.ENVIRONMENT \n 5.JOB IMPACT");
				String a=sc.nextLine();
				QuestionsSection x=QuestionsSection.valueOf(a);
				
				q.setQuestionSection(x);
				
				
				if(a.equals(QuestionsSection.INSTRUCTOR.toString())) 
				{
				System.out.print("Please enter the question id(Q1,Q2...:");
				String Q=sc.nextLine();
				q.setQuestion_id(Q);
				System.out.print("Please enter the question text:");
				String Q1=sc.nextLine();
				q.setQuestionText(Q1);
				}
				
				else if(a.equals(QuestionsSection.COURSEMATERIAL.toString())) {
					System.out.print("Please enter the question id(Q1,Q2...:");
					String Q=sc.nextLine();
					q.setQuestion_id(Q);
					System.out.print("Please enter the question text:");
					String Q1=sc.nextLine();
					q.setQuestionText(Q1);
					}
				else if(a.equals(QuestionsSection.LEARNINGEFFECTIVENESS.toString())) {
					System.out.print("Please enter the question id(Q1,Q2...:");
					String Q=sc.nextLine();
					q.setQuestion_id(Q);
					System.out.print("Please enter the question text:");
					String Q1=sc.nextLine();
					q.setQuestionText(Q1);
					}
				else if(a.equals(QuestionsSection.ENVIRONMENT.toString())) {
					System.out.print("Please enter the question id(Q1,Q2...:");
					String Q=sc.nextLine();
					q.setQuestion_id(Q);
					System.out.print("Please enter the question text:");
					String Q1=sc.nextLine();
					q.setQuestionText(Q1);
					}
				else if(a.equals(QuestionsSection.JOBIMPACT.toString())) {
					System.out.print("Please enter the question id(Q1,Q2...:");
					String Q=sc.nextLine();
					q.setQuestion_id(Q);
					System.out.print("Please enter the question text:");
					String Q1=sc.nextLine();
					q.setQuestionText(Q1);
					}
				else
					System.out.println("!!!!!!!!!!Please enter the value from the above options!!!!!!!!!!!");
				
				System.out.println("\n\n If you want to add more questions press '1' or press 0");
				choice=sc.nextInt();
				sc.nextLine();
				QuestionDetails.add(q);
			}while(choice==1);
				break;
			case 2:QuestionOperationsMenu.menuAppForQuestion();
				break;
			case 3:
			System.out.println("Do you want to continue then press 1 or press 0 to go outside the loop");
			choices=sc.nextInt();
			break;}
		} while (choices==1);
	}
	
	@Override
	public void displayQuestionDetails() {
		
		for(QuestionManagement i:QuestionDetails) {
			String qid=i.getQuestionId();
			QuestionsSection QS=i.getQuestionSection();
			String qtext=i.getQuestionText();
			System.out.println(qid+" "+QS+" "+qtext);
		}
	}
}
