package com.tj.ex6_wrapper;
// java 클래스명 100 20 10 ; 명령파라미터로 들어온 문자열의 숫자를 합
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("들어온 값 갯수 : "+ args.length);
		//"10" "20" "1" "2" "3" "5"
		int total = 0;
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.println(args[idx]);
			total += Integer.parseInt(args[idx]);
		}
		System.out.println("total = "+total);
	}
}
