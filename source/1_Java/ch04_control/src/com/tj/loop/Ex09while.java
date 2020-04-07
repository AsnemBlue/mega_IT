package com.tj.loop;
// 1~100까지 3의 배수의 누적합 출력
public class Ex09while {
	public static void main(String[] args) {
		int tot = 0;
//		for(int i=1 ; i<=100 ; i++) {
//			if(i%3==0) {
//				tot += i;
//			}//if
//		}//for
		int i=1;
		while(i<=100) {
			if(i%3==0) {
				tot += i;
			}
			i++;
		}
		System.out.println(tot);
	}//main
}//class
