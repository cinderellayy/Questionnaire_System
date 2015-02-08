package com.xeon.model;

import java.util.SortedSet;
import java.util.TreeSet;
/**
 * 
 * @author Agzdjy
 * @param id 主键无实际意义
 * @param poll_name 问卷名称(标题) 唯一
 * @param poll_description 问卷描述 可选
 * @param poll_upload_time 问卷上传时间 不为空
 * @param poll_end_time 问卷结束时间 不为空
 * @param author 问卷做责
 * @param allowCollege 允许专业列表
 * @param need 指示本问卷是否必须完成
 * @param exist 指示本问卷是否被删除
 * @param quesionModel 本套问卷所包含的题目集合
 * @version 2015-1-25 v0.1
 *
 */
public class PollModel {
	private int id;
	private String poll_name;
	private String poll_description;
	private String poll_upload_time;
	private String poll_end_time;
	private String poll_author;
	private boolean need;
	private boolean exist;
	private SortedSet<AllowCollege> allowCollege = new TreeSet<AllowCollege>();
	private SortedSet<QuestionModel> questionModel = new TreeSet<QuestionModel>();
	public PollModel(){
		this.need = true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPoll_name() {
		return poll_name;
	}
	public void setPoll_name(String poll_name) {
		this.poll_name = poll_name;
	}
	public String getPoll_author() {
		return poll_author;
	}
	public void setPoll_author(String poll_author) {
		this.poll_author = poll_author;
	}
	public String getPoll_description() {
		return poll_description;
	}
	public void setPoll_description(String poll_description) {
		this.poll_description = poll_description;
	}
	public String getPoll_upload_time() {
		return poll_upload_time;
	}
	public void setPoll_upload_time(String poll_upload_time) {
		this.poll_upload_time = poll_upload_time;
	}
	public String getPoll_end_time() {
		return poll_end_time;
	}
	public void setPoll_end_time(String poll_end_time) {
		this.poll_end_time = poll_end_time;
	}
	public boolean isNeed() {
		return need;
	}
	public void setNeed(boolean need) {
		this.need = need;
	}
	public boolean isExist() {
		return exist;
	}
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	public SortedSet<QuestionModel> getQuestionModel() {
		return questionModel;
	}
	public void setQuestionModel(SortedSet<QuestionModel> questionModel) {
		this.questionModel = questionModel;
	}
	public SortedSet<AllowCollege> getAllowCollege() {
		return allowCollege;
	}
	public void setAllowCollege(SortedSet<AllowCollege> allowCollege) {
		this.allowCollege = allowCollege;
	}
	
}
