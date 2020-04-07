package com.tj.ex1_list;
import java.util.Vector;
public class Ex05_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new AClass());
		vec.add(new BClass());
		vec.add("string");
		System.out.println(vec);
		System.out.println("2번 인덱스값 :"+vec.get(2)); // ★
		System.out.println("2번 인덱스값 :"+vec.elementAt(2));
		vec.clear();
		if(vec.isEmpty()) {
			System.out.println("비워졌네");
		}
	}
}