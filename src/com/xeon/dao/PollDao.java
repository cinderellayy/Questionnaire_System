package com.xeon.dao;

import java.util.List;

import com.xeon.model.PollModel;

public interface PollDao {
	public void save(PollModel poll) throws Exception;
	public void delete(PollModel poll) throws Exception;
	public void update(PollModel poll) throws Exception;
	public List<PollModel> find() throws Exception;
	public Integer getNumber() throws Exception;
}
