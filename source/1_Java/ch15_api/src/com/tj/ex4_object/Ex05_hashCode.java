package com.tj.ex4_object;

public class Ex05_hashCode {
	public static void main(String[] args) {
		Card c1 = new Card('♥',8);
		Card c2 = new Card('♥',8);
		System.out.println("c1과 c2가 주소가 같냐(같은 객체냐)? "+(c1==c2));
		System.out.println("c1과 c2는 같은 카드냐? "+c1.equals(c2));
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}
