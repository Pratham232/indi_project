package com.revature.model;

import com.revature.util.QuestionsSection;

public class QuestionManagement {
	String questionId;
	QuestionsSection questionSection;
	String questionText;
	
	
	public QuestionManagement() {
	}
	public QuestionManagement(String questionId, QuestionsSection questionSection, String questionText) {
		this.questionId = questionId;
		this.questionSection = questionSection;
		this.questionText = questionText;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestion_id(String questionId) {
		this.questionId = questionId;
	}
	public QuestionsSection getQuestionSection() {
		return questionSection;
	}
	public void setQuestionSection(QuestionsSection questionSection) {
		this.questionSection = questionSection;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
}

