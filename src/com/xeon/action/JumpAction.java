package com.xeon.action;

import com.xeon.util.Util;

public class JumpAction {
	private String logicView;
	private Util util;
	private int id;
	public Util getUtil() {
		return util;
	}
	public void setUtil(Util util) {
		this.util = util;
	}
	public String getLogicView() {
		return logicView;
	}
	public void setLogicView(String logicView) {
		this.logicView = logicView;
	}
	public String adminUser(){
		//System.out.println("我在这里JumpAction");
		setLogicView("user");
		return "admin";
	}
	public String adminPoll(){
		setLogicView("poll");
		return "admin";
	}
	public String adminAnswer(){
		setLogicView("answer");
		return "admin";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String adminUpdateUser(){
		getUtil().getSession().setAttribute("SESSION_UPDATEUSER_ID", getId());
		return "updateUser";
	}
}
