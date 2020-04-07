package com.tj.ex;

import java.util.Scanner;

/* 오늘의 문제 : 사용자로부터 원하는 단수(2~9) 구구단을 출력하는 프로그램을 구현하시오.
(단, 단수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다. 
사용자가 2~9 사이의 수가 아닌 수를 입력할 시 2~9사이의 수를 입력할 때까지 계속 입력 받는다.)
   Today.java파일을 첨부하여 yisy0703@naver.com에 메일로 제출합니다(6:20)
 */
public class Today {
	public static void main(String[] args) {
		// 사용자로 부터 2~9까지의 원하는 구구단을 받는다.
		Scanner sc = new Scanner(System.in);
		int dansu;
		do {
			System.out.print("출력을 원하는 구구단 수는 ?(2~9단까지만 돼)");
			dansu = sc.nextInt();
		}while(dansu < 2 || dansu>9);
		guguPrint(dansu);// 사용자로부터 받은 수의 구구단을 출력
	}
	private static void guguPrint(int dansu) {// 사용자로부터 받은 수의 구구단을 출력
		for(int i=1 ; i<10 ; i++) {
			System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
		}
	}
}
