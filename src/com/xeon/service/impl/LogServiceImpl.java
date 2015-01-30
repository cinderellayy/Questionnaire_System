package com.xeon.service.impl;

import javax.servlet.http.HttpSession;

import com.xeon.dao.UserDao;
import com.xeon.model.UserModel;
import com.xeon.service.LogService;
import com.xeon.util.Util;
/**
 * 
 * @author Agzdjy
 * @param userDao 与之相关的接口
 * @param fail 当返回这个时表示登陆失败 success表示登陆成功
 *
 */
public class LogServiceImpl implements LogService{

	private UserDao userDao;
	private Util util;
	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String login(String account, String password, String verifycode) {
		// TODO Auto-generated method stub
		HttpSession session = getUtil().getSession();
		try{
			if(account == null || password == null || verifycode == null || session.getAttribute("VERIFYCODE") == null){
				session.setAttribute("SESSION_LOG_MSG", "没有登陆");
				return "fail";
			}
			if(!verifycode.equals(session.getAttribute("VERIFYCODE"))){
				session.setAttribute("SESSION_LOG_MSG", "验证码错误");
				return "fail";
			}
			UserModel user = userDao.getFromAccount(account);
			if(user != null){
				if(user.getPassword().equals(password)){
					String role = user.getRole();
					session.setAttribute("LOGIN", true);
					session.setAttribute("ROLE", role);
					session.setAttribute("USER",user);
					return role;
				}
				session.setAttribute("SESSION_LOG_MSG", "密码错误");
				//System.out.println("密码");
				return "fail";
			}
			session.setAttribute("SESSION_LOG_MSG", "用户名错误");
			//System.out.println("用户民");
			return "fail";
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("SESSION_LOG_MSG", "Dao层错误，请联系开发者");
			return "error";
		}
	}

	@Override
	public String logout() {
		// TODO Auto-generated method stub
		//移除所有之前定义的session
		getUtil().getSession().invalidate();
		return "success";
	}

}
