package com.tj.ex;
import java.util.Scanner;
public class Ex04 {
	public static void main(String[] args) {
		String[] name = {"영희","철수","길동","영수","말자"};
		int[] height = new int[5];
		Scanner scanner = new Scanner(System.in);
		for(int idx=0 ; idx<name.length ; idx++) {
			System.out.print(name[idx]+"의 키는 ?");
			height[idx] = scanner.nextInt();
		}
		int min = 9999;//최소키
		int max = 0; // 최대키
		int tot = 0; // 키 누적
		int minIndex=-1, maxIndex=-1;
		for(int idx=0; idx<name.length ; idx++) {
			tot += height[idx]; // 키 누적
			if(height[idx]<min) {
				min = height[idx]; // 최소값이 min이 아니면 min으로 수정
				minIndex = idx;
			}//if - 최소값처리
			if(height[idx]>max) {
				max = height[idx];
				maxIndex = idx;
			}
		}
		System.out.println("최장신키 : "+max+"("+name[maxIndex]+")"); // 최장신키 : 190 (철수)
		System.out.println("최단신키 : "+min+"("+name[minIndex]+")"); // 최단신키 : 150 (영수)
		System.out.printf("평균키 : %.2f\n", (double)tot/name.length);
	}
}







