package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.bean.extend.ClazzVM;

public interface IAnswersService {
	void saveOrUpdate(Answers answers) throws Exception;
	
	List<AnswersVM> findAll() throws Exception;
	
	AnswersVM findById(long id) throws Exception;
		
	List<Answers> findAnswersBySurveyId(long surveyId) throws Exception;
}
