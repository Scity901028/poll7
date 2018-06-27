package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.extend.QqVM;
import com.briup.apps.poll.service.IQqService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题问卷相关接口")
@RestController
@RequestMapping("/questionnairequestion")
public class QqController {
	@Autowired
	private IQqService qqService;
	
	@ApiOperation(value="查询问卷问题信息",notes="问卷的信息和问题的信息")
	@GetMapping("findAllQqVM")
	public MsgResponse findAllQqVM() {
		try {
			List<QqVM> list=qqService.findAllQq();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="查询问卷问题信息")
	@GetMapping("findAllQq")
	public MsgResponse findAllQq() {
		try {
			List<Qq> list=qqService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
