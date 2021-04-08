package kr.or.bit.action;


//servlet 요청을 받는다
//1. 화면 보여주기
//2. 화면단 데이터 처리

//화면이냐 로직이냐?
//뷰의 경로
public class ActionForward {
	private boolean isRedirect = false;//화면 전환 여부
	private String path = null; //이동경로(뷰의 주소)
	
	
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
