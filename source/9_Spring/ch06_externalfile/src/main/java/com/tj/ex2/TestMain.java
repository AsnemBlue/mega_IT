package com.tj.ex2;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class TestMain {
	public static void main(String[] args) {
		String loc = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
		AdminInfo info = ctx.getBean("adminInfo",AdminInfo.class);
		System.out.println("adminId : "+info.getAdminId());
		System.out.println("adminPw : "+info.getAdminPw());
		System.out.println("sub_adminId : "+info.getSub_adminId());
		System.out.println("sub_adminPw : "+info.getSub_adminPw());
		ctx.close();
	}
}