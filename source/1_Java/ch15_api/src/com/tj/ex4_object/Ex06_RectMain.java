package com.tj.ex4_object;
public class Ex06_RectMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle(5, 6, "빨강");
		Rectangle r2 = (Rectangle)r1.clone();
		System.out.println(r1);
		System.out.println(r2);
		if(r1==r2) {
			System.out.println("복제된 게 아니네.");
		}else {
			System.out.println("복제했나봐");
		}
		if(r1.equals(r2)) {
			System.out.println("같은 네모");
		}else {
			System.out.println("다른 네모");
		}
	}
}
