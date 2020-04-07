package com.tj.ex5_scanner;
import java.util.Scanner;
public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주소를 입력하세요");
		String address = scanner.nextLine();
		System.out.println("입력한 주소는"+address);
		
		System.out.print("이름을 입력하세요");
		String name = scanner.next();
		System.out.println("입력한 이름은"+name);
		
		System.out.print("정수를 입력하세요");
		int i = scanner.nextInt();
		System.out.println("입력한 정수는 "+i);
		
		System.out.println("--- 끝 ---");
		scanner.close();
	}
}
