package com.tj.ex1student;

public class Student {
	private String name;
	private int age;
	private String gradeNum;
	private String classNum;
	public Student(String name, int age, String gradeNum, String classNum) {
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGradeNum() {
		return gradeNum;
	}
	public String getClassNum() {
		return classNum;
	}
}
