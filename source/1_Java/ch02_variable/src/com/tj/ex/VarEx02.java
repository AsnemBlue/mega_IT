package com.tj.ex;

public class VarEx02 {
	public static void main(String[] args) {
		int i = 10; // 4byte짜리 i라는 주머니에 10을 할당(대입)
		byte j = 20;
		double h = 0.1;
//		i = 5;  
		System.out.println("i="+i+"\t j="+j+"\t h="+h);//i=10	 j=20	 h=0.1
		char c1 = 'A';
		char c2 = 'B';
		System.out.print("c1="+c1+"\t c2="+c2+"\n"); // "\n"은 개행을 의미
		System.out.printf("c1=%c\t c2=%c\n", c1, c2);
		// %c - 문자, %d - 정수, %f - 실수, %s - 문자열
		System.out.printf("c1=%d\t c2=%d\n", (int)c1, (int)c2);
		System.out.println("프로그램 끝");
	}
}
