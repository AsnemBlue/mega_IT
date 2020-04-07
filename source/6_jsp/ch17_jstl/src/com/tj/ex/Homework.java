package com.tj.ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;
@WebServlet("/homework")
public class Homework extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schEname = request.getParameter("schEname");
		String schJob = request.getParameter("schJob");
		schEname = schEname!=null? schEname.toUpperCase() : null;
		schJob = schJob!=null? schJob.toUpperCase() : null;
		EmpDao dao = new EmpDao();
		// pageNum, currentPage, PAGESIZE , BLOCKSIZE, starRow, endRow 계산
		ArrayList<EmpDto> emps = dao.getListEmp(schEname, schJob);
		request.setAttribute("emps", emps);
		// pageCnt, startPage, endPage 계산
		// request에 추가할 attribute : pageCnt, BLOCKSIZE, startPage, endPage, pageNum  
		RequestDispatcher dispatcher = request.getRequestDispatcher("core/homework.jsp");
		dispatcher.forward(request, response);
	}
}














