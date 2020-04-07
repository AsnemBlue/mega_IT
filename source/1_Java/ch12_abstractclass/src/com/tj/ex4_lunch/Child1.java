package com.tj.ex4_lunch;

public class Child1 extends LunchMenu{
	public Child1(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		super(rice, bulgogi, soup, milk, banana, almond);
		setStr("Child1형 식대 : ");
	}
	@Override
	public int calculate() {
		// 밥+불고기+국+바나나+아몬드
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
