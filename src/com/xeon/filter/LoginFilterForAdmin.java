package com.xeon.filter;

import java.util.Map;

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
		if(session.get("LOGIN") != null ){
			boolean login = (Boolean)session.get("LOGIN");
			if(login == true){
				String role = (String)session.get("ROLE");
				if(role.equals("admin")){
					return arg0.invoke();
				}
			}
		}
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
