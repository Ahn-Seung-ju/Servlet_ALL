package kr.co.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.action.Action;
import kr.co.bit.action.ActionForward;
import kr.co.bit.dao.memodao;
import kr.co.bit.dto.memo;

public class MemoAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    	//2. 데이터 받기
		ActionForward forward = new ActionForward();
    	String id = request.getParameter("id");
    	String email = request.getParameter("email");
    	String content = request.getParameter("content");
    	
    	System.out.println(id + " / " + email + " / " + content);
    	//3. 비즈니스 (처리)
    	//별도의 UI가지지 않고
    	//성공 >> 목록보기....
    	//실패 >> 재입력
    	
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			memodao dao = new memodao();
			//memo m = new memo(id, email, content);
			int row =dao.insertMemo(new memo(id,email,content));
			
			if(row > 0) {
				out.print("<script>");
					out.print("alert('등록성공');");
					//localhost:8090/webServlet4_Memo_mvc/MevoServlet
				out.print("</script>");
				forward.setRedirect(false);
				forward.setPath("/MemoList.do");
				
			}else {
				
				//
				out.print("<script>");
					out.print("alert('등록실패');");
				out.print("</script>");
				forward.setRedirect(false);
				forward.setPath("memo.html");
			}
			
		} catch (Exception e) {
			
			out.print("<script>");
				out.print("alert('등록실패');");
			out.print("</script>");
			forward.setRedirect(false);
			forward.setPath("memo.html");
		}
		
		return forward;
	}

}
