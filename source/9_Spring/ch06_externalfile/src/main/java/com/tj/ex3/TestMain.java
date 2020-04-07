package com.tj.ex3;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;
public class TestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("dev? run?");
		config = scanner.next();
		if(!config.equals("dev")) {
			config = "run";
		}
		scanner.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("applicationCTX_dev.xml","applicationCTX_run.xml");
		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip번호 : "+serverInfo.getIpNum());
		System.out.println("포트번호 : "+serverInfo.getPortNum());
		ctx.close();
	}
}












