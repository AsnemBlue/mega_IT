package com.tj.lect1;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex3_LifeCycle")
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PostConstruct
	private void postConstruct() {
		System.out.println("Ex3_LifeCycle 객체 생성되자 마자 바로 실행 -  1");
	}
	public void init() {
		// 객체가 만들어질 때 최초에 한번 수행
		System.out.println("Ex3_LifeCycle 서블릿 객체가 생성될 때 수행 - 2");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client의 요청이 get방식으로 들어올 때 수행
		response.getWriter().append("<h1>doGet() 수행</h1>");
		System.out.println("doGet() 실행");
	}
	public void destroy() {
		// 객체가 메모리에서 해제(끝낼때)
		System.out.println("Ex3_LifeCycle 서블릿 종료 - 1");
	}
	@PreDestroy
	private void preDestroy() {
		System.out.println("Ex3_LifeCycle형 객체 소멸되기 바로 전에 수행 - 2");
	}

}



