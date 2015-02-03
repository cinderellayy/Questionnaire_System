package com.xeon.test;

import java.net.URLDecoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xeon.action.AuxiliaryAction;

public class Test1 {
	@SuppressWarnings({"resource" })
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AuxiliaryAction a = ctx.getBean("auxiliaryAction",AuxiliaryAction.class);
		a.setData("网络工程");
		a.studentClass();
		String result = a.getMsg();
		result = result.replace("%20", "\\+");
		result = URLDecoder.decode(result,"utf-8");
		System.out.println(result);
		/*Set<String> set = new  HashSet<String>();
		String s = "12123";
		set.add(s);
		set.add(s);
		System.out.println(set.size());
*/		/*AdminAction adminAction = ctx.getBean("adminAction",AdminAction.class);
		adminAction.setPage(-1);
		adminAction.findUser();
		String result = adminAction.getMsg();
		result = result.replace("%20", "\\+");
		result = URLDecoder.decode(result,"utf-8");
		System.out.println(result+"         page----->"+adminAction.getPage());*/
		
		/*User u = new User();
		u.setAccount("2012081401");
		u.setNation("黎");
		u.setSex("man");
		u.setUsername("agzdjy");
		u.setPassword("174151");
		
		AdminOfUserService ad = ctx.getBean("adminUserService",AdminOfUserService.class);
		ad.saveUser(u);*/
		
		
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
		/*AdminOfUserDaoImpl ad = ctx.getBean("adminUserDaoTarger",AdminOfUserDaoImpl.class);
		//List<UserModel> list = ad.getUserByUsername("agzdjy", 0, 10);
		List<UserModel> list = ad.getUserByRequirement(new String[]{"nation","true"}, 0);*/
		
		/*String s = "and;username";
		s = s.replaceAll("([';])+|(--)+", " ");
		System.out.println(s+"12");*/
		/*UtilImpl u = new UtilImpl();
		System.out.println(u.checkStr("and;username"));*/
		/*UserModel user = ad.getUserByAccount("fdsfd");
		System.out.println(user.getAccount());*/
	}
}
