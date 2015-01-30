package com.xeon.model;
/**
 * 
 * @author Agzdjy
 * @param id 逻辑主键，没有实际意义
 * @param username 用户名   不为空 可修改
 * @param password 密码 不为空 可修改
 * @param role 用户角色 是 管理员、导员、学生其中之一 不为空
 * @param nation 学生民族 不为空 管理员、导员为nation
 * @param account 账号 唯一 college学院 professional 专业 grade 年级 student_class班级
 * @param sex 此用户性别
 * @param exist 指示此用户是否被删除，true存在 false被暂时删除
 * @version 2015-1-26 v0.1
 *
 */
public class UserModel {
	private int id;
	private String username;
	private String account;//学号/工号
	private String password;
	private String role;
	private String college;//学院
	private String professional;//专业
	private String grade;//年级
	private String student_class;//班级
	private String nation;
	private String sex;
	private boolean exist;
	public UserModel(){
		this.nation = "汉";
		this.sex = "man";
		this.college = "计算机";
		this.professional = "计算机";
		this.grade = "2012";
		this.student_class = "124";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isExist() {
		return exist;
	}
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
}
