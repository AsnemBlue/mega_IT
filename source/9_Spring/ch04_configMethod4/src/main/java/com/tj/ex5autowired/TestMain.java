package com.tj.ex5autowired;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String loc = "classpath:ex5/applicationCTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(loc);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		System.out.println(studentInfo.getStudent());
		ctx.close();
	}
}
