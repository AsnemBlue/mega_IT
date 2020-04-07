package com.tj.ex04;

public class MainClass {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		//A s = new S();
		S[] objArr = {a, b, c};
		for(S obj : objArr) {
			System.out.println(obj.s);
		}
	}
}
