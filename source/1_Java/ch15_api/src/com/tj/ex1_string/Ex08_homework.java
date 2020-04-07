package com.tj.ex1_string;

import java.util.Scanner;

public class Ex08_homework {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;	
		while(true) {
			System.out.print("전화번호(국번XXXXXXXX) 입력 (x는 종료)");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) {
				break;
			}
			if(tel.length()<10 || tel.length() > 14 ||  tel.indexOf('-')==tel.lastIndexOf('-')) {
				System.out.println("입력 전화번호의 타입을 잘 지켜주세요");
				continue;
			}
			System.out.println("입력한 전화번호 : "+tel);
			System.out.print("짝수번째 문자열 : ");
			for(int i = 0 ; i < tel.length() ; i+=2) {
				System.out.print(tel.charAt(i)+" ");
			}
			System.out.println();
			System.out.print("문자를 거꾸로 : ");
			for(int i = tel.length()-1 ; i >= 0;i-- ) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			String preTel = tel.substring(0, tel.indexOf('-'));
			System.out.println("전화번호 앞자리는 : " + preTel);
			String postTel = tel.substring(tel.lastIndexOf('-')+1);
			System.out.println("전화번호 뒷자리는 : "+ postTel);			
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
