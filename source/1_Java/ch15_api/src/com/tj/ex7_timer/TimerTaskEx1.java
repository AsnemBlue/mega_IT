package com.tj.ex7_timer;
import java.util.TimerTask;
public class TimerTaskEx1 extends TimerTask {
	@Override
	public void run() {
		System.out.println("~ ~ TimerTaskEx1 작업 실행 중 ~ ~(2초후 1번 실행 예정)");
	}

}
