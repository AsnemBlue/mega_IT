package com.tj.loop;

public class Ex06for {
	public static void main(String[] args) {
		for(int i=0 ; true ; i++) {
			System.out.println("Hello, java");
			if(i==10) {
				break;
			}
		}
		System.out.println("DONE");
	}
}
