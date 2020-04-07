package com.tj.ex5_scanner;
import java.util.Scanner;
public class Ex04 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("이름?");
		String name = scMain.next();
		System.out.println("입력하신 이름은 "+name);
		action(scMain);
		System.out.print("나이?");
		int age = scMain.nextInt();
		System.out.println("입력한 나이는 "+age);		
		scMain.close();
	}
	private static void action(Scanner scAction) { // 별명을 받아 출력하는 일
		System.out.print("별명?");
		String nickName = scAction.next();
		System.out.println("별명은 "+nickName);
	}
}













