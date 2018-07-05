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
	//List中可以有多个不同的结果，而不用List时只能有一个结果
	List<SurveyVM> findSurveyByStatus(String status) throws Exception; 
}
