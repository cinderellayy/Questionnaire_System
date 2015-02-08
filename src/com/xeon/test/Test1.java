package com.xeon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xeon.auxiliary.User;
import com.xeon.service.impl.AdminOfUserServiceImpl;

public class Test1 {
	@SuppressWarnings({"resource" })
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//数据库重建
		AdminOfUserServiceImpl admin = ctx.getBean("adminUserService",AdminOfUserServiceImpl.class);
		User user = new User();
		user.setAccount("2012081401");
		user.setNation("黎族");
		user.setPassword("174151");
		user.setSex("man");
		user.setUsername("agzdjy");
		admin.saveUser(user);
		
	}
}
