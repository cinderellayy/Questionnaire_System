package com.xeon.service.impl;

import java.sql.Date;

import com.google.gson.Gson;
import com.xeon.dao.AdminOfOptionDao;
import com.xeon.dao.AdminOfPollDao;
import com.xeon.dao.AdminOfQuestionDao;
import com.xeon.dao.AllowCollegeDao;
import com.xeon.dao.AnswerDao;
import com.xeon.dao.OptionDao;
import com.xeon.dao.PollDao;
import com.xeon.dao.QuestionDao;
import com.xeon.model.PollModel;
import com.xeon.service.AdminOfPollService;
import com.xeon.util.Util;

public class AdminOfPollServiceImpl implements AdminOfPollService{
	private Util util;
	private AdminOfPollDao adminPollDao;
	private AdminOfQuestionDao adminQuestionDao;
	private AdminOfOptionDao adminOfOptionDao;
	private PollDao pollDao;
	private OptionDao optionDao;
	private QuestionDao questionDao;
	private AllowCollegeDao allowCollegeDao;
	private AnswerDao answerDao;

	@Override
	public String save(String jsonData) {
		// TODO Auto-generated method stub
		try{
			//为了能将这个直接存储，我将hibernate设置成one一方管理关联关系，导致sql语句变长
			PollModel poll = new Gson().fromJson(jsonData, PollModel.class);
			poll.setPoll_upload_time(new Date(new java.util.Date().getTime()).toString());
			//在这里保留各自保存的方法
			getPollDao().save(poll);
			//System.out.println(new Gson().toJson(poll).toString());
			return "添加成功";
		}catch(Exception e){
			e.printStackTrace();
			return "添加失败";
		}
	}

	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}

	public AdminOfPollDao getAdminPollDao() {
		return adminPollDao;
	}

	public void setAdminPollDao(AdminOfPollDao adminPollDao) {
		this.adminPollDao = adminPollDao;
	}

	public AdminOfQuestionDao getAdminQuestionDao() {
		return adminQuestionDao;
	}

	public void setAdminQuestionDao(AdminOfQuestionDao adminQuestionDao) {
		this.adminQuestionDao = adminQuestionDao;
	}

	public AdminOfOptionDao getAdminOfOptionDao() {
		return adminOfOptionDao;
	}

	public void setAdminOfOptionDao(AdminOfOptionDao adminOfOptionDao) {
		this.adminOfOptionDao = adminOfOptionDao;
	}

	public PollDao getPollDao() {
		return pollDao;
	}

	public void setPollDao(PollDao pollDao) {
		this.pollDao = pollDao;
	}

	public OptionDao getOptionDao() {
		return optionDao;
	}

	public void setOptionDao(OptionDao optionDao) {
		this.optionDao = optionDao;
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public AllowCollegeDao getAllowCollegeDao() {
		return allowCollegeDao;
	}

	public void setAllowCollegeDao(AllowCollegeDao allowCollegeDao) {
		this.allowCollegeDao = allowCollegeDao;
	}

	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String jsonData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getByRequirement(String requirement, String data, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
