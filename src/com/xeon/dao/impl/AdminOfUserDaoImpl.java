package com.xeon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xeon.dao.AdminOfUserDao;
import com.xeon.model.UserModel;

/**
 * 
 * @author Agzdjy
 * 后期可能会涉及分页查找技术
 * 2015-2-1已经实现分页查询
 */
public class AdminOfUserDaoImpl extends HibernateDaoSupport implements AdminOfUserDao{

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

	@Override
	public UserModel getUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(UserModel.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserModel getUserByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		List<UserModel> list = getHibernateTemplate().find("from UserModel user where user.account=? and user.exist = false",account);
		for(UserModel user : list){
			return user;
		}
		return null;
	}

	/**
	 * 根据条件查找，就是按给定条件查找学生
	 * 这个方法可能不稳定
	 * 经过测试
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> getUserByRequirement(final String[] data,final int beginIndex) throws Exception {
		// TODO Auto-generated method stub
		return getHibernateTemplate().executeFind(new HibernateCallback<List<UserModel>>() {

		@Override
		public List<UserModel> doInHibernate(Session arg0)
				throws HibernateException, SQLException {
			// TODO Auto-generated method stub
			String hql = "from UserModel user where user.exist = false and user."+data[0].trim()+" =:param";
			//从下下标beginIndex开始取，每次做多取10个结果
			Query q = arg0.createQuery(hql).setString("param", data[1].trim()).setFirstResult(beginIndex).setMaxResults(10);
			return q.list();
		}
		
	});
		//这个很重要
	/*	String sql = "from UserModel use where user."+data[0].trim()+" = "+data[1].trim();
		return getHibernateTemplate().find(sql);*/
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> getUser(final int beginIndex) throws Exception {
		// TODO Auto-generated method stub
		return getHibernateTemplate().executeFind(new HibernateCallback<List<UserModel>>() {

		@Override
		public List<UserModel> doInHibernate(Session arg0)
				throws HibernateException, SQLException {
			// TODO Auto-generated method stub
			Query q = arg0.createQuery("from UserModel user where user.exist = false").setFirstResult(beginIndex).setMaxResults(10);
			return q.list();
		}
		
	});
		//return getHibernateTemplate().find("from UserModel");
	}

}
