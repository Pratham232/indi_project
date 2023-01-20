package com.revature.model;
import java.util.TreeSet;

import com.revature.util.QuestionsSection;

import java.util.Comparator;
class TreeSetClass {

	public static void main(String[] args) {
		QuestionManagement q=new QuestionManagement("Q10",QuestionsSection.INSTRUCTOR, "Is the trainer interactive in the class");
		QuestionManagement q1=new QuestionManagement("Q11",QuestionsSection.COURSEMATERIAL,"Is the trainer interactive in the class");
		QuestionManagement q2=new QuestionManagement("Q12",QuestionsSection.LEARNINGEFFECTIVENESS,"Is the trainer interactive in the class");
		QuestionManagement q3=new QuestionManagement("Q14",QuestionsSection.ENVIRONMENT,"Is the trainer interactive in the class");
		QuestionManagement q4=new QuestionManagement("Q17",QuestionsSection.JOBIMPACT,"Is the trainer interactive in the class");

		
		TreeSet<QuestionManagement> ts=new TreeSet<QuestionManagement>(new Comparator<QuestionManagement>(){

			@Override
			public int compare(QuestionManagement obj1, QuestionManagement obj2) {
				return obj1.questionSection.compareTo(obj2.questionSection);
			}
		});
		
		ts.add(q3);
		ts.add(q);
		ts.add(q2);
		ts.add(q4);
		ts.add(q1);
		
		
		for(QuestionManagement x:ts) {
			System.out.println(x.questionId+ " "+ x.questionSection + " "+ x.questionText);
		}
	}
}
