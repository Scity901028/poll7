package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.extend.ClazzVMMapper;
import com.briup.apps.poll.service.IClazzService;

@Service
public class ClazzServiceImpl implements IClazzService {
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private ClazzVMMapper clazzVMMapper;
	
	@Override
	public List<Clazz> findAll() throws Exception {
		//创建空模板
		ClazzExample example = new ClazzExample();
		//调用QBE查询，并且将查询结果返回
		return clazzMapper.selectByExampleWithBLOBs(example);
	}
	
	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {	
		return clazzVMMapper.selectAll();
	}
	
	/*
	@Override
	public List<Clazz> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		ClazzExample example = new ClazzExample();
		example.createCriteria().andNameLike(keywords);
		return clazzMapper.selectByExampleWithBLOBs(example);
	}
	*/
	
	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		// TODO Auto-generated method stub
		for(long id : idList){
			clazzMapper.deleteByPrimaryKey(id);
		}
	}

	
	@Override
	public void update(Clazz clazz)throws Exception {
		// TODO Auto-generated method stub
		 clazzMapper.updateByPrimaryKey(clazz);
	}

	@Override
	public void save(Clazz clazz)throws Exception {
		// TODO Auto-generated method stub
		 clazzMapper.insert(clazz);
	}


   
}