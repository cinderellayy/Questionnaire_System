package com.xeon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.xeon.action.AdminAction;
import com.xeon.auxiliary.User;
import com.xeon.dao.UserDao;
import com.xeon.dao.impl.UserDaoImpl;

public class Test1 {
	@SuppressWarnings({"resource" })
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = ctx.getBean("userDaoTarger",UserDaoImpl.class);
		AdminAction adminAction = ctx.getBean("adminAction",AdminAction.class);
		String data = "{\"username\":\"agzdjy\",\"sex\":\"man\",\"account\":\"2012081401\",\"password\":\"174151\",\"nation\":\"汉\"}";
		System.out.println(new Gson().fromJson(data, User.class).getAccount());
		
		adminAction.setJsonData(data);
		adminAction.addUser();
		
		System.out.println("success");
	}
}
