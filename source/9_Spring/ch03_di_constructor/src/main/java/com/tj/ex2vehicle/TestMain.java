package com.tj.ex2vehicle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class TestMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX1.xml");
		Vehicle vh = ctx.getBean("vh", Vehicle.class);
		vh.ride("홍길동");
		ctx.close();
	}
}
