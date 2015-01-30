package com.xeon.service;

import java.util.List;

import com.xeon.auxiliary.User;
import com.xeon.model.UserModel;

public interface AdminOfUserService {
	public UserModel getUserById(Integer id);
	public UserModel getUserByAccount(String account);
	public List<UserModel> getUserByRequirement(String requirement,String data);//根据条件查找
	public List<UserModel> getUser();
	public String deleteUserById(Integer id);
	public String deleteUserByAccount(String account);
	public String deleteUserByRequirement(String requirement,String data);//根据条件删除
	public String deleteUser(UserModel user);
	public String updateUserById(Integer id);
	public String updateUserByAccount(String account);
	public String updateUserByRequirement(String requirement,String data);//根据条件更新
	public String updateUser(UserModel user);
	public String saveUser(User user);//传递的服务类型的use不是model中User会在服务类中将其包装成UserModel;
}
