package com.tj.ex08_toy;

public class AirPlaneToy implements IMissile, ILight{
	public AirPlaneToy() {
		System.out.println("비행기입니다");
		canLight();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canLight() {
		System.out.println("불빛반사할 수 있다");
	}
	@Override
	public void canMissile() {
		System.out.println("미사일 쏠 수 있다");
	}
}
