package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="调查问卷模块相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	@Autowired 
	private IQuestionnaireService questionnaireService;
//	@ApiOperation(value="保存或修改问卷题目信息",
//			notes="如果题目id不为空表示更新操作，如果题目id为空表示插入操作，保存或者更新题目的时候级联保存或者更新选项")
//	@PostMapping("saveOrUpdateQuestionnaire")
//	public MsgResponse saveOrUpdateQuestionnaire(QuestionnaireVM questionnaire){
//		try {
//			//调用service层代码完成保存和更新操作
//			questionnaireService.saveOrUpdate(questionnaire);
//			return MsgResponse.success("success", null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return MsgResponse.error(e.getMessage());
//		}
//	}
	
	
	
	
	@ApiOperation(value="查询所有的题目信息",notes="每个题目信息中包含该题目下所有的选项信息")
	@GetMapping("findAllQuestionnaireVM")
	public MsgResponse findAllQuestionnaireVM(){
		try {
			List<QuestionnaireVM> list = questionnaireService.findAllQuestionnaireVM();
			return MsgResponse.success("success", list);
			} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有的题目信息")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestion(){
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("success", list);
		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
//	@ApiOperation(value="批量删除题目信息")
//	@PostMapping("batchDelete")
//	public MsgResponse batchDelete(long[] ids){
//		try {
//			List<Long> idList = new ArrayList<>();
//			for(long id : ids){
//				idList.add(id);
//			}
//			questionnaireService.batchDelete(idList);
//			return MsgResponse.success("批量删除成功", null);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return MsgResponse.error(e.getMessage());
//		}
//	}
	
}


