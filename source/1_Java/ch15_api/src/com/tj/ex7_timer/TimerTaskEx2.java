package com.tj.ex7_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {

	@Override
	public void run() {
		System.out.println("★ ★ ★ TimerTaskEx2 작업 실행 중 ★ ★ ★(1초후 0.5초마다 실행 예정)");
	}

}
