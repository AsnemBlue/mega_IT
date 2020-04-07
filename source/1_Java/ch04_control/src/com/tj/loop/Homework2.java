package com.tj.loop;
// (1)+(1+2)+(1+2+3)+(1+2+3+4)=xxx
public class Homework2 {
	public static void main(String[] args) {
		int totalsum = 0;
		for(int i=1; i<=4 ; i++) {
			System.out.print("(");
			for(int j=1 ; j<=i ; j++) {
				totalsum += j;
				if(j==i)
					System.out.print(j);
				else
					System.out.print(j+"+");
			}
			if(i==4)
				System.out.print(")");
			else
				System.out.print(")+");
		}
		System.out.println("="+totalsum);
	}
}
