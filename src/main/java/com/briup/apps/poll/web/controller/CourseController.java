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
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课程管理相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	/**
	 * @return
	 */
	@Autowired
	private ICourseService courseService;
	
	@ApiOperation(value="保存或更新课程信息",notes="如果参数包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
	@PostMapping("saveOrupdateCourse")//更新
	public MsgResponse saveOrupdateCourse(Course course){
		try {
			if(course!=null && course.getId()!=null){
				courseService.update(course);
			}
			else{
				courseService.save(course);
			}
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	// 关键字查询
			@ApiOperation("根据关键字查看课程信息")
			@GetMapping("/queryByKeyWords")
			public MsgResponse query(String keywords) {
				try {
					List<Course> list = courseService.query(keywords);
					return MsgResponse.success("成功", list);
				} catch (Exception e) {
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
			}

	@ApiOperation(value="通过课程ID删除课程信息")
	@GetMapping("deleteByIdCourse")//删除
	public MsgResponse deleteByIdCourse(@RequestParam Long id){
		try {
			courseService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}

	@ApiOperation("通过ID查询所有的班级信息")
	@GetMapping("selectCourseById")
	public MsgResponse selectCourseById(long id) {
		try {
			Course list = courseService.selectById(id);

			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="批量删除课程信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			List<Long> idList = new ArrayList<>();
			for(long id : ids){
				idList.add(id);
			}
			courseService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有的课程信息")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
















