package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.dao.extend.AnswersVMMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService {
    @Autowired 
    private AnswersVMMapper answerVMMapper;
    
	@Override
	public List<AnswersVM> findAll() throws Exception {
		return answerVMMapper.selectAll();
	}

	@Override
	public AnswersVM findById(long id) throws Exception {
		return answerVMMapper.selectById(id);
	}

}
