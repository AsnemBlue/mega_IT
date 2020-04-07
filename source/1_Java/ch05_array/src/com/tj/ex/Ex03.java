package com.tj.ex;

public class Ex03 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length];
//		for(int idx=0 ; idx<s.length ; idx++) {
//			s[idx] = score[idx];
//		}
		System.arraycopy(score, 0, s, 0, score.length);
		for(int idx=0 ; idx<s.length ; idx++) {
			System.out.println("score["+idx+"]="+score[idx]+"\ts["+idx+"]="+s[idx]);
		}
		score[0] = 9999;
		System.out.println("º¯°æÈÄ");
		for(int idx=0 ; idx<s.length ; idx++) {
			System.out.println("score["+idx+"]="+score[idx]+"\ts["+idx+"]="+s[idx]);
		}
	}
}
