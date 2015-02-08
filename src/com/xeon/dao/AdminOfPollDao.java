package com.xeon.dao;

import java.util.List;

import com.xeon.model.PollModel;

public interface AdminOfPollDao {
	public void save(PollModel poll) throws Exception;
	public void delete(PollModel poll) throws Exception;
	public void update(PollModel poll) throws Exception;
	public List<PollModel> find(Integer page) throws Exception;
	public PollModel findById(Integer id) throws Exception;
	public PollModel findByName(String name) throws Exception;
	public List<PollModel> findByRequirement(String requirement,String data) throws Exception;
}
