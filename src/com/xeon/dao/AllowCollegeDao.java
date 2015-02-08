package com.xeon.dao;

import java.util.List;

import com.xeon.model.AllowCollege;

public interface AllowCollegeDao {
	public void save(AllowCollege allowCollege) throws Exception;
	public void delete(AllowCollege allowCollege) throws Exception;
	public void update(AllowCollege allowCollege) throws Exception;
	public List<AllowCollege> find() throws Exception;
	public Integer getNumber() throws Exception;
}
