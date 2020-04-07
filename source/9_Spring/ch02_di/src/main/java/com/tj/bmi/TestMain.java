package com.tj.bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(location);
		MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);
		myInfo.getInfo();
		
		ctx.close();
	}
}
