package com.tj.ex06_override;

public class ChildClass extends ParentClass{ // method1(), method2()
	public ChildClass() { // 오버로딩(함수의 중복정의)
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int i) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	@Override
	public void method1() { // override (함수의 재정의)
		System.out.println("ChildClass의 method1()");
	}
	public void method3() {
		System.out.println("ChildClass의 emthod3()");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}







