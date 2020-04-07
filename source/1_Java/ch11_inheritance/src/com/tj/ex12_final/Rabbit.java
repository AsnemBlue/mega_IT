package com.tj.ex12_final;

public final class Rabbit extends Animal {
	@Override
	public void running() {
		speed += 30;
		System.out.println("마구 마구 뛰어요. 현재속도 : "+speed);
	}
}
