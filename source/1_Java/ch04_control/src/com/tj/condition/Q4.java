package com.tj.condition;
import java.util.Scanner;
//가위바위보 중 하나를 내고 낸 것을 출력하세요(단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 보를 선택하고자 할 때는 2를 입력)
public class Q4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2) 중 하나를 선택하세요 : ");
		int you = scanner.nextInt(); // 0,1,2
		if(you==0) {
			System.out.println("당신은 가위");
		}else if(you ==1) {
			System.out.println("당신은 바위");
		}else if(you ==2 ){
			System.out.println("당신은 보자기");
		}else {
			System.out.println("유효하지 않는 값입니다");
		}
		scanner.close();
	}
}
