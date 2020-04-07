package com.tj.ex8_atm;

public class ATMtestMain {
	public static void main(String[] args) {
		ATM obj = new ATM(20000);
		Runnable card = new ATM_ACTION(obj);
		Thread th1 = new Thread(card, "MOM");
		Thread th2 = new Thread(card, "DAD");
		th1.start();
		th2.start();
	}
}
