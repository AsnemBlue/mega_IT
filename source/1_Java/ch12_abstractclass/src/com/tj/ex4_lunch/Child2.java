package com.tj.ex4_lunch;

public class Child2 extends LunchMenu{
	public Child2(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		super(rice, bulgogi, soup, milk, banana, almond);
		setStr("Child2형 식대 : ");
	}
	@Override
	public int calculate() {
		// 밥 + 불고기 + 국 + 우유
		return getRice()+getBulgogi()+getSoup()+getMilk();
	}
}
