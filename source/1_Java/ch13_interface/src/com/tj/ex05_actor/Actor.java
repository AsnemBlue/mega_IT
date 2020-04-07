package com.tj.ex05_actor;

public class Actor implements PoliceMan, FireFighter, Chef{
	private String name;
	public Actor(String name) {
		this.name = name;
	}
	@Override
	public void makePizza() {
		System.out.println("피자를 만들 수 있다");
	}
	@Override
	public void makeSpaghetti() {
		System.out.println("스파게티를 만들 수 있다");
	}
	@Override
	public void outFire() {
		System.out.println("불을 끌 수 있다");
	}
	@Override
	public void saveMan() {
		System.out.println("사람을 구할 수 있다");
	}
	@Override
	public void canCatchCriminal() {
		System.out.println("범인을 잡는다");
	}
	@Override
	public void canSearch() {
		System.out.println("물건을 찾는다");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
