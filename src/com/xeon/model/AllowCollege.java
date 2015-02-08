package com.xeon.model;
/**
 * 
 * @author Agzdjy
 * 这个model没有什么大用，就是保存每张问卷所允许的二级学院列表
 * @version 2015-2-4
 *
 */
public class AllowCollege implements Comparable<AllowCollege>{
	private int id;
	private int allowCollege_id;
	private String allowCollegeName;
	private PollModel poll;
	public PollModel getPoll() {
		return poll;
	}
	public void setPoll(PollModel poll) {
		this.poll = poll;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAllowCollege_id() {
		return allowCollege_id;
	}
	public void setAllowCollege_id(int allowCollege_id) {
		this.allowCollege_id = allowCollege_id;
	}
	public String getAllowCollegeName() {
		return allowCollegeName;
	}
	public void setAllowCollegeName(String allowCollegeName) {
		this.allowCollegeName = allowCollegeName;
	}
	@Override
	public int compareTo(AllowCollege o) {
		// TODO Auto-generated method stub
		return o.getAllowCollege_id();
	}
}
