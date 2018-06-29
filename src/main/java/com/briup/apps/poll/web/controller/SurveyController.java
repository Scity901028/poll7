package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课调相关接口")
@RestController
@RequestMapping("/Survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="保存或更新课调信息",notes="只需要输入courseId，userId，clazzId,questionnaire_id")
	@GetMapping(value="saveOrUpdate")
	public MsgResponse saveOrUpdate(Survey survey){
		try{
			surveyService.saveOrUpdate(survey);
			return  MsgResponse.success("保存或更新成功", null);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	
	@ApiOperation(value="通过ID查询所有的课调信息",notes="级联查询出所有的课程，班级，讲师，问卷")
	@GetMapping("findSurveyById")
	public MsgResponse findSurveyById(long id){
		try {
			SurveyVM list = surveyService.findById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("查询所有的课调信息")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM(){
		try {
			List<SurveyVM> list = surveyService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
