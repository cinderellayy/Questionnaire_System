package com.xeon.action;


import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.xeon.auxiliary.User;
import com.xeon.service.AdminOfAnswerService;
import com.xeon.service.AdminOfOptionService;
import com.xeon.service.AdminOfPollService;
import com.xeon.service.AdminOfQuestionService;
import com.xeon.service.AdminOfUserService;
/**
 * 
 * @author Agzdjy
 * @param jsonData 前端发送的数据
 * @param logicView 返回的逻辑视图名
 * @param *Service 为管理员提供服务的接口,
 * @param page 这个参数是用来获分页查询是的页码，采用get方式转递
 *
 */
public class AdminAction {
	private String jsonData;
	private String  logicView;
	private String msg;
	private int page;
	private AdminOfUserService adminUserService;
	private AdminOfPollService adminPollService;
	private AdminOfQuestionService adminQuestionService;
	private AdminOfOptionService adminOptionService;
	private AdminOfAnswerService adminAnswerService;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public String getLogicView() {
		return logicView;
	}
	public void setLogicView(String logicView) {
		this.logicView = logicView;
	}
	public AdminOfUserService getAdminUserService() {
		return adminUserService;
	}
	public void setAdminUserService(AdminOfUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	public AdminOfPollService getAdminPollService() {
		return adminPollService;
	}
	public void setAdminPollService(AdminOfPollService adminPollService) {
		this.adminPollService = adminPollService;
	}
	public AdminOfQuestionService getAdminQuestionService() {
		return adminQuestionService;
	}
	public void setAdminQuestionService(AdminOfQuestionService adminQuestionService) {
		this.adminQuestionService = adminQuestionService;
	}
	public AdminOfOptionService getAdminOptionService() {
		return adminOptionService;
	}
	public void setAdminOptionService(AdminOfOptionService adminOptionService) {
		this.adminOptionService = adminOptionService;
	}
	public AdminOfAnswerService getAdminAnswerService() {
		return adminAnswerService;
	}
	public void setAdminAnswerService(AdminOfAnswerService adminAnswerService) {
		this.adminAnswerService = adminAnswerService;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	//添加用户
	public String addUser(){
		//System.out.println("我在adminAction中，我工作了");
		if(getJsonData() == null){
			setMsg("你可能重复提交了，导致录入失败，提示频繁刷新会导致重复提交");
			return "register";
		}
		//利用gson将json数据封装成user类型的数据，传递给adminUserService服务类
		//System.out.println(getJsonData().toString());
		String result = getAdminUserService().saveUser(new Gson().fromJson(getJsonData(), User.class));
		setMsg(result);
		return Action.SUCCESS;
	}
	
	//查找所有用户就是管理员首页显示的东西
	public String findUser(){
		String result = getAdminUserService().getUser(getPage());
		setMsg(result);
		return Action.SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
