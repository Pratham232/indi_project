package com.revature.model;

public class QuestionManagement {
	String questionId;
	String questionSection;
	String questionText;
	
	
	public QuestionManagement() {
	}
	public QuestionManagement(String questionId, String questionSection, String questionText) {
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
	public String getQuestionSection() {
		return questionSection;
	}
	public void setQuestionSection(String questionSection) {
		this.questionSection = questionSection;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
}

