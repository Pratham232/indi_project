package com.revature.dao;

import com.revature.model.QuestionManagement;

public interface QuestionManagementDao{

	public abstract void getUserInput();
	public abstract void displayQuestionDetails();
	void addQuestion(QuestionManagement q);
	public abstract QuestionManagement getQuestionObj(QuestionManagement qtobeInserted);
	
}
