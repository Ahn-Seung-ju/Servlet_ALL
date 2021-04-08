package kr.co.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.memodao;
import kr.co.bit.dto.memo;

@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemoServlet() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//localhost:8090/webServlet4_Memo_mvc/MevoServlet
    	//요청이 들어오면 doGet 또는 doPost가 실행
    	
    	//Servlet 하나만 가지고 작업 가능(FrontServlet)
    	//현재 실습은 요쳥당 >> Servlet 하나를 생성
    	
    	//INSERT
    	//1. 한글 처리
    	request.setCharacterEncoding("UTF-8");
    	//2. 데이터 받기
    	String id = request.getParameter("id");
    	String email = request.getParameter("email");
    	String content = request.getParameter("content");
    	
    	System.out.println(id + " / " + email + " / " + content);
    	//3. 비즈니스 (처리)
    	//별도의 UI가지지 않고
    	//성공 >> 목록보기....
    	//실패 >> 재입력
    	
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	try {
			memodao dao = new memodao();
			//memo m = new memo(id, email, content);
			int row =dao.insertMemo(new memo(id,email,content));
			
			if(row > 0) {
				out.print("<script>");
					out.print("alert('등록성공');");
					out.print("location.href='MemoList'");
					//localhost:8090/webServlet4_Memo_mvc/MevoServlet
				out.print("</script>");
			}else {
				
				//
				out.print("<script>");
					out.print("alert('등록실패');");
					out.print("location.href='memo.html'");
				out.print("</script>");
			}
		} catch (Exception e) {
			
			out.print("<script>");
				out.print("alert('등록실패');");
				out.print("location.href='memo.html'");
			out.print("</script>");
		}
    	
    	//4. 결과
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
