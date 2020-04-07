package com.tj.loop;
// 2~9단까지 출력
public class Q4for {
	public static void main(String[] args) {
		for(int i=1 ; i<10 ; i++) {
			for(int j=2 ; j<10 ; j++) {
				System.out.printf("%d * %d = %d\t", j, i, j*i);
			}
			System.out.println();//개행
		}
			
	}
}
