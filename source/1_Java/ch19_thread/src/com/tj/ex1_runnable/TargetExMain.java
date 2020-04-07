package com.tj.ex1_runnable;

public class TargetExMain {
	public static void main(String[] args) {
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02();
		Thread threadA = new Thread(target1, "A"); // target1의 run()작업을 하는 "A" 쓰레드 생성
		Thread threadB = new Thread(target2, "B"); // target2의 run()작업을 하는 "B" 쓰레드 생성
		threadA.start(); // 쓰레드 실행 시작
		threadB.start(); // 쓰레드 실행 시작
		for(int i=0 ; i<10 ; i++) {
			System.out.println("나는 main 쓰레드");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
