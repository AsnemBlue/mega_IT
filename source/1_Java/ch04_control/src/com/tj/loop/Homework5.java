package com.tj.loop;

import java.util.Scanner;

public class Homework5 {
	public static void main(String[] args) {
		int computer, you;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("가위(0),바위(1),보(2) 중 하나를 내세요(당신이 지면 끝)");
			you = sc.nextInt();
			computer = (int)(Math.random()*3);
			if(you >2 || you < 0) {
				System.out.println("가위(0), 바위(1), 보(2) 를 제대로 내세요");
			}else if((you+2)%3==computer) {
				System.out.println("당신은 "+(you==0? "가위":you==1? "바위":"보"));
				System.out.println("컴퓨터는 "+(computer==0? "가위":computer==1? "바위":"보"));
				System.out.println("당신이 이겼어요");
			}else if(you == computer) {
				System.out.println("당신은 "+(you==0? "가위":you==1? "바위":"보"));
				System.out.println("컴퓨터는 "+(computer==0? "가위":computer==1? "바위":"보"));
				System.out.println("비겼어요");
			}else {
				System.out.println("당신은 "+(you==0? "가위":you==1? "바위":"보"));
				System.out.println("컴퓨터는 "+(computer==0? "가위":computer==1? "바위":"보"));
				System.out.println("당신이 졌어요");
			}//if
		}while((you+2)%3==computer || you==computer);
		sc.close();
		System.out.println("당신이 져서 bye");
	}
}
