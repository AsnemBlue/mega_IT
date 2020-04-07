package com.tj.condition;
import java.util.Scanner;
// 두수를 입력받아 몇번째 수가 더큰지 그리고 그 큰 수를 출력
public class Ex03if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번재 수는 ?");
		int num1 = scanner.nextInt();
		System.out.print("두번째 수는 ?");
		int num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.println("첫번째 입력한 값 ("+num1+")이 더 커");
		}else if(num1 <num2) {
			System.out.println("두번째 입력한 값 ("+num2+")가 더 커");
		}else {
			System.out.println("같은 수를 두번 입력했네");
		} // if-else
		scanner.close();
	} // main
} // class