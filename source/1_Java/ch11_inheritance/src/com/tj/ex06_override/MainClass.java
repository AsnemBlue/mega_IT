package com.tj.ex06_override;

public class MainClass {
	public static void main(String[] args) {
		ParentClass parentObj = new ParentClass(2);
		parentObj.method1();
		parentObj.method2();
		System.out.println("★ ★ ★ ★ ★ ★");
		ChildClass childObj = new ChildClass(2);
		childObj.method1();
		childObj.method2();
		childObj.method3();
		int i=10, j=11;
		if(childObj.equals(parentObj)) {
			System.out.println("둘이 같아");
		}
	}
}
