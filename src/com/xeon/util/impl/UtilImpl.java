package com.xeon.util.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.regex.Pattern;

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

	/**
	 * md5加密算法
	 */
	@Override
	public String MD5(String password) {
		// TODO Auto-generated method stub
		try{
			// 获得MD5摘要算法的 MessageDigest 对象
			 MessageDigest md =  MessageDigest.getInstance("MD5");
			 // 使用指定的字节更新摘要
			 md.update(password.getBytes());
			 //md.digest返回md5 hash值为8字符串
			 return new BigInteger(1,md.digest()).toString(16);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String encode(String result) {
		// TODO Auto-generated method stub
		try {
			result = URLEncoder.encode(result,"utf-8");
			result = result.replace("\\+", "%20");
			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String decode(String str) {
		// TODO Auto-generated method stub
		try {
			str = URLDecoder.decode(str,"utf-8");
			return str;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 防止sql注入的
	 */
	@Override
	public String sqlInsert(String str) {
		// TODO Auto-generated method stub
		str = str.replaceAll("([';])+|(--)+", "");
		return str;
	}

	//校验数据是否合法针对sql注入
	@Override
	public boolean checkStr(String str) {
		// TODO Auto-generated method stub
		return Pattern.matches(".*([';]+|(--)+).*", str);
	}
	
}