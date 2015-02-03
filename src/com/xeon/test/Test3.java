package com.xeon.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.xeon.util.impl.UtilImpl;


public class Test3 {
	public static void main(String[] args) throws UnsupportedEncodingException{
		UtilImpl u = new UtilImpl();
		/*Gson g = new Gson();
		//g.
		String json = "{\"username\":\"azdjy\",\"password\":\"fdf\"}";
		JSONObject j = JSONObject.fromObject(json);
		String s = j.getString("password");
		System.out.println(s);*/
		String s= "%7B%22id%22:2,%22username%22:%22agzdjy_two%22,%22account%22:%222012081402%22,%22password%22:%22836fcfd794664191bb9b203168d7f6e4%22,%22role%22:%22student%22,%22college%22:%22%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6%E4%B8%8E%E5%B7%A5%E7%A8%8B%E5%AD%A6%E9%99%A2%22,%22professional%22:%22%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6%E4%B8%8E%E6%8A%80%E6%9C%AF%22,%22grade%22:%222012%22,%22student_class%22:%226%22,%22nation%22:%22%E7%91%B6%E6%97%8F%22,%22sex%22:%22man%22%7D";
		s = URLDecoder.decode(s,"utf-8");
		System.out.println(s);
		
	}
}
