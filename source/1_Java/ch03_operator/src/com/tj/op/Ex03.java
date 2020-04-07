package com.tj.op;
// 비교연산자(관계연산자) 같냐 크냐 크거나같냐....
public class Ex03 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		boolean result;
		result = (n1 == n2); // 같냐
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);
		result = (n1 != n2); // 다르냐
		System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
		result = (n1 > n2); // 크냐
		System.out.printf("%d %s %d = %b\n", n1, ">", n2, result);
		result = (n1 >= n2); // 크거나 같냐
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		result = (n1 < n2); // 작냐
		System.out.printf("%d %s %d = %b\n", n1, "<", n2, result);
		result = (n1 <= n2); // 작거나 같냐
		System.out.printf("%d %s %d = %b\n", n1, "<=", n2, result);
	}
}
