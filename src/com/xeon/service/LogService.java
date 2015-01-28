package com.xeon.service;

public interface LogService {
	public String login(String username,String password,String verifycode);
	public String logout();
}
