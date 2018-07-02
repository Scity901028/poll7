package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
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
	@Autowired
	private IAnswersService answersService;
	
	@ApiOperation(value="去审核课调",notes="返回课调基本信息以及课调中的主观题答案")
	@GetMapping(value="toCheckSurvey")
	public MsgResponse toCheckSurvey(long id){
		try {
			//1. 根据id查询课调信息
			SurveyVM surveyVM = surveyService.findById(id);
			//2. 根据id查询该课调下所有的答卷
			List<Answers> answers = answersService.findAnswersBySurveyId(id);
			//3. 根据答卷计算出平均分(单选题)
			double total = 0.0;	//所有学生平均分的总和
			for(Answers answer : answers){
				// 5|4
				String selectStr = answer.getSelections();
				if(selectStr!=null){
					//arr = ["5","4"]
					String[] arr = selectStr.split("[|]");
					Double singleTotal = 0.0;
					for(String a : arr){
						int select = Integer.parseInt(a);
						singleTotal += select;
					}
					double singleAverage = singleTotal/arr.length;
					total += singleAverage;
				}
			}
			double average = total / answers.size();
			//4. 设置平均分
			surveyVM.setAverage(average);	
			return MsgResponse.success("success", surveyVM);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="登录课调",notes="code表示课调编号")
	@GetMapping(value="loginSurvey")
	public MsgResponse loginSurvey(long code){
		try {
			//1. 通过id查询课调信息
			SurveyVM surveyVM = surveyService.findById(code);
			//2. 判断课调是否还在进行
			if(surveyVM.getStatus().equals(Survey.STATUS_BEGIN)){
				// 3. 判断用户是否已经完成答卷操作			
				return MsgResponse.success("success", surveyVM);
			} else {
				return MsgResponse.error("课调状态不合法："+surveyVM.getStatus());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}


	
	@ApiOperation(value="审核课调",notes="id为课调编号，status为审核状态，0为审核通过，1为审核不通过")
	@GetMapping(value="checkSurvey")
	public MsgResponse checkSurvey(long id,int status){	
		try {
			//通过id查询课调信息	
			Survey survey=surveyService.findSurveyById(id);
			String message="";
			if(survey.getStatus().equals(Survey.STATUS_NO_CHECK)){
				if(status==0){
					message="审核不通过";
					survey.setStatus(Survey.STATUS_CHECK_NOPASS);
				}else{
					message="审核通过";
					survey.setStatus(Survey.STATUS_CHECK_PASS);
				}
			}else{
				message="课调状态不合法";
			}						
			surveyService.saveOrUpdate(survey);			
			return MsgResponse.success(message, null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	
	@ApiOperation(value="通过状态查询课调",notes="")
	@GetMapping(value="findSurveyVMByStatus")
	public MsgResponse findSurveyVMByStatus(String status){
		//通过status查询课调信息		
		try {
			//通过status查询出课调信息
			List<SurveyVM> list=surveyService.findSurveyByStatus(status);			
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	@ApiOperation(value="关闭课调",notes="课调进入待审核的状态")
	@GetMapping(value="stopSurvey")
	public MsgResponse stopSurvey(long id){
		//通过id查询课调信息		
		try {
			//通过id查询出课调信息
			Survey survey=surveyService.findSurveyById(id);
			//修改课调对象
		    survey.setStatus(Survey.STATUS_NO_CHECK);	
			String code=survey.getId().toString();
			survey.setCode(code);			
			surveyService.saveOrUpdate(survey);
			
			return MsgResponse.success("关闭成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	@ApiOperation(value="开启课调",notes="")
	@GetMapping(value="startSurvey")
	public MsgResponse startSurvey(long id){
		//通过id查询课调信息		
		try {
			//通过id查询出课调信息
			Survey survey=surveyService.findSurveyById(id);
			//修改课调对象
		    survey.setStatus(Survey.STATUS_BEGIN);	
			String code=survey.getId().toString();
			survey.setCode(code);			
			surveyService.saveOrUpdate(survey);	
			//操作session
			
			return MsgResponse.success("开启成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	
	
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
