package com.briup.apps.poll.service.impl;

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

	@GetMapping("findAll")
	@Override
	public List<Survey> findAll() throws Exception {
		// 模板
		SurveyExample example = new SurveyExample();
		// 调用QBE，并将结果返回
		return surveyMpper.selectByExample(example);

	}

	@GetMapping("findAllSurveyVM")
	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMpper.selectAll();
	}

}
