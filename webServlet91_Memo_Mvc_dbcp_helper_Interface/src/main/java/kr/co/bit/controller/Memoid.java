package kr.co.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.bit.dao.memodao;


@WebServlet("/Memoid")
public class Memoid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Memoid() {
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//비동기 요청
    	//client 전달(ID 사용유무)
    	//1. text(html, text, script, css, json)
    	//2. xml
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	String id = request.getParameter("id");
    	memodao dao = new memodao();
    	String ischeck = dao.isCheckById(id);
    	
    	//"false" or "true"
    	//KEY POINT
    	out.print(ischeck);
    	//request.setAttribute("check", ischeck);
//    	if(ischeck.equals("false")) {
//    		out.print("<script>");
//    			out.print("<alert('사용불가')");
//    		out.print("</script>");
//    	}else {
//    		out.print("<script>");
//				out.print("<alert('사용가능')");
//			out.print("</script>");
//    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
