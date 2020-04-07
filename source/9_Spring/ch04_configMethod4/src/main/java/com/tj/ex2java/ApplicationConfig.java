package com.tj.ex2java;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.tj.ex1xml.Student;
// 스피링 설정파일임을 명시하는 어노테이션
@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가"); hobbies.add("군것질");
		Student student = new Student("홍길동", 30, hobbies);
		student.setHeight(170);
		student.setWeight(60);
		return student;
	}
	@Bean
	public Student student2() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("잠");
		Student student = new Student("성춘향",30, hobbies);
		student.setHeight(160);
		student.setWeight(50);
		return student;
	}
}



















