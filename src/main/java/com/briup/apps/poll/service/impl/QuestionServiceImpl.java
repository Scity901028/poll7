package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	
	
	@Override
	public List<Question> findAll() throws Exception {
		QuestionExample example = new QuestionExample();
		return questionMapper.selectByExample(example);
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		return questionVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(QuestionVM questionVM) throws Exception {
		//0. 从questionVM中拆分出来question options
		Question question = new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		List<Options> options = questionVM.getOptions();
		
		if(question.getId()!=null){
			//修改操作,作业。。。（问题 修改， 删除，添加）
			
		} else{
			//保存操作
			//1. 保存问题信息
			questionMapper.insert(question);
			//获取问题的主键
			long id = question.getId();
			//2. 保存选项信息
			for(Options option: options){
				option.setQuestionId(id);
				optionsMapper.insert(option);
			}
			
		}
		
	}
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id : ids){
			questionMapper.deleteByPrimaryKey(id);
		}
	}

}
















