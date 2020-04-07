package com.tj.method;
// sum(10, 100), evenOdd(50), abs(-5)
public class Arithmetic {
	public int sum(int from, int to) {
		int result = 0;
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {
		String result = value%2==0 ? "Â¦¼ö":"È¦¼ö";
		return result;
	}
	public static int abs(int value) {
		int result = value<0 ? -value : value;
		return result;
	}
}










