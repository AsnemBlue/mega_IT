package com.tj.condition;
import java.util.Scanner;
//사용자로부터 국어, 영어, 수학 점수를 입력받아 각 과목별 점수가 평균 이상인지 미만인지 출력해 보자
public class Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 ?");
		int kor = scanner.nextInt();
		System.out.print("영어 ?");
		int eng = scanner.nextInt();
		System.out.print("수학 ?");
		int mat = scanner.nextInt();
		double avg = (kor+eng+mat) / 3.0;
		if(kor>=avg) {
			System.out.printf("국어는 평균(%.2f)이상", avg);
		}else {
			System.out.printf("국어는 평균(%.2f)미만", avg);
		}//if-kor
		if(eng>=avg) {
			System.out.println("영어는 평균이상");
		}else {
			System.out.println("영어는 평균미만");
		}//if - eng
		if(mat>=avg) {
			System.out.println("수학은 평균이상");
		}else {
			System.out.println("수학은 평균미만");
		}//if-mat
		scanner.close();
	}//main
}//class
