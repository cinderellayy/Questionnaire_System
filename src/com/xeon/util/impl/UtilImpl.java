package com.xeon.util.impl;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.xeon.util.Util;

public class UtilImpl implements Util{

	@Override
	public HttpSession getSession() {
		// TODO Auto-generated method stub
		//获取容器上下文信息
		return ServletActionContext.getRequest().getSession();
	}

	@Override
	public void clean() {
		HttpServletResponse rp = ServletActionContext.getResponse();
		rp.setHeader("Cache-Control","no-cache");
		rp.setHeader("Cache-Control","no-store");
	}

}