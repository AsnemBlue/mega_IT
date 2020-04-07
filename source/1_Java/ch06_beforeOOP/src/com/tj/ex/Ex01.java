package com.tj.ex;

public class Ex01 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=0 ; i<=10 ; i++) {
			sum += i;
		}
		System.out.println("1부터 10까지 누적합은 "+sum);
		System.out.println((sum%2==0)? "짝수":"홀수");
		sum = 0;
		for(int i=10 ; i<=100 ; i++) {
			sum += i;
		}
		System.out.println("10부터 100까지 누적합은 "+sum);
	}
}
