package com.tj.ex5_car;

public class HighGradeCar extends Car {
	private int tax = 500000;
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	}
	@Override
	public void getSpec() {
		if(getDisplacement()>=2000) {
			tax += 1000000;
		}
		System.out.println(" 색  상 : "+getColor());
		System.out.println(" 타이어 : "+getTire());
		System.out.println(" 배기량 : "+getDisplacement());
		System.out.println(" 핸  들 : "+getHandle());
		System.out.println(" 세  금 : "+tax);
	}

}
