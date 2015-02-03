package com.xeon.dao;

import java.util.List;

import com.xeon.model.UserModel;

public interface AdminOfUserDao {
	public void save(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	public UserModel getUserById(Integer id) throws Exception;
	public UserModel getUserByAccount(String account) throws Exception;
	public List<UserModel> getUserByRequirement(final String[] data,int beginIndex,int endIndex) throws Exception;//自动判断条件查找
	public List<UserModel> getUser(final int beginIndex,int endIndex) throws Exception;
}
