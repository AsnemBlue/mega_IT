package com.tj.ex5_scanner;
import java.util.Scanner;
public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요");
		int i = scanner.nextInt();
		System.out.println("입력한 정수는 "+i);
		
		System.out.print("이름을 입력하세요");
		String name = scanner.next();
		System.out.println("입력한 이름은 "+name);
		
		System.out.print("주소를 입력하세요");
		scanner.nextLine();  // 버퍼에 남아 있는 '\n'을 지우는 목적
		String address = scanner.nextLine();
		System.out.println("입력한 주소는"+address);
		System.out.println("----끝-----");
		scanner.close();
	}
}
