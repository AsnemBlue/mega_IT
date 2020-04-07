package com.tj.ex;
//오늘의문제2.int[][] arr = { {   5,  5,   5,   5,   5}, {10, 10, 10, 10, 10}, {20, 20, 20, 20, 20}, {30, 30, 30, 30, 30}};
public class Ex09 {
	public static void main(String[] args) {
		int[][] arr = { {5,5,5,5,5},
						{10,10,10,10,10},
						{20,20,20,20,20},
						{30,30,30,30,30}};
		int tot = 0;
		for(int i=0 ; i<arr.length ; i++) {
			for(int j =0 ; j<arr[i].length ; j++) {
				tot += arr[i][j];
			}//for			
		}//for
		System.out.println("누적합 "+ tot);
	}
}
