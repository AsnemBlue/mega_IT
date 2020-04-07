package com.tj.ex1xml;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class TestMain {
	public static void main(String[] args) {
		String resourceLocation1 = "classpath:ex1/applicationCTX1.xml";
		String resourceLocation2 = "classpath:ex1/applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation1, resourceLocation2);
		Student student1 = ctx.getBean("student1", Student.class);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student3 = studentInfo.getStudent();
		System.out.println("student1 : "+ student1);
		System.out.println("student3 : "+ student3);
		if(student1.equals(student3)) {
			System.out.println("student1과 student3은 주소가 같은 한 객체");
		}else {
			System.out.println("student1과 student3은 주소가 다른 두 객체");
		}
		student3.setName("아이유");
		System.out.println("student1 : "+student1);
		System.out.println("student3 : "+student3);
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		ctx.close();
	}
}




















