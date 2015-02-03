package com.xeon.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xeon.dao.UserDao;
import com.xeon.model.UserModel;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void save(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	@Override
	public void delete(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

	@Override
	public void update(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserModel getFromAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		List<UserModel> list = (List<UserModel>) getHibernateTemplate().find("from UserModel user where user.account = ? and user.exist = false",account);
		for(UserModel user : list){
			return user;
		}
		return null;
	}

	@Override
	public UserModel getFromId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(UserModel.class, id);
	}

	/**
	 * 查询的时候只查找没有被删除的人
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> get() throws Exception {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from UserModel user where user.exist = false");
	}

	/**
	 * 返回记录数
	 */
	@Override
	public int getNumberOfUser() throws Exception {
		// TODO Auto-generated method stub
		return get().size();
	}

}
