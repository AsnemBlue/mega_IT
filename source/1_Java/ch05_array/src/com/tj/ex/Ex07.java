package com.tj.ex;
// 일반for vs. 확장for
public class Ex07 {
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		// 일반 for문
		for(int idx = 0 ; idx < arr.length ; idx++) {
			System.out.println(arr[idx]);
		}
		// 확장 for 문
		for(int a : arr) {
			System.out.println(a);
		}
	}
}
