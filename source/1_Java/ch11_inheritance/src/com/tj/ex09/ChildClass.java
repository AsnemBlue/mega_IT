package com.tj.ex09;

public class ChildClass extends ParentClass{ // i, void method() 상속받음
	private int i = 20;
	public ChildClass() {
		System.out.println("ChildClass 생성자");
	}
	@Override
	public void method() {
		System.out.println("ChildClass의 method");
		super.method();
		System.out.println("super단의 i"+super.i+", 나의 i"+i);
	}
	public int getI() {
		return i;
	}
}