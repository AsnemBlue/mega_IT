package com.tj.ex4_objectNThreadN;
//ThreadEx02 extends Thread
public class ThreadEx02testMain {
	public static void main(String[] args) {
		ThreadEx02 threadA = new ThreadEx02();
		threadA.setName("A");
		ThreadEx02 threadB = new ThreadEx02();
		threadB.setName("B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) { }
		System.out.println("main함수 종료 전 : A의 num = "+threadA.getNum());
		System.out.println("main함수 종료 전 : B의 num = "+threadB.getNum());
	}
}
