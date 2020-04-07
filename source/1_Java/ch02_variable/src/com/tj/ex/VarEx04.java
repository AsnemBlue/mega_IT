package com.tj.ex;
public class VarEx04 {
	public static void main(String[] args) {
		//변수선언방법들
		// 1. 자료형 변수명; - 변수선언과 할당을 분리
		int num1;
		num1 = 10;
		// 2. 자료형 변수명 = 초기값; - 변수선언과 동시에 초기화
		int num2 = 20;
		// 3. 자료형 변수명1, 변수명2, ..., 변수명n; - 동일자료형의 변수를 다수 선언
		int num3, num4;
		// 4. 자료형 변수명1=값1, 변수명2=값2, ... 변수명n=값n; - 동일자료형의 변수 다수를 선언과 초기화
		int num5=50, num6=60, num7;
		num3=30; num4=40; num7=70;
		System.out.println("num1="+num1+"\tnum2="+num2);
		System.out.print("num3="+num3+"\tnum4="+num4);
		System.out.printf("num5=%d\tnum6=%d\tnum7=%d\n", num5, num6, num7);
	}
}
