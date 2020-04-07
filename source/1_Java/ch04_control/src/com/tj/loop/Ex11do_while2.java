package com.tj.loop;
import java.util.Scanner;
//1~45까지의 임의의 수 맞추기
public class Ex11do_while2 {
	public static void main(String[] args) {
		int lotto; //컴퓨터가 선택한 임의의 수
		int su;    //사용자에게 수를 입력받을 수
		int min = 1, max=45;
		Scanner scanner = new Scanner(System.in);
		lotto = (int)(Math.random()*45)+1;
//		System.out.println("귓속말 : "+lotto);
		do {
			System.out.printf("%d ~ %d사이의 수를 맞춰보세요 : ", min, max);
			su = scanner.nextInt();
			if(su<min || su>max) {
				System.out.println("떼끼");
			}else if(su==lotto) {
				break;
			}else if(su>lotto) {
				max = su - 1;
			}else if(su<lotto) {
				min = su + 1;
			}
		}while(true);
		System.out.println("맞추셨습니다. bye");
	}
}














