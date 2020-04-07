package com.tj.ex4_lunch;

import com.tj.cons.PriceTable;

public class MainClass {
	public static void main(String[] args) {
		LunchMenu child1 = new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP,
							PriceTable.MILK, PriceTable.BANANA, PriceTable.ALMOND);
		LunchMenu child2 = new Child2(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP,
							PriceTable.MILK, PriceTable.BANANA, PriceTable.ALMOND);
		System.out.println(child1.getStr()+child1.calculate());
		System.out.println(child2.getStr()+child2.calculate());
	}
}
