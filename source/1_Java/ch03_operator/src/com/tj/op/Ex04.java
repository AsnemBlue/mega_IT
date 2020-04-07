package com.tj.op;
//논리연산자 (AND, OR => &&, ||)
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("&&(AND) (i>j) && (++j>h) : "+((i>j) && (++j>h)));
		//                                                  F   &&  T
		System.out.println(j); // &&연산자의 좌항이 false일 경우 우항 실행 안 함
		System.out.println("||(OR) (i>j) || (++j>h) : "+((i<j) || (++j>h)));
		//                                                 T   ||  T
		System.out.println(j); // ||연산자의 좌항이 true일 경우 우항 실행 안 함
	}
}
