package com.tj.op;
// 삼항연산자 조건 ? 조건이참일때취할값 : 조건이거짓일때취할값
public class Ex05 {
	public static void main(String[] args) {
		int h=100;
		String result = (h%2==0) ? "짝수네":"홀수네";
		System.out.println(result);
		
		System.out.println((h%2==0)? "짝수네":"홀수네");
	}
}
