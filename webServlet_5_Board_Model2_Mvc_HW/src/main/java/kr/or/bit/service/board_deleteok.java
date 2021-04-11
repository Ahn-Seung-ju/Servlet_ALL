package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionFoward;

public class board_deleteok implements Action {

	@Override
	public ActionFoward execute(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String pwd = request.getParameter("pwd");
		
		int result;
		try {
			result = 0;//service.board_Delete(idx, pwd);
			String msg="";
			String url="";
			if(result > 0){
				msg="delete success";
				url="board_list.jsp";
			}else{
				msg="delete fail";
				url="board_list.jsp";
			}
			request.setAttribute("board_msg",msg);
			request.setAttribute("board_url",url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionFoward forward = new ActionFoward();
		forward.setRedirect(false);
		forward.setPath("");
		
		
		return forward;
	}

}
