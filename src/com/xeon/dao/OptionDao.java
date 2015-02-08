package com.xeon.dao;

import java.util.List;

import com.xeon.model.OptionModel;

public interface OptionDao {
	public void save(OptionModel option) throws Exception;
	public void delete(OptionModel option) throws Exception;
	public void update(OptionModel option) throws Exception;
	public List<OptionModel> find() throws Exception;
	public Integer getNumber() throws Exception;
}
