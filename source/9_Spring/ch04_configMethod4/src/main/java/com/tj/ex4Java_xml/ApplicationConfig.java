package com.tj.ex4Java_xml;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.tj.ex1xml.Student;
@Configuration
@ImportResource("classpath:ex4/applicationCTX.xml")
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가"); hobbies.add("마라톤");
		Student student = new Student("신길동", 30, hobbies);
		student.setHeight(165);
		student.setWeight(55);
		return student;
	}
}
