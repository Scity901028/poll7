package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
	List<SurveyVM> findAll() throws Exception;

	SurveyVM findById(long id) throws Exception;
	
	void saveOrUpdate(Survey survey) throws Exception;
	//查找课调单表
	Survey findSurveyById(long id) throws Exception;
	
	List<SurveyVM> findSurveyByStatus(String status) throws Exception; 
}
