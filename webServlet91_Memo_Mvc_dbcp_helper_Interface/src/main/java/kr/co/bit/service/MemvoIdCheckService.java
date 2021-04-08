package kr.co.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.action.Action;
import kr.co.bit.action.ActionForward;
import kr.co.bit.dao.memodao;

public class MemvoIdCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String id = request.getParameter("id");
    	memodao dao = new memodao();
    	String ischeck = dao.isCheckById(id);
    	
    	//"false" or "true"
    	//KEY POINT
    	out.print(ischeck);
    	
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	forward.setPath("/memo.html");
		return forward;
		
	}

}
