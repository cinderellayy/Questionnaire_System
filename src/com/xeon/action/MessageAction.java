package com.xeon.action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.Action;
import com.xeon.util.Util;

public class MessageAction {
	private Util util;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}
	public String execute(){
		HttpSession session = getUtil().getSession();
		setMsg((String)session.getAttribute("SESSION_LOG_MSG"));
		session.removeAttribute("SESSION_LOG_MSG");//一次请求之后立即清空此次登陆相关的提示信息
		return Action.SUCCESS;
	}
}
