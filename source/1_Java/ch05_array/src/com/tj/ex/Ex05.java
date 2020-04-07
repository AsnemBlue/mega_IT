package com.tj.ex;

public class Ex05 {
	public static void main(String[] args) {
		int[] arr = {76,45,89,36};
		for(int i=0 ; i<arr.length ; i++) {
			for(int j = i+1 ; j<arr.length ; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}//if
			}//for
		}//for - 정렬완료
		for(int idx=0 ; idx<arr.length ;idx++) {
			System.out.println(arr[idx]);
		} // 출력
	}// main
}//class
