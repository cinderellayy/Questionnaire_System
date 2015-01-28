package com.xeon.util;

import javax.servlet.http.HttpSession;

public interface Util {
	public HttpSession getSession();
	public void clean();
}
