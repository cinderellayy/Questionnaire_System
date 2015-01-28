package com.xeon.model;
/**
 * 
 * @author Agzdjy
 * @param id 逻辑主键
 * @param userModel 此项答题记录所属用户
 * @param pollModel 此项答题记录所属问卷
 * @param ip 此项答题记录来源地址
 *
 */
public class AnswerModel {
	private int id;
	private UserModel userModel;
	private PollModel pollModel;
	private String ip;
	private boolean exist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public PollModel getPollModel() {
		return pollModel;
	}
	public void setPollModel(PollModel pollModel) {
		this.pollModel = pollModel;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isExist() {
		return exist;
	}
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	
}
