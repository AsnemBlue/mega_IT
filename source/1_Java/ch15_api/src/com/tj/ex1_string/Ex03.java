package com.tj.ex1_string;
import java.util.Scanner;
public class Ex03 {
	public static void main(String[] args) {
		// x를 누르면 종료. 나머지 기능은 무한반복
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.print("원하는 기능번호는 1:대출, 2:반납, x:종료");
			fn = scanner.next();
			if(fn.equals("1")) {
				System.out.println("대출로직");
			}else if(fn.equals("2")) {
				System.out.println("반납로직");
			}
		}while(!fn.equalsIgnoreCase("x"));
	}
}
