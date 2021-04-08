package kr.co.bit.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.action.Action;
import kr.co.bit.action.ActionForward;
import kr.co.bit.dao.memodao;
import kr.co.bit.dto.memo;

public class MemoListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		memodao dao = new memodao();
		ActionForward forward = new ActionForward();
		try {
			
			List<memo> memolist = dao.getMemoList();
			//화면에 출력해서 Client 전달
			//View 사용(JSP)
			
			//데이터 저장
			request.setAttribute("memolist", memolist);
			
			//View 페이지 설정
			//RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
			
			//View forward
			
			
			
			//dis.forward(request, response);
			
			forward.setRedirect(false);
			forward.setPath("/memolist.jsp");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return forward;
	}

}
