package com.xeon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xeon.action.AdminAction;
import com.xeon.auxiliary.User;
import com.xeon.model.UserModel;
import com.xeon.service.AdminOfUserService;

public class Test1 {
	@SuppressWarnings({"resource" })
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//AdminAction adminAction = ctx.getBean("adminAction",AdminAction.class);
		
		User u = new User();
		u.setAccount("2012081401");
		u.setNation("黎");
		u.setSex("man");
		u.setUsername("agzdjy");
		u.setPassword("174151");
		
		AdminOfUserService ad = ctx.getBean("adminUserService",AdminOfUserService.class);
		ad.saveUser(u);
		
		
	//	adminAction.setPage(0);
		//adminAction.findUser();
		//System.out.println("------------>"+adminAction.getMsg());
		/*UserDao userDao = ctx.getBean("userDaoTarger",UserDaoImpl.class);
		AdminAction adminAction = ctx.getBean("adminAction",AdminAction.class);
		String data = "{\"username\":\"agzdjy\",\"sex\":\"man\",\"account\":\"2012081401\",\"password\":\"174151\",\"nation\":\"汉\"}";
		System.out.println(new Gson().fromJson(data, User.class).getAccount());
		
		adminAction.setJsonData(data);
		adminAction.addUser();
		
		System.out.println("success");*/
		//AdminOfUserDaoImpl ad = ctx.getBean("adminUserDaoTarger",AdminOfUserDaoImpl.class);
		//List<UserModel> list = ad.getUserByUsername("agzdjy", 0, 10);
		//List<UserModel> list = ad.getUserByRequirement(new String[]{"nation","汉"}, 0, 10);
		
		//System.out.println(list.size());
		
		/*UserModel user = ad.getUserByAccount("fdsfd");
		System.out.println(user.getAccount());*/
	}
}
