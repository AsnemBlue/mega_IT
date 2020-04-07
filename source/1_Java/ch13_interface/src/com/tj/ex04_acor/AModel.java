package com.tj.ex04_acor;
// DMB송수신불가, 3G, TV리모콘 미탑재
public class AModel implements IAcor {
	private String model = "A모델";
	@Override
	public void dmbReceive() {
		System.out.println(model+"은 DMB송수신불가");
	}
	@Override
	public void lte() {
		System.out.println(model+"은 3G 모델");
	}
	@Override
	public void tvRemoteControl() {
		System.out.println(model+"은 TV리모콘 미탑재");
	}
}