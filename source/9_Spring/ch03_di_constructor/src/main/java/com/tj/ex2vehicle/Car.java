package com.tj.ex2vehicle;

public class Car implements Vehicle{

	@Override
	public void ride(String name) {
		System.out.println(name+"은(는) 멋진 차로 90km/h 속도로 빨리 간다");
		
	}

}
