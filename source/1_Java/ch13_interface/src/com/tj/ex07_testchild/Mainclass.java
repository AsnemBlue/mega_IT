package com.tj.ex07_testchild;

public class Mainclass {
	public static void main(String[] args) {
		TestChildClass obj = new TestChildClass();
		System.out.println(TestChildClass.i1);
		System.out.println(TestChildClass.i2);
		obj.m1();
		obj.m2();
		obj.m3();
		obj.m11();
	}
}
