package kr.co.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.action.Action;
import kr.co.bit.action.ActionForward;
import kr.co.bit.service.MemoAddService;
import kr.co.bit.service.MemoListService;
import kr.co.bit.service.MemvoIdCheckService;

@WebServlet("*.do")
public class MemoFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemoFrontController() {
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestURL.substring(contextPath.length());

		Action action = null;
		ActionForward forward = null;

		if (urlcommand.equals("/MemoList.do")) {
			System.out.println("list");
			action = new MemoListService();
			forward = action.execute(request, response);
			
		}else if(urlcommand.equals("/MemoServlet.do")) {
			action = new MemoAddService();
			forward = action.execute(request, response);
			
		}else if(urlcommand.equals("/Memoid.do")) {
			action = new MemvoIdCheckService();
			forward = action.execute(request, response);
			
		}
		
		
		
		if (forward != null) {
			if (forward.isRedirect()) { // true 페이지를 재요청
				response.sendRedirect(forward.getPath()); // 거의 사용 안해요
			} else { // false

				// 1. UI 전달된 경우
				// 2. UI + 로직
				System.out.println("forward : " + forward.getPath());
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
