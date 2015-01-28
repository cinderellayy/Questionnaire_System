package com.xeon.model;
/**
 * 
 * @author Agzdjy
 * @param id 逻辑主键
 * @param option_name 选项
 * @param option_count 此选项被选次数 默认为0且不小于0
 * @param quesionModel 此选项所属问题
 * @param exist指示此选线是否被删除
 *
 */
public class OptionModel implements Comparable<OptionModel>{
	private int id;
	private String option_name;
	private int option_count;
	private QuestionModel questionModel;
	private boolean exist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public int getOption_count() {
		return option_count;
	}
	public void setOption_count(int option_count) {
		this.option_count = option_count;
	}
	public QuestionModel getQuestionModel() {
		return questionModel;
	}
	public void setQuestionModel(QuestionModel questionModel) {
		this.questionModel = questionModel;
	}
	public boolean isExist() {
		return exist;
	}
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	@Override
	public int compareTo(OptionModel o) {
		// TODO Auto-generated method stub
		return o.getId();
	}
}
