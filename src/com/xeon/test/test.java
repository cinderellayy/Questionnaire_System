package com.xeon.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.xeon.auxiliary.User;

public class test {
	public static void main(String[] args){
		/*Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		System.out.println(c.getWeekYear());*/
		/*String data = "{\"username\":\"43243\",\"sex\":\"man\",\"account\":\"43243\",\"password\":\"4324\",\"nation\":\"汉\"}";
		String data1 = "{\"username\":\"1312\",\"sex\":\"man\",\"account\":\"1231\",\"password\":\"132\",\"nation\":\"汉族\"}";
		Gson g = new Gson();
		User user = g.fromJson(data1, User.class);
		System.out.println(user.getUsername());*/
		
		Properties pod = new Properties();
		try {
			String fileName = "/WEB-INF/collegeInformation.properties";
			pod.load(User.class.getResourceAsStream("/collegeInformation.properties"));
			//pod.
			//Collection<Object> set = pod.values();
			Set set = pod.entrySet();
			//Set ss = pod.values()
			Iterator i = set.iterator();
			while(i.hasNext()){
			 	String d =  i.next().toString();
				String[] s = d.split("=");
			//	System.out.println(i.next().toString());
				System.out.println("key---->"+s[0].trim()+"******"+"value------->"+s[1].trim());
			}
			
			System.out.println("------->"+set.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(JSONObject.fromObject(data).toString());
	}
}
