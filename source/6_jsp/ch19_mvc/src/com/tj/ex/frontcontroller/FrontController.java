package com.tj.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.MemberJoinService;
import com.tj.ex.service.MemberListService;
import com.tj.ex.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // "/ch19_1/list.do"
		String conPath = request.getContextPath(); // "/ch19_1"
		String command = uri.substring(conPath.length()); // "/list.do"
		String viewPage = null;
		Service service = null;
		if(command.equals("/memberList.do")) {
			// service의 execute호출 (MemberListService.java)
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "member/memberList.jsp";
		}else if(command.equals("/memberJoinView.do")) {
			viewPage = "member/memberJoin.jsp";
		}else if(command.equals("/memberJoin.do")){
			// service의 execute호출 (MemberJoinService.java)
			service = new MemberJoinService();
			service.execute(request, response);
			viewPage = "memberList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}















