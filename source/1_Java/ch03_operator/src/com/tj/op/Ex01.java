package com.tj.op;
public class Ex01 {
	public static void main(String[] args) {
		System.out.println("* * * 산술연산자 * * *");
		int n1=33, n2=10;
		int result;	double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %.2f\n", n1, '/', n2, resultDouble);
		resultDouble = n1 / 0.0;
		System.out.printf("result = %.2f\n", resultDouble);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		// 나머지 연산자의 용도 : 짝홀수 판별, x배수 판별
		if (n1%2 == 0) {
			System.out.println("n1은 짝수입니다");
		}else {
			System.out.println("n1은 홀수입니다");
		}
		if(n2%5 == 0) {
			System.out.println("n2는 5의 배수입니다");
		}else {
			System.out.println("n2는 5의 배수가 아닙니다");
		}
	}
}












