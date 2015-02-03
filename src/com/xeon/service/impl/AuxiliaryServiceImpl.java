package com.xeon.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.xeon.auxiliary.User;
import com.xeon.service.AuxiliaryService;
import com.xeon.util.Util;

public class AuxiliaryServiceImpl implements AuxiliaryService{
	private Util util;

	public Util getUtil() {
		return util;
	}
	public void setUtil(Util util) {
		this.util = util;
	}
	@Override
	public String getInformation(String type,String srtData) {
		// TODO Auto-generated method stub
		if(type.equals("college")){
			try{
				String[] data = pretreatment(User.class.getResourceAsStream("/collegeInformation.properties"));
				String[] resultData = new String[data.length];
				Set<String> set = new  TreeSet<String>();
				int index = 0;
				for(String string : data){
					String[] keyValues = string.split("=");
					resultData[index++] = keyValues[1];
				}
				for(String str : resultData){
					set.add(str);
				}
				return getUtil().encode(new Gson().toJson(set));
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		if(type.equals("professional")){
			try{
				String[] data = pretreatment(User.class.getResourceAsStream("/collegeInformation.properties"));
				Set<String> set = new TreeSet<String>();
				for(String string : data){
					String[] keyValues = string.split("=");
					String value = keyValues[1].trim();
					if(value.equals(srtData)){
						set.add(keyValues[0].trim());
					}
				}
				return getUtil().encode(new Gson().toJson(set));
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		if(type.equals("studentClass")){
			try{
				String[] data = pretreatment(User.class.getResourceAsStream("/studentClass.properties"));
				for(String string : data){
					String[] keyValues = string.split("=");
					String value = keyValues[0].trim();
					if(value.equals(srtData)){
						return getUtil().encode(new Gson().toJson(keyValues[1].trim()));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
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
}
