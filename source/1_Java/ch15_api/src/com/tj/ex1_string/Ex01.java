package com.tj.ex1_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소다");
		}else {
			System.out.println("str1과 str2는 다른 주소다");
		}
		if(str1==str3) {
			System.out.println("str1과 str3은 같은 주소다");
		}else {
			System.out.println("str1과 str3은 다른 주소다");
		}
		if(str4==str3) {
			System.out.println("str4과 str3은 같은 주소다");
		}else {
			System.out.println("str4과 str3은 다른 주소다");
		}
		System.out.println("str1와 str2가 같은 스트링이냐?"+str1.equals(str2));
		System.out.println("str1와 str2가 같은 스트링이냐?"+str2.equals(str1));
		System.out.println("str1과 str3이 같은 스트링이냐?" + str1.equals(str3));
		System.out.println("str1의 hashcode : " + str1.hashCode());
		System.out.println("str2의 hashcode : " + str2.hashCode());
		System.out.println("str3의 hashcode : " + str3.hashCode());
		System.out.println("str4의 hashcode : " + str4.hashCode());
	}
}













