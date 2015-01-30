package com.xeon.service;

public interface LogService {
	public String login(String account,String password,String verifycode);
	public String logout();
}
