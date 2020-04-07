package com.tj.ex02;

import com.tj.ex02_protected.Child;

public class MainClass {
	public static void main(String[] args) {
		Child child = new Child();
		child.setIJ(10, 20);
//		System.out.println("i´Â" + child.getI());
//		System.out.println("j´Â "+ child.getJ());
		child.sum();
	}
}
