package com.xeon.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletConfig;

import com.xeon.auxiliary.User;
import com.xeon.dao.AdminOfUserDao;
import com.xeon.model.UserModel;
import com.xeon.service.AdminOfUserService;
import com.xeon.util.Util;

public class AdminOfUserServiceImpl implements AdminOfUserService{

	private AdminOfUserDao adminUserDao;
	private Util util;
	public AdminOfUserDao getAdminUserDao() {
		return adminUserDao;
	}
	public void setAdminUserDao(AdminOfUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	public Util getUtil() {
		return util;
	}
	public void setUtil(Util util) {
		this.util = util;
	}
	@Override
	public UserModel getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserModel getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserModel> getUserByRequirement(String requirement, String data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserModel> getUser() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 通过用户id删除用户
	 * 删除是软删除就是将exist 设置成true
	 */
	@Override
	public String deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		try{
			UserModel user = getAdminUserDao().getUserById(id);
			//硬删除
			//getAdminUserDao().delete(user);
			//软删除
			user.setExist(true);
			getAdminUserDao().update(user);
			return "删除成功";
		}catch(Exception e){
			e.printStackTrace();
			return "看起来删除没有成功";
		}
	}
	@Override
	public String deleteUserByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteUserByRequirement(String requirement, String data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteUser(UserModel user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateUserByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateUserByRequirement(String requirement, String data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return null;
	}
	//辅助读取配置文件中数据
	@SuppressWarnings({ "rawtypes" })
	private String[] pretreatment(InputStream url) throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		prop.load(url);
		Set set = prop.entrySet();
		Iterator it = set.iterator();
		String[] data = new String[set.size()];
		int index = 0;
		while(it.hasNext()){
			data[index++] = it.next().toString();
		}
		return data;
	}
	//用于预读取配置文件数据
	private Map<String,String> pretreatmentMap(){
		Map<String,String> map = new HashMap<String,String>();
		try {
			String[] data = pretreatment(User.class.getResourceAsStream("/collegeInformation.properties"));
			for(String string : data){
				String[] keyValues = string.split("=");
				String key = keyValues[0].trim();
				String value = keyValues[1].trim();
				map.put(key, value);
			}
			data = pretreatment(User.class.getResourceAsStream("/professional.properties"));
			for(String string : data){
				String[] keyValues = string.split("=");
				String key = keyValues[0].trim();
				String value = keyValues[1].trim();
				map.put(key, value);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	@Override
	/**
	 * 添加用户
	 */
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		String account = user.getAccount();
		try{
			Integer.parseInt(account);
			if(account.length() > 10 || account.length() < 8){
			//	System.out.println("输入的学号/账号不合法");
				return "输入的学号/账号不合法,只能输入8~10数字";
			}
			//System.out.println("校验成功");
		}catch(Exception e){
			//System.out.println("输入的学号/账号不合法");
			e.printStackTrace();
			return "输入的学号/账号不合法,只能输入8~10数字";
		}
		Map<String,String> map = pretreatmentMap();//获取配置文件，里面保存学院信息
		String gradeCode = "";
		String professionalCode = "";
		String classCode = "";
		String professional = "";
		String college = "";
		String role="";
		//目前只针对学生的学号进行了划分
		/*if(老师账号){
			
		}*/
		/*if(管理员账号){
			
		}*/
		//目前做的是学生账号
		if(true){
			gradeCode = account.substring(0, 4);//年级
			professionalCode = account.substring(4, 7);//专业代码
			classCode = account.substring(7, 8);	//班级代码
			professional = map.get(professionalCode);//获取专业名称
			college = map.get(professional);//获取所属二级学院名称
			role = "student"; //自动判别角色
			
		}
		//封装UserModel类型
		UserModel userModel = new UserModel();
		userModel.setAccount(user.getAccount());//
		if(!college.equals("")){
			userModel.setCollege(college);
		}
		if(!gradeCode.equals("")){
			userModel.setGrade(gradeCode);
		}
		if(!professional.equals("")){
			userModel.setProfessional(professional);
		}
		if(!classCode.equals("")){
			userModel.setStudent_class(classCode);
		}
		userModel.setNation(user.getNation());//
		userModel.setPassword(user.getPassword());//
		userModel.setRole(role);//
		userModel.setSex(user.getSex());//
		userModel.setUsername(user.getUsername());//
		
		System.out.println("学院"+userModel.getCollege()+"-----"+"专业"+userModel.getProfessional());
		try{
		//	getAdminUserDao().save(userModel);
			return "用户录入成功";
		}catch(Exception e){
			e.printStackTrace();
			return "用户录入失败";
		}
	}
	
}
