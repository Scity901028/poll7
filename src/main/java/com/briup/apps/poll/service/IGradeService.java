package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;

public interface IGradeService {
	List<Grade> findAll() throws Exception;

	List<GradeVM> findAllGradeVM() throws Exception;

    //void saveOrUpdate(GradeVM gradeVM) throws Exception;

	void batchDelete(List<Long> ids) throws Exception;

	void deleteById(long id) throws Exception;

	void saveOrUpdate(Grade grade) throws Exception;
}
