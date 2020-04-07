package com.tj.ex04_acor;
// DMB송수신가능, LTE, TV리모콘 탑재
public class BModel implements IAcor {
	private String model = "B모델";
	@Override
	public void dmbReceive() {
		System.out.println(model+"은 DMB송수신가능");
	}
	@Override
	public void lte() {
		System.out.println(model+"은 LTE");
	}
	@Override
	public void tvRemoteControl() {
		System.out.println(model+"은 TV리모콘 탑재");
	}
}
