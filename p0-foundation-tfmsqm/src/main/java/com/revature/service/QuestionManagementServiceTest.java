package com.revature.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.revature.dao.impl.QuestionManagementDaoImpl;

public class QuestionManagementServiceTest {
	@Test
	public void test() {
		QuestionManagementDaoImpl qs=new QuestionManagementDaoImpl();
		qs.displayQuestionDetails();
		int b=QuestionManagementDaoImpl.v;
		assertEquals(b,QuestionManagementDaoImpl.v);
	}
}
