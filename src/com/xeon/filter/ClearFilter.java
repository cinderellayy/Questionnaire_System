package com.xeon.filter;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ClearFilter extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3546421304353922824L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("我进到拦截器里面了");
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ctx.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		return arg0.invoke();
	}

}
