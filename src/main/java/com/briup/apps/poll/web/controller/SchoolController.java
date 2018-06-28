package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="学校信息相关接口")
@RestController
@RequestMapping("/school")
public class SchoolController {
	/**
	 * @return
	 */
	@Autowired
	private ISchoolService schoolService;
	
	
	@ApiOperation(value="保存或更新学校信息",notes="如果参数包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
	@PostMapping("saveOrupdateSchool")//更新
	public MsgResponse saveOrupdateSchool(School school){
		try {
			if(school!=null && school.getId()!=null){
				schoolService.update(school);
			}
			else{
				schoolService.save(school);
			}
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	// 关键字查询
			@ApiOperation("根据关键字查看学校信息")
			@GetMapping("/queryByKeyWords")
			public MsgResponse query(String keywords) {
				try {
					List<School> list = schoolService.query(keywords);
					return MsgResponse.success("成功", list);
				} catch (Exception e) {
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
			}

	@GetMapping("deleteByIdSchool")//删除
	public MsgResponse deleteByIdSchool(@RequestParam Long id){
		try {
			schoolService.deleteById(id);
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
			schoolService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool(){
		try {
			List<School> list = schoolService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
