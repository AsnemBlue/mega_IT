package com.tj.loop;
// break vs. continue 
public class Ex05for {
	public static void main(String[] args) {
		for(int i=1 ; i<=10 ; i++) {
			if(i==3) 
				//break;
				continue;
			System.out.println(i);
		}
	}
}
