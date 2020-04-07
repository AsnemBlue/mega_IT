package com.tj.lect1;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class Ex6_Listener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹프로젝트가 메모리에 구동되는 시점에 실행
		System.out.println("★ ch04 context가 시작될 때");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹프로젝트가 메모리에서 해제되는 시점에 실행
		System.out.println("★ ch04 context가 종료될 때");
	}
}
