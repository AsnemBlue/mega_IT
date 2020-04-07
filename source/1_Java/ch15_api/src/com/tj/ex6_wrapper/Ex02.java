package com.tj.ex6_wrapper;
import com.tj.ex4_object.Card;
public class Ex02 {
	public static void main(String[] args) {
		Integer obj1 = 10; //Integer obj1 = new Integer(10);
		Integer obj2 = 10; //Integer obj2 = new Integer(10);
		int total = obj1+obj2; //int total = obj1.intValue()+obj2.intValue();
		Card c = new Card('¢¾', 10);
		System.out.println(c.equals(obj1));
		int i =10;
		boolean b = true;
		Boolean bObj = true;
		System.out.println(c.equals(i));
	}
}
