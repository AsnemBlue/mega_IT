package com.tj.ex1_string;

public class Ex11_speedcheck {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());// 1970.01.01.0시부터 현재의 밀리세컨
		String str = "A";
		long startTime = System.currentTimeMillis(); // 시작시점의 1970.1.1부터 이때까지의 밀리세켠
		for(int i=0 ; i<50000 ; i++) {
			str = str + "a";
		}
		long endTime = System.currentTimeMillis(); // 끝나는 시점
		System.out.println("String 5만번 수정 경과 시간 : "+(endTime-startTime));
		
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis(); // 시작시점
		for(int i=0 ; i<50000 ; i++) {
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();// 끝나는 시점
		System.out.println("StringBuffer 5만번 수정 경과시간 : "+(endTime-startTime));
		
		StringBuilder strBui = new StringBuilder("A");
		startTime = System.currentTimeMillis(); // 시작시점
		for(int i=0 ; i<50000 ; i++) {
			strBui.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 5만번 수정 경과시간 : "+(endTime-startTime));
	}
}













