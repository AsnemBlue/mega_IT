package com.tj.ex3_math;
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 내림");
		// 9.12 -> 9 10.0 9.0
		System.out.println("9.12를 반올림 : "+Math.round(9.12)); // 9 (long)
		System.out.println("9.12를 올림 : "+Math.ceil(9.12));    // 10.0 (double)
		System.out.println("9.12를 내림 : "+Math.floor(9.12));   // 9.0 (double)
		System.out.println("소수점 한자리에서 반올림, 올림, 내림");
		// 9.56 -> 9.6 9.6 9.5
		System.out.println("9.56을 소수점 한자리에서 반올림 : "+Math.round(9.56*10)/10.0); // 9.6
		System.out.println("9.56을 소수점 한자리에서 올림 : "+Math.ceil(9.56*10)/10);  //9.6
		System.out.println("9.56을 소수점 한자리에서 내림 : "+Math.floor(9.56*10)/10); // 9.5
		System.out.println("십의 자리에서 반올림, 올림, 내림");
		// 19 -> 20 20 10
		System.out.println("19를 일의 자리에서 반올림 : "+Math.round(19/10.0)*10); // 20
		System.out.println("19를 일의 자리에서 올림 : "+Math.ceil(19/10.0)*10);    // 20
		System.out.println("19를 일의 자리에서 내림 : "+Math.floor(19/10.0)*10 );  // 10
	}
}












