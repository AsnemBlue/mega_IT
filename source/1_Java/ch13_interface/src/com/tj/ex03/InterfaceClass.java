package com.tj.ex03;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2{

	@Override
	public String getStr() {
		System.out.println("getStr-실제 구현은 implements한 클래스에서만 가능");
		return null;
	}

	@Override
	public void calculate() {
		System.out.println("calculate-실제 구현은 implements한 클래스에서만 가능");
		
	}

}
