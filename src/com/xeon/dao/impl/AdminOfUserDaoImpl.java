package com.xeon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xeon.dao.AdminOfUserDao;
import com.xeon.model.UserModel;

public class AdminOfUserDaoImpl extends HibernateDaoSupport implements AdminOfUserDao{

	@Override
	public void save(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	@Override
	public void delete(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel getUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUserByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUserByNation(String nation) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUserByCollege(String college) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUserByGrade(String grade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUserByStudentClass(String studentClass)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUserByRequirement(String[] data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUser() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
