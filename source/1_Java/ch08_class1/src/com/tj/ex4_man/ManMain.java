package com.tj.ex4_man;

public class ManMain {
	public static void main(String[] args) {
		Man kang = new Man(179, 61);
		// kang : 객체변수 = 레퍼런스변수 = 객체
		Man kim = new Man();
		kim.setHeight(185);
		kim.setWeight(75);
		Man lee = new Man(185, 75);
		if (lee.equals(kim)) {
			System.out.println("1.kim 객체변수와 lee 객체변수는 같다");
		} else {
			System.out.println("1.kim 객체와 lee 객체는 다른 객체다");
		}
		lee = kim;
		if (lee.equals(kim)) {
			System.out.println("2.kim 객체변수와 lee 객체변수는 같다");
		} else {
			System.out.println("2.kim 객체와 lee 객체는 다른 객체다");
		}
		double biman = kang.calculateBMI();
		if (biman > 24) {
			System.out.println("kang님 비만이니 다이어트 하세요");
		}else {
			System.out.println("kang님 건강하시네요");
		}
		biman = kim.calculateBMI();
		if(biman>24) {
			System.out.println("kim님 비만이니 다이어트 하세요");
		}else {
			System.out.println(kim.getClass().getName()+" kim님 건강하시네요");
			// kim.getClass().getName() : kim 객체변수의 클래스 이름
		}
	}// main
}// class



















