package com.tj.ex4_lunch;

public abstract class LunchMenu {
	private String str;
	private int rice;    // 밥 값
	private int bulgogi; //불고기값
	private int soup;    // 국 값
	private int milk;   // 우유값
	private int banana; // 바나나값
	private int almond; // 아몬드
	// Child c = new Child(PriceTable.RICE,500,100,750,600,100);
	public LunchMenu(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.milk = milk;
		this.banana = banana;
		this.almond = almond;
	}
	public abstract int calculate();
	public String getStr() {return str;}
	public void setStr(String str) {this.str = str;}
	public int getRice() {
		return rice;
	}
	public int getBulgogi() {
		return bulgogi;
	}
	public int getSoup() {
		return soup;
	}
	public int getMilk() {
		return milk;
	}
	public int getBanana() {
		return banana;
	}
	public int getAlmond() {
		return almond;
	}
}

















