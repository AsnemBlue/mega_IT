package com.tj.ex.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.MAllViewService;
import com.tj.ex.service.MJoinService;
import com.tj.ex.service.MLoginService;
import com.tj.ex.service.MLogoutService;
import com.tj.ex.service.MModifyService;
import com.tj.ex.service.MService;
@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); 
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		MService service = null;
		String viewPage = null;
		if(command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) {
			// service의 execute() 호출(MLoginService.java) - 로그인 여부에 따라 세션
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) {
			// service의 execute() 호출(MJoinService.java) - id중복체크 후 회원가입
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		}else if(command.equals("/modifyView.do")) {
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) {
			//service의 execute()호출 (MModifyService.java) - DB에 수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/allView.do")) {
			// service의 execute()호출 (MAllViewService.java) - 회원목록가져오기
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(command.equals("/logout.do")) {
			// service의 execute()호출 (MLogoutService.java) - 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
















