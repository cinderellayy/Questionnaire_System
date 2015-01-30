package com.xeon.dao;

import java.util.List;

import com.xeon.model.UserModel;

public interface UserDao {
	public void save(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	public UserModel getFromAccount(String account) throws Exception;
	public UserModel getFromId(Integer id) throws Exception;
	public List<UserModel> get() throws Exception;
	public int getNumberOfUser() throws Exception;
}
