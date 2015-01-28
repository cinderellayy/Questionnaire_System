package com.xeon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xeon.dao.UserDao;
import com.xeon.dao.impl.UserDaoImpl;
import com.xeon.model.UserModel;

public class Test1 {
	@SuppressWarnings({"resource" })
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = ctx.getBean("userDaoTarger",UserDaoImpl.class);
		UserModel user = new UserModel();
		user.setUsername("admin1");
		user.setPassword("admin");
		user.setSex("man");
		user.setNation("汉");
		user.setRole("admin");
		userDao.save(user);
		System.out.println("success");
	}
}
