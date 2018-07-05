package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.dao.extend.AnswersVMMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService {
    @Autowired 
    private AnswersVMMapper answerVMMapper;
    @Autowired 
    private AnswersMapper answerMapper;
	@Override
	public List<AnswersVM> findAll() throws Exception {
		return answerVMMapper.selectAll();
	}

	@Override
	public AnswersVM findById(long id) throws Exception {
		return answerVMMapper.selectById(id);
	}

	@Override
	public void saveOrUpdate(Answers answers) throws Exception {
		// TODO Auto-generated method stub
		if(answers.getId()!=null){
			answerMapper.updateByPrimaryKey(answers);
		}else{
			answerMapper.insert(answers);
		}
	}

	@Override
	public List<Answers> findAnswersBySurveyId(long surveyId) throws Exception {
		// TODO Auto-generated method stub		
		AnswersExample example = new AnswersExample();
		example.createCriteria().andSurveyIdEqualTo(surveyId);
		return answerMapper.selectByExample(example);
	}
	
	
	

}
