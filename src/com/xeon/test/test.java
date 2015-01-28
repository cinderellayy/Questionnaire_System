package com.xeon.test;

import java.util.Calendar;
import java.util.Date;

public class test {
	public static void main(String[] args){
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		System.out.println(c.getWeekYear());
	}
}
