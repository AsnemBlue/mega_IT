package com.tj.ex;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ExServlet")
public class ExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 메소드 호출 - MVC 패턴에서 메소드에서 호출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");		
		Member member = new Member(id, pw, "홍길동");
		//request.setAttribute("member", member);
		// View단으로
		//RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex02View.jsp");
		//dispatcher.forward(request, response);
		response.sendRedirect("2_redirect/ex02View.jsp?id="+id+"&pw="+pw+"&name="+
								URLEncoder.encode("홍길동","utf-8"));
	}
}









