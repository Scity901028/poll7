package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.extend.QqVM;

public interface IQqService {
	List<Qq> findAll() throws Exception;
	
	List<QqVM> findAllQq() throws Exception;
}
