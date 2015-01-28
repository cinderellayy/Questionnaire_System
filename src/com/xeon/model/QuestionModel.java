package com.xeon.model;

import java.util.SortedSet;
import java.util.TreeSet;
/**
 * 
 * @author Agzdjy
 * @param id 逻辑主键
 * @param quesion_name 问题 唯一 不为空
 * @param question_type 问题类型 如 单选/多选/填空等 不为空
 * @param quesion_choise_count 此问题的选项个数 不为空 不做为数据库键 
 * @param quesion_can_choise_count 此问题选项可选个数 不为空 
 * @param exist 指示此问题是否被删除
 * @param pollModel 本问题所属的问卷PollModel
 * @param optionModel 本问题所包含的选项集合
 * @version 2015-1-26 v0.1
 *
 */
public class QuestionModel implements Comparable<QuestionModel>{
	private int id;
	private String question_name;
	private String question_type;
	private int question_choise_count;
	private int question_can_choise_count;
	private boolean exist;
	private PollModel pollModel;
	private SortedSet<OptionModel> optionModel = new TreeSet<OptionModel>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	public int getQuestion_choise_count() {
		return question_choise_count;
	}
	public void setQuestion_choise_count(int question_choise_count) {
		this.question_choise_count = question_choise_count;
	}
	public int getQuestion_can_choise_count() {
		return question_can_choise_count;
	}
	public void setQuestion_can_choise_count(int question_can_choise_count) {
		this.question_can_choise_count = question_can_choise_count;
	}
	public boolean isExist() {
		return exist;
	}
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	public PollModel getPollModel() {
		return pollModel;
	}
	public void setPollModel(PollModel pollModel) {
		this.pollModel = pollModel;
	}
	public SortedSet<OptionModel> getOptionModel() {
		return optionModel;
	}
	public void setOptionModel(SortedSet<OptionModel> optionModel) {
		this.optionModel = optionModel;
	}
	@Override
	public int compareTo(QuestionModel o) {
		// TODO Auto-generated method stub
		return o.getId();
	}
	
	
}
