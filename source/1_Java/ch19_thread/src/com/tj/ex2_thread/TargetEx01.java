package com.tj.ex2_thread;
// "안녕하세요 10번"하는 target정의
public class TargetEx01 extends Thread{
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("안녕하세요");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
}
