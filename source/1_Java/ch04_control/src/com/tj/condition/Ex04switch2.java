package com.tj.condition;
import java.util.Scanner;
//점수입력받아 학점 출력(switch문)
public class Ex04switch2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수는 ?");
		int score = scanner.nextInt();
		int temp = score==100 ? score-1 : score; // score가 100점이면 temp가 99
		switch(temp/10) {
		case 9: System.out.println("A학점"); break;
		case 8: System.out.println("B학점"); break;
		case 7: System.out.println("C학점"); break;
		case 6: System.out.println("D학점"); break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F학점");break;
		default:
			System.out.println("유효하지 않는 점수입니다");
		}
		scanner.close();
	}
}
