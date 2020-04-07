package com.tj.lect1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 같은 이름의 파라미터를 전달 받았을 때(select, checkBox)
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>h2{color:red;}</style>");
		out.println("</head>");
		out.println("<body>");
		if(menu!=null) {
			out.println("<h2>선택한 메뉴는 ");
			for(String m : menu) {
				out.println(m +"  ");
			}
			out.println("입니다</h2>");
		}else {
			out.println("<h2>선택한 메뉴가 없습니다</h2>");
		}
		if(rest!=null) {
			out.println("<h2>선택한 식당은 "+Arrays.toString(rest)+"입니다</h2>");
		}else {
			out.println("<h2>선택한 식당이 없습니다</h2>");
		}
		out.println("<h2>선택한 국적은 "+nation+"입니다</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}








