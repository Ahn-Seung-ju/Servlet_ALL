package kr.co.bit.action;

import java.io.PrintWriter;

public class ActionForward {
	private boolean isRedirect = false;
	private String path = null;
	//private PrintWriter out = null;
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
