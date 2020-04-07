package com.tj.ex2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class TestMainJava {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminInfo adminInfo = ctx.getBean("adminInfo", AdminInfo.class);
		System.out.println("adminId : "+adminInfo.getAdminId());
		System.out.println("adminPw : "+adminInfo.getAdminPw());
		System.out.println("Sub_adminId : "+adminInfo.getSub_adminId());
		System.out.println("Sub_adminPw : "+adminInfo.getSub_adminPw());
		ctx.close();
	}
}
