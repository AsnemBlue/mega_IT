package com.tj.ex8_atm;
public class ATM_ACTION implements Runnable {
	private boolean flag;
	private ATM obj;
	public ATM_ACTION(ATM obj) {
		flag = false;
		this.obj = obj;
	}
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			if(flag) {
				obj.deposit(10000, Thread.currentThread().getName());
				flag = false;
			}else {
				obj.withdraw(10000, Thread.currentThread().getName());
				flag = true;
			}//if
		}//for
	}//run
}//class
