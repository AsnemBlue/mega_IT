package com.tj.ex4_object;
public class Ex04_CardMain {
	public static void main(String[] args) {
		Card c1 = new Card('♥', 2);
		Card c2 = new Card('♥', 2);
		Card c3 = new Card('◆', 9);
		System.out.println(c1.toString());
		System.out.println(c2);
		System.out.println(c3);
		// 선택하신 카드는 ♥ 2
		// 선택하신 카드는 ♥ 2
		// 선택하신 카드는 ◆ 9
		System.out.println("c1과 c2는 같냐? "+c1.equals(c2));
		// c1과 c2는 같냐? true
		System.out.println("c1과 c3는 같냐? "+c1.equals(c3));
		// c1과 c3는 같냐? false
	}
}
