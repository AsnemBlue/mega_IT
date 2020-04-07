package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri     = request.getRequestURI();
		String conPath = request.getContextPath();
		String com     = uri.substring(conPath.length()); //들어온 요청
		String viewPage = null;
		Service service = null;
		if(com.equals("/noEditList.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "noEdit/list.jsp";
		}else if(com.equals("/noEditcontent.do")) {
			service = new ContentService();
			service.execute(request, response);
			viewPage = "noEdit/content.jsp";
		}else if(com.equals("/noEditwriteView.do")) {
			viewPage = "noEdit/write.jsp";
		}else if(com.equals("/noEditwrite.do")) {
			service = new WriteService();
			service.execute(request, response);
			viewPage = "noEditList.do";
		}else
		/* sm Editor*/
		if(com.equals("/smEditList.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "smEdit/list.jsp";
		}else if(com.equals("/smEditcontent.do")) {
			service = new ContentService();
			service.execute(request, response);
			viewPage = "smEdit/content.jsp";
		}else if(com.equals("/smEditwriteView.do")) {
			viewPage = "smEdit/write.jsp";
		}else if(com.equals("/smEditwrite.do")) {
			service = new WriteService();
			service.execute(request, response);
			viewPage = "smEditList.do";
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
