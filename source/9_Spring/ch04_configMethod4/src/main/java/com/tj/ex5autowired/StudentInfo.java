package com.tj.ex5autowired;
import org.springframework.beans.factory.annotation.Autowired;
public class StudentInfo {
	
	private Student student;
	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}
}
