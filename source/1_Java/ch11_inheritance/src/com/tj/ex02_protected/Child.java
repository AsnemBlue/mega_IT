package com.tj.ex02_protected;

public class Child extends SuperIJ {
	private int total;
	public void sum() {
		total = getI()+getJ();
		System.out.println("본 객체의 total값은 "+total);
	}
}
