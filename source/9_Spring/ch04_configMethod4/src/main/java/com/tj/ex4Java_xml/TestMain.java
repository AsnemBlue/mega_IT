package com.tj.ex4Java_xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tj.ex1xml.Student;

public class TestMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("student1 : "+student1);
		System.out.println("student2 : "+student2);
		ctx.close();
	}
}
