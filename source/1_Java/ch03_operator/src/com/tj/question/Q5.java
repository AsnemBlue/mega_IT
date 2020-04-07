package com.tj.question;
import java.util.Scanner;
//주민번호 7번째 자리수를 입력받아 여자인지 남자인지 출력하세요
public class Q5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호 7번째 자리는 ?");
		int no = scanner.nextInt();
		String result = (no==1 || no==3)? "남자" : 
					(no==2 || no==4) ? "여자" : "떼끼";
		System.out.println(result);
		scanner.close();
	}
}