package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="选项相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
	/**
	 * @return
	 */
	@Autowired
	private IOptionsService optionsService;
	
	@GetMapping("deleteByIdOptions")//删除
	public MsgResponse deleteByIdOptions(@RequestParam Long id){
		try {
			optionsService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}

	@GetMapping("findAllOptions")
	public MsgResponse findAllOptions(){
		try {
			List<Options> list = optionsService.findAll();
			
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("添加选项信息")
	@PostMapping("saveOptions")
	public MsgResponse saveClazz(Options options) {
		try {
			optionsService.save(options);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("修改选项信息")
	@PostMapping("updateOptions")
	public MsgResponse updateClazz(Options Options) {
		try {
			optionsService.update(Options);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
			
	
}
