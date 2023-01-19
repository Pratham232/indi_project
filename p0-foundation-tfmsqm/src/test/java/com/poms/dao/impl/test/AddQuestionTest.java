package com.poms.dao.impl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.dao.QuestionManagementDao;
import com.revature.dao.impl.QuestionManagementDaoImpl;
import com.revature.model.QuestionManagement;

public class AddQuestionTest {
	
	@Test
	public void Test() {
		QuestionManagement qtobeInserted=new QuestionManagement("Q9","Course Material","Admin");
		QuestionManagement qinserted=null;
	
		try {
			QuestionManagementDao a=new QuestionManagementDaoImpl();
			a.addQuestion(qtobeInserted);
			qinserted=a.getQuestionObj(qtobeInserted);
			}
			catch(Exception e)
			{}
	assertEquals(qtobeInserted.getQuestionId(), qinserted.getQuestionId());
	assertEquals(qtobeInserted.getQuestionSection(), qinserted.getQuestionSection());
	
			} 	
}
