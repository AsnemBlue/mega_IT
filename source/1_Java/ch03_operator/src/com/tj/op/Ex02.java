package com.tj.op;
// 증감연산자
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = n1++;
		System.out.printf("n1 = %d\t n2=%d\n",n1, n2);
		int n3 = ++n1;
		System.out.printf("n1 = %d\t n3 = %d\n",n1, n3);
		System.out.printf("n3 = %d , %d %d\n", n3++, ++n3, n3);
		System.out.printf("n3 = %d\n", n3--);
	}
}