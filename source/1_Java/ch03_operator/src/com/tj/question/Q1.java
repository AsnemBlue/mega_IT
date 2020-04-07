package com.tj.question;
import java.util.Scanner;
// 사용자로부터 정수를 입력받아 3의배수인지 아닌지 출력
public class Q1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하고자 하는 정수값은 ? ");
		int i = scanner.nextInt(); // 키보드로부터 정수를 입력
		System.out.println(i%3==0 ? "3의 배수네":"3의배수가 아니군");
		scanner.close();
	}
}
