package com.tj.ex3Xml_java;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.tj.ex1xml.Student;

public class TestMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ex3/applicationCTX.xml");
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("student1 : "+student1);
		System.out.println("student2 : "+student2);
		
		ctx.close();
	}
}
