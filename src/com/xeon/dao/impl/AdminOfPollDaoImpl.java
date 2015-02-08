package com.xeon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xeon.dao.AdminOfPollDao;
import com.xeon.model.PollModel;

public class AdminOfPollDaoImpl extends HibernateDaoSupport implements AdminOfPollDao{

	@Override
	public void save(PollModel poll) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PollModel poll) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PollModel poll) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PollModel> find(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PollModel findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PollModel findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PollModel> findByRequirement(String requirement, String data)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
