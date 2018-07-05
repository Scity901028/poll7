package com.briup.apps.poll.bean.extend;



public class AnswersVM {
	private Long id;
	private String selections;
	private String checkes;
	private String content;
	private SurveyVM survey;
	

	public SurveyVM getSurvey() {
		return survey;
	}
	public void setSurvey(SurveyVM survey) {
		this.survey = survey;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSelections() {
		return selections;
	}
	public void setSelections(String selections) {
		this.selections = selections;
	}
	public String getCheckes() {
		return checkes;
	}
	public void setCheckes(String checkes) {
		this.checkes = checkes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
}
