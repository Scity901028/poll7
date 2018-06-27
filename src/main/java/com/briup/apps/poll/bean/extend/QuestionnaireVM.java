package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.User;

public class QuestionnaireVM {
	private Long id;
	private String name;
	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	private String description;
	private String createDate;
	private Long question_id;
	private Question question;
	private Options options;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}

}	