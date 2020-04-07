package com.tj.ex4_objectNThreadN;
// ThreadEx01 implements Runnable
public class ThreadEx01testMain {
	public static void main(String[] args) {
		Runnable target01 = new ThreadEx01();
		Runnable target02 = new ThreadEx01();
		Thread threadA = new Thread(target01, "A");
		Thread threadB = new Thread(target02, "B");
		threadA.start();
		threadB.start();
		System.out.println("main ÇÔ¼ö");
	}
}
