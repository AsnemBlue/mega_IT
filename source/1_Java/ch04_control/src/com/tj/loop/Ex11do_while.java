package com.tj.loop;
import java.util.Scanner;
//1~45까지의 임의의 수 맞추기
public class Ex11do_while {
	public static void main(String[] args) {
		int lotto; //컴퓨터가 선택한 임의의 수
		int su;    //사용자에게 수를 입력받을 수
		Scanner scanner = new Scanner(System.in);
		// 0.0 <= Math.random() <1
		// 0.0 <= Math.random()*45 < 45
		// (int)(Math.random()*45) : 0~44까지의 임의의 정수
		// (int)(Math.random()*45)+1 : 1~45까지의 임의의 정수
		lotto = (int)(Math.random()*45)+1;
//		System.out.println("귓속말 : "+lotto);
		do {
			System.out.print("1~45사이의 수를 맞춰보세요 : ");
			su = scanner.nextInt();
			if(su>lotto) {
				System.out.println(su+"보다 작은 수를 도전하세요");
			}else if(su<lotto) {
				System.out.println(su+"보다 큰 수로 도전하세요");
			}
		}while(su!=lotto);
		System.out.println("맞추셨습니다. bye");
	}
}














