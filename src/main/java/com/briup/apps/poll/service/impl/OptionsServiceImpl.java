package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;

@Service
public class OptionsServiceImpl implements IOptionsService{
	@Autowired
	private OptionsMapper optionsMapper;

	@Override
	public List<Options> findAll() throws Exception {
		OptionsExample example = new OptionsExample();
		//调用QBE查询，并且将查询结果返回
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		optionsMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void save(Options options) throws Exception {
		optionsMapper.insert(options);
		
	}

	@Override
	public void update(Options options) throws Exception {
		optionsMapper.updateByPrimaryKey(options);
		
	}
	
	
	

}
