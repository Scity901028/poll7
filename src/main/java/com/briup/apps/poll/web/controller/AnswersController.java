package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "学生答卷相关接口")
@RestController
@RequestMapping("/Answers")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;
	
	@ApiOperation(value = "查询所有的答卷信息", notes = "")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM() {
		try {
			List<AnswersVM> list = answersService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "通过id查询所有的答卷信息", notes = "")
	@GetMapping("findById")
	public MsgResponse findById(long id) {
		try {
			AnswersVM list = answersService.findById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="提交答卷，每个学生提交一份")
	@PostMapping("submitAnswers")
	public MsgResponse submitAnswers(Answers answers){
		try {
			// 1. 判断用户是否具有答卷权限（是否提交过）
			
			// 2. 保存答卷信息
			answersService.saveOrUpdate(answers);
			return MsgResponse.success("提交成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
}
