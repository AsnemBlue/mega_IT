package com.tj.ex02;
// 다형성 : 여러 가지 형태나 여러 기능을 가질 수 있는 능력(오버로딩, 오버라이딩)
public class S {
	public void method() {
		System.out.println("매개변수 없는 S의 method");
	}
	public void method(int i) {
		System.out.println("매개변수 "+i+"인 S의 method");
	}
}
