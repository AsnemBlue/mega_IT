package com.tj.ex2_thread;
// ThreadEx threadA = new ThreadEx();
// threaA.setName("A")
// => ThreadEx threadA = new ThreadEx("A");
public class ThreadEx extends Thread{
	public ThreadEx() {}
	public ThreadEx(String name) {
		super(name); // 쓰레드 이름을 명명
	}//생성자
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("ThreadEx");
		for(int i = 0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"쓰레드의 i = "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}// for
	}
}//class
