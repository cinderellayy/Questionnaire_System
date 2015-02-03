package com.xeon.util;

import javax.servlet.http.HttpSession;

public interface Util {
	public HttpSession getSession();
	public void clean();
	public String MD5(String password);
	public String encode(String result);
	public String sqlInsert(String str);
	public boolean checkStr(String str);
}
