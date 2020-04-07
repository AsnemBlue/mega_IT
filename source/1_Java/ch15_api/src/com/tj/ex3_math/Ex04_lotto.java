package com.tj.ex3_math;
import java.util.Random;
public class Ex04_lotto {
	public static void main(String[] args) {
		byte[] lotto = new byte[6];
		Random random = new Random();
		int j=0;
		for(int i=0 ; i<lotto.length ; i++) {  // 43 5 38 12 10 1
			byte temp = (byte)(random.nextInt(45)+1);
			for(j = 0 ; j<i ; j++) { // 중복확인
				if(lotto[j]==temp) {
					i--;
					//break;
				}//if
			}//for - j
			if(i==j) {
				lotto[i] = temp;
			}
		}//for - i
	}//main
}//class
