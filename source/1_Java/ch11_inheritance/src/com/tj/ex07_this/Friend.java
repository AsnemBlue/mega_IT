package com.tj.ex07_this;
public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("매개변수 0개짜리");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("매개변수 1개짜리");
	}
	public Friend(String name, String tel) {
		// this. : 내객체의 
		// this() : 내객체의 생성자함수
		this(name);
		this.tel = tel;
		System.out.println("매개변수 2개짜리");
	}
	public String infoString() {
		return name+" : "+tel;
	}
}
