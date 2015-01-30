package com.xeon.action;

import com.opensymphony.xwork2.Action;
import com.xeon.service.LogService;
/**
 * 
 * @author Agzdjy
 * @param username password verifycode 与前端对应
 * @param logicView 用于返回逻辑视图的
 *
 */
public class LogAction {
	private String account;
	private String password;
	private String verifycode;
	private String logicView;
	private LogService logService;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getLogicView() {
		return logicView;
	}
	public void setLogicView(String logicView) {
		this.logicView = logicView;
	}
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public String login(){
		String result = getLogService().login(getAccount(), getPassword(), getVerifycode());
		setLogicView(result);
		if(result.equals("fail")){
			return Action.LOGIN;
		}
		if(result.equals("error")){
			return Action.ERROR;
		}
		return result;
	}
	public String logout(){
		getLogService().logout();
		return Action.LOGIN;
	}
}
