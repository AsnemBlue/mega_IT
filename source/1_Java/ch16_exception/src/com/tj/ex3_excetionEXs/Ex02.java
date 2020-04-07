package com.tj.ex3_excetionEXs;
public class Ex02 {
	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(str.indexOf('z'));
		str = null;
		System.out.println(str.indexOf('z'));
	}
}
