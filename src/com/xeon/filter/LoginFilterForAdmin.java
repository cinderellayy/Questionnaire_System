package com.xeon.filter;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")//去除警告信息
public class LoginFilterForAdmin extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = arg0.getInvocationContext();
		@SuppressWarnings("rawtypes")
		Map session = ctx.getSession();
		//System.out.println("------------->1");
		if(session.get("LOGIN") != null ){

			//System.out.println("------------->2");
			boolean login = (Boolean)session.get("LOGIN");
			if(login == true){
				String role = (String)session.get("ROLE");
				if(role.equals("admin")){

					//System.out.println("------------->3");
					return arg0.invoke();
				}
				ServletActionContext.getRequest().getSession().setAttribute("SESSION_ROLE_MSG", "权限不足");
				return "role_error";
			}
		}
		ServletActionContext.getRequest().getSession().setAttribute("SESSION_LOG_MSG", "没有登陆");
	//	System.out.println("------------->1");
		return Action.LOGIN;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
	}

}
