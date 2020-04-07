package com.tj.ex7_timer;
import java.util.Timer;
import java.util.TimerTask;
public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // Timer(true) : 프로그램 종료시 timer 메모리 상주하지 X
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); // task1을 2000밀리세컨 뒤에 한번 실행
		timer.schedule(task2, 1000, 500); // task2를 1000밀리세컨 이후부터 500밀리세컨마다 실행
		Thread.sleep(11000);
		System.out.println("끝");
	}
}
