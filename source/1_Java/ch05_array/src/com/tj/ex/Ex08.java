package com.tj.ex;
// 일반for vs. 확장for ; 배열 모든 방의 값을 10%인상
public class Ex08 {
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		for(int idx=0 ; idx<arr.length ; idx++) {
			arr[idx] = (int) (arr[idx]*1.1);
		}
		arrayPrint(arr); // arr 배열 출력해
		for(int a : arr) {
			a *= 2;
		}
		arrayPrint(arr);
	}
	private static void arrayPrint(int[] array) {
		for(int idx=0 ; idx<array.length ;idx++) {
			System.out.println(array[idx]);
		}
	}
}
