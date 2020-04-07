package com.tj.question;
import java.util.Scanner;
// (연습문제2) 입력한 수가 짝수인지 홀수인지 출력
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 수는 ?");
		int number = sc.nextInt();
		System.out.println(number%2==0? "짝수 입력하심":"홀수 입력하심");
		sc.close();
	}
}