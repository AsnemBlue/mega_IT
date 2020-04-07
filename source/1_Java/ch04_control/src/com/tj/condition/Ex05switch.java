package com.tj.condition;
import java.util.Scanner;
// 입력한 수가 짝수인지 홀수인지 출력(switch)
public class Ex05switch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력할 수?");
		int num = scanner.nextInt();
		switch(num%2) {
		case 0 : System.out.println("짝수를 입력하셨네");break;
		default: System.out.println("홀수를 입력하셨네");
		}
	}
}
