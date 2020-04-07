package com.tj.car;

public class Car {
	private String color;
	private int cc;
	private String brand;
	private int speed;
	public void drive() {
		speed = 60;
		System.out.println("운전한다 지금 속도는 "+speed);
	}
	public void park() {
		speed = 0;
		System.out.println("주차한다. 지금 속도 "+speed);
	}
	public void race() {
		speed = 120;
		System.out.println("레이싱한다. 지금 속도 "+speed);
	}
	public void setColor(String c) {
		color = c;
	}
	public String getColor() {
		return color;
	}
	
}










