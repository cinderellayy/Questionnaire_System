package com.xeon.action;

public class JumpAction {
	private String logicView;
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
}
