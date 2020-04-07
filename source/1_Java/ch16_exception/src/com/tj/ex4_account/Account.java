package com.tj.ex4_account;
public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public void deposit(int amount) { // 예금전계좌정보출력 -> 예금 -> 예금후계좌정보출력
		// Account a = new Account("110-100","홍");
		// a.deposit(1000) a->this
		System.out.println("예금전 "+this);
		balance += amount;
		System.out.println("예금후 "+this);
	}
	public void withdraw(int amount) throws Exception {
		// 잔액과 출금금액비교 -> 출금전계좌정보출력 -> 출금 -> 출금후계좌정보출력
		if(balance<amount) {
			throw new Exception(amount+"출금하기에는 잔액("+balance+")가 부족합니다");
		}
		System.out.println("출금전 "+this);
		balance -= amount;
		System.out.println("출금후 "+this);
	}
	@Override
	public String toString() {
		String temp = "계좌번호 : "+accountNo;
		temp += "\t예금주 : "+ownerName;
		temp += "\t 잔액 : "+balance;
		return temp;
	}
}















