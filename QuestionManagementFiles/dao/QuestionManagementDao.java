package com.revature.dao;

import java.util.*;
import com.revature.model.QuestionManagement;

public interface QuestionManagementDao{

	static List<QuestionManagement>QuestionDetails=new ArrayList<>();
	public abstract void getUserInput();
	public abstract void displayQuestionDetails();
	
}
