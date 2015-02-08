package com.xeon.dao;

import java.util.List;

import com.xeon.model.QuestionModel;

public interface QuestionDao {
	public void save(QuestionModel question) throws Exception;
	public void delete(QuestionModel question) throws Exception;
	public void update(QuestionModel question) throws Exception;
	public List<QuestionModel> find() throws Exception;
	public Integer getNumber() throws Exception;
}
