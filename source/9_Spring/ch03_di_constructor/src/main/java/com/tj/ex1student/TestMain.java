package com.tj.ex1student;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.print();
		Student s1 = studentInfo.getStudent(); // 홍길동
		Student s2 = ctx.getBean("student1", Student.class); // 홍길동
		Student s3 = ctx.getBean("student2", Student.class); // 성춘향
		if(s1.equals(s2)) {
			System.out.println("s1과 s2은 같은 객체");
		}else {
			System.out.println("s1과 s2는 홍길동 이지만 다른 주소 객체");
		}
		
		ctx.close();
	}
}
