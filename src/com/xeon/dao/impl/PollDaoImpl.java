package com.xeon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xeon.dao.PollDao;
import com.xeon.model.PollModel;

public class PollDaoImpl extends HibernateDaoSupport implements PollDao{

	@Override
	public void save(PollModel poll) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(poll);
	}

	@Override
	public void delete(PollModel poll) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(poll);
	}

	@Override
	public void update(PollModel poll) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(poll);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PollModel> find() throws Exception {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from PollModel poll where poll.exist = false");
	}

	@Override
	public Integer getNumber() throws Exception {
		// TODO Auto-generated method stub
		return find().size();
	}

}
