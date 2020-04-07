package com.tj.ex1_string;
public class Ex02_stringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "   ja  va    ";
		System.out.println("1." + str1.concat(str2)); // abcXabcabcXabc
		System.out.println("2." + str1.substring(3)); // Xabc
		System.out.println("3." + str1.substring(3, 5)); // 3번인덱스부터 5번 앞까지 Xa
		System.out.println("4." + str1.length()); // str1문자길이 7
		System.out.println("5." + str1.toUpperCase()); // 대문자로 ABCXABC
		System.out.println("6." + str1.toLowerCase()); // 소문자로 abcxabc
		System.out.println("7." + str1.charAt(3)); // 3번인덱스의 문자 X
		System.out.println("8." + str1.indexOf('b')); // 첫번째 b가 나오는 인덱스 1
		System.out.println("9." + str1.lastIndexOf('b')); // 마지막 b가 나오는 인덱스 5
		String str4 = "abcXabcXabcXabc";
		System.out.println("10." + str4.indexOf('b', 3));// 3번인덱스부터 검색하여 첫b가 나오는 인덱스 5
		System.out.println("11." + str4.indexOf("cX"));  // 첫번째 cX가 나오는 인덱스 2
		System.out.println("12." + str4.indexOf('z'));   // z가 없으면 -1
		System.out.println("13." + str1.equals(str2)); // str1과 str2가 같은 문자인지(대소문자구별) false
		System.out.println("14." + str1.equalsIgnoreCase(str2));// 대소문자구별없이 같은 알파벳인지 true
		System.out.println("15." + str3.trim()); // 앞뒤 space 제외 java
		System.out.println("16." + str4.replace('a', '9')); // str4의 'a'를 다 9로 9bcX9bcX9bcX9bc
		System.out.println("17." + str4.replace("abcX", "바꿔")); // 바꿔바꿔바꿔abc
		System.out.println("str1 : "+str1);
		System.out.println("str2 : "+str2);
		System.out.println("str3 : "+str3);
		System.out.println("str4 : "+str4);
	}
}













