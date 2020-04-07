package com.tj.exam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Exam4_1")
public class Exam4_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<link href='css/exam4.css' rel='stylesheet'>");
		out.print("<body>");
		out.println("<table>");
		out.println("<tr>");
		for(int j=0; j<su.length ; j++) {
			out.println("<td>"+su[j]+"단</td>");
		}
		out.println("</tr>");
		for(int i=1 ; i<=9 ; i++) {
			out.println("<tr>");
			for(int j=0 ; j<su.length ; j++) {
				out.printf("<td>%s * %d = %d</td>", 
						su[j], i, Integer.parseInt(su[j])*i);
			}				
			out.println("<tr>");
		}
		out.println("</table>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
