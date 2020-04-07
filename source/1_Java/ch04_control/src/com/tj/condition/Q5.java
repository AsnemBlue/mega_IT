package com.tj.condition;
import java.util.Scanner;
// you = 0,1,2(가위바위보) computer=0,1,2
public class Q5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2) 중 하나를 선택하세요 : ");
		int you = scanner.nextInt(); // you가 0,1,2 중 하나 선택
		int computer = (int)(Math.random()*3);
		if(you==0) {
			System.out.println("당신은 가위");
		}else if(you ==1) {
			System.out.println("당신은 바위");
		}else if(you ==2 ){
			System.out.println("당신은 보자기");
		}else {
			System.out.println("유효하지 않는 값입니다");
			you = 3;
		}
		scanner.close();
		if(you!=3) {
			if(computer==0) {
				System.out.println("컴퓨터는 가위");
			}else if(computer==1) {
				System.out.println("컴퓨터는 바위");
			}else {
				System.out.println("컴퓨터는 보자기");
			}
			// 누가 이겼는지 출력
			if((you +2 )%3 == computer) {
				System.out.println("당신이 이겼다");
			}else if(you==computer) {
				System.out.println("비겼다");
			}else {
				System.out.println("컴퓨터가 이겼다");
			}
			/*
			 * if(you==0) { // 당신이 가위 if(computer==0) { System.out.println("비겼다"); }else
			 * if(computer==1) { System.out.println("컴퓨터가 이겼다"); }else {
			 * System.out.println("당신이 이겼다"); } }else if(you==1) {//당신이 바위 if(computer==0) {
			 * System.out.println("당신이 이겼다"); }else if(computer==1) {
			 * System.out.println("비겼다"); }else { System.out.println("컴퓨터가 이겼다"); } }else
			 * if(you==2) {// 당신이 보자기 if(computer==0) { System.out.println("컴퓨터가 이겼다");
			 * }else if(computer==1) { System.out.println("당신이 이겼다"); }else {
			 * System.out.println("비겼다"); } }
			 */
		}//if - you!=3
	}
}









