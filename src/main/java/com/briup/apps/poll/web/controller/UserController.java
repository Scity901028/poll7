package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="教师管理相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	/**
	 * @return
	 */
	@Autowired
	private IUserService userService;
	
	
	@ApiOperation(value="保存或更新教师信息",notes="如果参数包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
	@PostMapping("saveOrupdateUser")//更新
	public MsgResponse saveOrupdateUser(User user){
		try {
			if(user!=null && user.getId()!=null){
				userService.update(user);
			}
			else{
				userService.save(user);
			}
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	// 关键字查询
			@ApiOperation("根据关键字查看教师信息")
			@GetMapping("/queryByKeyWords")
			public MsgResponse query(String keywords) {
				try {
					List<User> list = userService.query(keywords);
					return MsgResponse.success("成功", list);
				} catch (Exception e) {
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
			}

	@GetMapping("deleteByIdUser")//删除
	public MsgResponse deleteByIdUser(@RequestParam Long id){
		try {
			userService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}

	
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			List<Long> idList = new ArrayList<>();
			for(long id : ids){
				idList.add(id);
			}
			userService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
