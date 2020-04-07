package com.tj.ex1_string;

public class Ex10_StringBuilder {
	public static void main(String[] args) {
		StringBuilder strBuilder = new StringBuilder("abc");
		strBuilder.append("def"); // abcdef
		System.out.println(strBuilder);
		strBuilder.insert(3, "AAA"); //abcAAAdef
		System.out.println(strBuilder);
		strBuilder.delete(3, 5);     // abcAdef
		System.out.println(strBuilder);
		strBuilder.deleteCharAt(3);  // abcAdef //strBuilder.delete(3, 4);
		System.out.println(strBuilder);
		int capacitySize  = strBuilder.capacity(); // 빌더의 가용크기
		System.out.println("빌더의 가용 크기 : "+capacitySize);
		strBuilder.append("012345678901234567890123456789");
		System.out.println(strBuilder);
		capacitySize = strBuilder.capacity();
		System.out.println(capacitySize);
	}
}
