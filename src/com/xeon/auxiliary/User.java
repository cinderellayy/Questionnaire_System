package com.xeon.auxiliary;

public class User implements Comparable<User>{
	private String username;
	private String sex;
	private String account;
	private String password;
	private String nation;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return Integer.parseInt(o.getAccount());
	}
	
}
