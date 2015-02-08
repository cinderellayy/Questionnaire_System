package com.xeon.service;

public interface AdminOfPollService {
	public String save(String jsonData);
	public String deleteById(Integer id);
	public String deleteByName(String name);
	public String update(String jsonData);
	public String getById(Integer id);
	public String getByRequirement(String requirement,String data,int page);//根据条件查找
	public String getByName(String name);
	public String get(int page);
}
