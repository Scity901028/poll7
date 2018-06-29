package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.bean.extend.ClazzVM;

public interface IAnswersService {
	
	List<AnswersVM> findAll() throws Exception;
	
	AnswersVM findById(long id) throws Exception;
}
