package com.tj.ex2_thread;

public class TargetExMain {
	public static void main(String[] args) {
		Thread threadA = new TargetEx01(); // 쓰레드 생성과 동시에 run()이 이미 정의됨
		threadA.setName("A");
		Thread threadB = new TargetEx02(); // 쓰레드 생성과 동시에 run()이 이미 정의됨
		threadB.setName("B");
		threadA.start();
		threadB.start();
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"쓰레드");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
}
