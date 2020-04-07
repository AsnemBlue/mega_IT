package com.tj.loop;
import java.util.Scanner;
//	사용자로부터 원하는 단수의 구구단을 출력하자
public class Q3for {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇단 원해?");
		int dansu = scanner.nextInt();
		for(int i=1 ; i<10 ; i++) {
			//System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
		scanner.close();
	}
}
