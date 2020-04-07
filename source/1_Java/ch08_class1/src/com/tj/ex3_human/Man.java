package com.tj.ex3_human;
public class Man {
	private int age;
	public Man() { 
		System.out.println("매개변수=파라미터가 없는 Man 생성자");	
	}
	public Man(int age) {
		this.age = age;
		System.out.println("파라미터 있는 Man 생성자");
	}
}
