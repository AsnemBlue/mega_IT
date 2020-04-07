package com.tj.ex;

public class VarEx07 {
	public static void main(String[] args) {
		byte b = 10;
		double d = 10; // d=10.0 묵시적인 형변환
		double d2 = 10.91; 
		int i = (int)d2; // 명시적인 형변환 - 데이터 손실이 생길 수 있다.
	}
}
