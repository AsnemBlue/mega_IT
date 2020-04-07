package com.tj.ex06_override_overload;

public class TestMain {
	public static void main(String[] args) {
		OverloadingTest obj1 = new OverloadingTest();
		OverloadingTest obj2 = new OverloadingTest(5);
		OverloadingTest obj3 = new OverloadingTest(5, 1);
		obj1.calculate();
		obj1.calculate('*');
		obj2.calculate('/');
		obj3.calculate('/');
		System.out.println("´Ù Çß´Ù");
	}
}
