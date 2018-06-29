package com.briup.apps.poll.service.impl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService {
	@Autowired
	private SurveyVMMapper surveyVMMpper;
	@Autowired
	private SurveyMapper surveyMpper;


	
	
	@Override
	public void saveOrUpdate(Survey survey) throws Exception {
		//保存课调之前初始化课调信息
		survey.setStatus(Survey.STATUS_INIT);
		survey.setCode("");
		
		Date surveyDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String aa=sdf.format(surveyDate);		
		survey.setSurveydate(aa);
		surveyMpper.insert(survey);
		
	}



	@Override
	public List<SurveyVM> findAll() throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMpper.selectAll();
	}



	@Override
	public SurveyVM findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMpper.selectById(id);
	}











}
