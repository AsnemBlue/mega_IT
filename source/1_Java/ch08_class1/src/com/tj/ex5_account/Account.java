package com.tj.ex5_account;
// 계좌번호, 예금주, 잔액 / deposit(int), withdraw(int), getBalance()
public class Account {
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private int balance;      // 잔액
	public Account() {System.out.println("계좌개설 감사");}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName+"님 계좌개설 감사");
	}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"계좌개설 감사 돈까지 넣었어");
	}
	public void deposit(int money) {
		balance += money;
		System.out.println("감사합니다. "+ownerName+"님 "+money+"원 예금 후 잔액 : "+balance);
	}
	public int withdraw(int money) {
		if(balance >= money) {
			balance -= money;
			System.out.println(ownerName+"님 "+money+"원 인출 후 잔액 : "+balance);
			return money;
		}else {
			System.out.println("잔액이 부족하여 인출 실패");
			return 0;
		}
	}
	public int getBalance() {
		return balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
}











