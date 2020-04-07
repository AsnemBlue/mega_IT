package com.tj.ex1_runnable;
// "반갑습니다" 10번 하는 target정의
public class TargetEx02 implements Runnable{
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("반갑습니다");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
