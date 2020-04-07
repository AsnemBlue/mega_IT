package com.tj.exam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Exam4")
public class Exam4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<link href='css/exam4.css' rel='stylesheet'>");
		out.print("<body>");
		for(String temp : su) {
			int dansuN = Integer.parseInt(temp);
			out.println("<p>"+dansuN+"단</p>");
			for(int i=1 ; i<=9 ; i++) {
				out.printf("<p>%d * %d = %d</p>",dansuN, i, dansuN*i);
			}
			out.println("<hr>");
		}
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
