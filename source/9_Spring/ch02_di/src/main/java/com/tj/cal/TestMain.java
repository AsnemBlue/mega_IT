package com.tj.cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		MyCalculator myCal = ctx.getBean("myCal", MyCalculator.class);
		
		myCal.add();
		myCal.sub();
		myCal.mul();
		myCal.div();
		
		ctx.close();
	}
}
