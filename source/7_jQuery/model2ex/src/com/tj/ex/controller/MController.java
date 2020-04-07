package com.tj.ex.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.*;
@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int write_view = 0;
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
		Service service = null;
		String viewPage = null;
		if(command.equals("/main.do")) { // 첫화면
			viewPage = "main/main.jsp";
		/* * * * * * * * * * *  * * * * * * * * * * * * */
		/* * * * * * * * * member 관련 요청  * * * * * * */
		/* * * * * * * * * * *  * * * * * * * * * * * * */
		}else if(command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) {
			// service의 execute() 호출(MLoginService.java) - 로그인 여부에 따라 세션
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "list.do";
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
			viewPage = "list.do";
		}else if(command.equals("/allView.do")) {
			// service의 execute()호출 (MAllViewService.java) - 회원목록가져오기
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(command.equals("/logout.do")) {
			// service의 execute()호출 (MLogoutService.java) - 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/idConfirm.do")) {
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/idConfirm.jsp";
		/* * * * * * * * * * *  * * * * * * * * * * * * * * * * */
		/* * * * * * * * * * admin 관련 요청  * * * * * * * * * */
		/* * * * * * * * * * *  * * * * * * * * * * * * * * * * */
		}else if(command.equals("/adminloginView.do")) { 
			viewPage = "admin/adminLogin.jsp";
		}else if(command.equals("/adminLogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
		/* * * * * * * * * * *  * * * * * * * * * * * * * * * * * * * */
		/* * * * * * * * * * fileBoard 관련 요청들  * * * * * * * * * */
		/* * * * * * * * * * *  * * * * * * * * * * * * * * * * * * * */
		}else if(command.equals("/list.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "fileboard/list.jsp";
		}else if(command.equals("/write_view.do")) {
			write_view = 1;
			viewPage = "fileboard/write_view.jsp";
		}else if(command.equals("/write.do")) {
			if(write_view == 1) {
				service = new BWriteService();
				service.execute(request, response);
				write_view = 0;
			}
			viewPage = "list.do";
		}else if(command.equals("/content_view.do")) {
			service = new BContentService();
			service.execute(request, response);
			viewPage = "fileboard/content_view.jsp";
		}else if(command.equals("/boradModify_view.do")) {
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "fileboard/modify_view.jsp";
		}else if(command.equals("/boradModify.do")) {
			service = new BModifyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/delete.do")) {
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/reply_view.do")) {
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "fileboard/reply_view.jsp";
		}else if(command.equals("/reply.do")) {
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}