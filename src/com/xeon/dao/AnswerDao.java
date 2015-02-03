package com.xeon.dao;

import java.util.List;

import com.xeon.model.AnswerModel;

public interface AnswerDao {
	public void save(AnswerModel answer) throws Exception;
	public void delete(AnswerModel answer) throws Exception;
	public void update(AnswerModel answer) throws Exception;
	//根据hql语句更新
	public void updateByHql(String hql) throws Exception;
	public AnswerModel getById(Integer id) throws Exception;
	public List<AnswerModel> get() throws Exception;
}
