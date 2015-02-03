package com.xeon.action;

import com.opensymphony.xwork2.Action;
import com.xeon.service.AuxiliaryService;
import com.xeon.util.Util;

/**
 * 
 * @author Agzdjy
 * 作用很简单就是获取所有专业的信息
 *
 */
public class AuxiliaryAction {
	private String msg;
	private Util util;
	private String data;
	private AuxiliaryService auxiliaryService;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Util getUtil() {
		return util;
	}
	public void setUtil(Util util) {
		this.util = util;
	}
	public AuxiliaryService getAuxiliaryService() {
		return auxiliaryService;
	}
	public void setAuxiliaryService(AuxiliaryService auxiliaryService) {
		this.auxiliaryService = auxiliaryService;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String college(){
		String result = getAuxiliaryService().getInformation("college","college");
		setMsg(result);
		return Action.SUCCESS;
	}
	public String professional(){
		String result = getAuxiliaryService().getInformation("professional", getData());
		setMsg(result);
		return Action.SUCCESS;
	}
	public String studentClass(){
		String result = getAuxiliaryService().getInformation("studentClass", getData());
		setMsg(result);
		return Action.SUCCESS;
	}
}
