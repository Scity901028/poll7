package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;
	@Autowired
	private QuestionMapper questionMapper;
//	@Autowired
//	private QuestionnaireMapper questionMapper;

//	@Override
//	public List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception {
//		return questionMapper.findAll();
//	}

	@Override
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		return questionnaireMapper.selectByExample(example);
	}

@Override
public List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception {
	return questionnaireVMMapper.selectAll();
}

//	@Override
//	public void saveOrUpdate(QuestionnaireVM questionVM) throws Exception {
//		//0. 从questionVM中拆分出来question options
//		Questionnaire question = new Questionnaire();
//		question.setId(questionnaireVM.getId());
//		question.setName(questionnaireVM.getName());
//		question.setQuestiontype(questionnaireVM.getQuestionnaireType());
//		List<Options> options = questionnaireVM.getOptions();
//		
//		if(questionnaire.getId()!=null){
//			//修改操作,作业。。。（问题 修改， 删除，添加）
//			
//		} else{
//			//保存操作
//			//1. 保存问题信息
//			questionnaireMapper.insert(questionnaire);
//			//获取问题的主键
//			long id = questionnaire.getId();
//			//2. 保存选项信息
//			for(Options option: options){
//				option.setQuestionnaireId(id);
//				optionsMapper.insert(option);
//			}
//			
//		}
//		
//	}
//	@Override
//	public void batchDelete(List<Long> ids) throws Exception {
//		for(long id : ids){
//			questionMapper.deleteByPrimaryKey(id);
//		}
//	}
//
//}

}
