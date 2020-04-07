package com.tj.loop;
import java.util.Scanner;
// 짝수를 입력할때까지 사용자로부터 받는다
public class Ex10do_while {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = scanner.nextInt();
		}while(num%2!=0);
		System.out.println(num+" 짝수를 잘 입력하셨네요");
	}
}
