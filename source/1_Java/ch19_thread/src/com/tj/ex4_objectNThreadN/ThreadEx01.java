package com.tj.ex4_objectNThreadN;

public class ThreadEx01 implements Runnable{
	private int num = 0; // 공유변수
	@Override
	public void run() {
		for(int i = 0 ; i <10 ; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				System.out.println("~ ~ A 쓰레드 수행 중 ~ ~");
				num++;
			}
			System.out.println(Thread.currentThread().getName()+"의 num = "+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}//for
	}// run()
}
