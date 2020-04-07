package com.tj.ex1_tryCatch;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j=1;
		do {
			try {
				System.out.print("첫번째 정수 i는 ?");
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("첫번째 수에 꼭 문자를 넣어주세요");
				scanner.nextLine(); // 버퍼를 지우는 목적
			}
		}while(true);
		System.out.print("두번째 정수 j는 ");
		try {
			j = scanner.nextInt();                   //InputMismatchException
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i * j = "+ (i*j));
			System.out.println("i / j = "+ (i/j));   // ArithmeticException
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("0으로 나누는 것은 안되요");
		}
		System.out.println("i + j = "+ (i+j));
		System.out.println("i - j = "+ (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
