package com.briup.apps.poll.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService {
	@Autowired
	private SurveyVMMapper surveyVMMapper;
	@Autowired
	private SurveyMapper surveyMapper;
	
	@Override
	public void saveOrUpdate(Survey survey) throws Exception {
		//1.判断是保存还是更新
		if(survey.getId()!=null){
			//更新
			surveyMapper.updateByPrimaryKey(survey);
			
		}else{
			//保存
			//保存课调之前初始化课调信息
			survey.setStatus(Survey.STATUS_INIT);
			survey.setCode("");			
			Date surveyDate=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String aa=sdf.format(surveyDate);		
			survey.setSurveydate(aa);
			surveyMapper.insert(survey);
		}		
	}

	@Override
	public List<SurveyVM> findAll() throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectAll();
	}

	@Override
	public SurveyVM findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectById(id);
	}


	@Override
	public List<SurveyVM> findSurveyByStatus(String status) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectByStatus(status);
	}

	@Override
	public Survey findSurveyById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyMapper.selectByPrimaryKey(id);
	}











}
