package com.xeon.action;

import com.opensymphony.xwork2.Action;
import com.xeon.service.LogService;
/**
 * 
 * @author Agzdjy
 * @param username password verifycode 与前端对应
 * @param msg 用于返回逻辑视图的
 *
 */
public class LogAction {
	private String username;
	private String password;
	private String verifycode;
	private String msg;
	private LogService logService;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public String login(){
		String result = getLogService().login(getUsername(), getPassword(), getVerifycode());
		setMsg(result);
		//System.out.println(result);
		if(result.equals("fail")){
			return Action.LOGIN;
		}
		if(result.equals("error")){
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
}
