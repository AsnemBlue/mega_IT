package com.tj.loop;
//i가 1~9까지 누적합 출력하기
public class Ex08while {
	public static void main(String[] args) {
		int tot = 0;
//		for(int i=1 ; i<10 ; i++) {
//			tot += i;
//			System.out.printf("i가 %d까지 누적합은 %d이다\n", i, tot);
//		}
		int i=1;
		while(i<10) {
			tot += i;
			System.out.printf("i가 %d까지 누적합은 %d이다\n", i, tot);
			i++;
		}
	}
}
