package com.tj.ex;
// 오늘의 문제3. 76,45,34,89,100,50,90,92의 총합, 평균, 최대값, 최소값
public class Ex10 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int tot=0; //총합
		double avg; // 평균
		int max=-9999, min=9999;
		for(int a : arr) {
			tot += a; // 누적
			if(max < a) { // 최대값 처리
				max = a;
			}//if-max
			if(min > a) { // 최소값 처리
				min = a;
			}//if-min
		}//for
		avg = tot / arr.length;
		System.out.println("총합 : "+tot+", 평균 : "+avg);
		System.out.println("최소값 : "+min+", 최대값 : "+max);
	}
}
