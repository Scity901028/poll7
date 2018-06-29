package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.QqExample;
import com.briup.apps.poll.bean.extend.QqVM;
import com.briup.apps.poll.dao.QqMapper;
import com.briup.apps.poll.dao.extend.QqVMMapper;
import com.briup.apps.poll.service.IQqService;

@Service
public class QqServiceImpl implements IQqService{
	@Autowired
	private QqMapper qqMapper;

	@Autowired
	private QqVMMapper qqVMMapper;
	@Override
	public List<Qq> findAll() throws Exception {
		QqExample example=new QqExample();
		return qqMapper.selectByExample(example);
	}

	@Override
	public List<QqVM> findAllQq() throws Exception {
		
		return qqVMMapper.selectAll();
	}
	

}
