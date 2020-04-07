package com.tj.ex5;
public class Ex01 {
	public static void main(String[] args) {
		Thread1 target1 = new Thread1();
		Thread th1 = new Thread(target1);
		th1.start();
		for(int i=0 ; i<300 ; i++) {
			System.out.print('¡Ú');
		}
	}
}
