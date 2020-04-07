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
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	@Override
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
		if(command.equals("/list.do")) { // 글목록
			// service의 execute()호출 - BListService.java
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		}else if(command.equals("/write_view.do")) { // 글쓰기 view
			viewPage = "board/write_view.jsp";
		}else if(command.equals("/write.do")) { // 글쓰기 DB 저장
			// service의 execute()호출 - BWriteService.java
			service = new BWriteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/content_view.do")) { // 상세보기
			// service의 execute()호출 - BContentService.java
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
		}else if(command.equals("/modify_view.do")){ // 수정 view
			// service의 execute()호출 - BModifyViewService.java
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp";
		}else if(command.equals("/modify.do")) { //글 DB에 수정
			// service의 execute()호출 - BModifyService.java
			service = new BModifyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/delete.do")) {// 글 DB에 삭제
			// service의 execute()호출 - BDeleteService.java
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/reply_view.do")) {// 답변글쓰기 view
			// service의 execute()호출 - BReplyViewService.java
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp";
		}else if(command.equals("/reply.do")) {// 답변글 DB에 저장
			// service의 execute()호출 - BReplyService.java
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}//actionDo
}//class














