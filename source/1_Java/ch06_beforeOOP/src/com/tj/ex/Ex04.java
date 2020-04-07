package com.tj.ex;
import java.util.Scanner;
// 4! = 4 * 3!
// 3! = 3 * 2 * 1
// 2! = 2 * 1
// 1! = 1
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su;
		do {
			System.out.print("몇 !을 계산할까요 ? ");
			su = sc.nextInt();
		}while(su<=0);
		long result = factorial(su);
		System.out.println(su+"!="+result);
	}// 4! = 4 * 3!
	// n! = n * (n-1)!
	private static long factorial(int su) {
		if (su==1){
			return 1;
		}else {
			return su * factorial(su-1);
		}
	}
//	private static long factorial(int su) {
//		long result = 1;
//		for(int i=su ; i>=1 ; i--) {
//			result *= i; //result = result * i;
//		}
//		return result;
//	}
}











