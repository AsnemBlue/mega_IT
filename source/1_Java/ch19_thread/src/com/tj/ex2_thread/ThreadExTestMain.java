package com.tj.ex2_thread;

public class ThreadExTestMain {
	public static void main(String[] args) {
		ThreadEx threadA = new ThreadEx("A");
		ThreadEx threadB = new ThreadEx();
		threadB.setName("B");
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main ÇÔ¼ö ³¡");
	}
}
