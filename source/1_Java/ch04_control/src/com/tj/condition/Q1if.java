package com.tj.condition;
import java.util.Scanner;
//수를 입력받아 절대값을 출력하는 프로그램
public class Q1if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하실 수는 ? ");
		int num = scanner.nextInt();
		if (num >= 0) {
			System.out.println("입력하신 수의 절대값은 " + num);
		} else {
			System.out.println("입력하신 수의 절대값은 " + (-num));
			// System.out.println("입력하신 수의 절대값은 "+(num * -1));
		} // if
	}// main
}// class
