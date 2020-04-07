package com.tj.ex;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.member.MemberDao;
import com.tj.member.MemberDto;
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
		String uri = request.getRequestURI();   // "/ch18/~~.do"
		String conPath = request.getContextPath(); // "/ch18"
		String command = uri.substring(conPath.length()); // "/~~.do"
		System.out.println("uri = "+uri);
		System.out.println("conPath = "+conPath);
		System.out.println("들어온 요청은 "+command);
		String viewPage = null;
		Service service = null;
		if(command.equals("/insert.do")) {
			System.out.println("insert command 호출함");
			// insert 로직
			request.setAttribute("result", "insert command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/select.do")) {
			System.out.println("select command 호출함");
			// select 로직
			request.setAttribute("result", "select command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/delete.do")) {
			System.out.println("delete command 호출함");
			// delete 로직
			request.setAttribute("result", "delete command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/update.do")) {
			System.out.println("update command 호출함");
			// update로직
			request.setAttribute("result", "update command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/listMember.do")) {
			service = new ListMemberService();
			service.execute(request, response);
			viewPage = "1_front/ex03list.jsp";
		}else if(command.equals("/joinPro.do")) {
			service = new JoinMemberService();
			service.execute(request, response);
			viewPage = "1_front/ex04joinResult.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}












