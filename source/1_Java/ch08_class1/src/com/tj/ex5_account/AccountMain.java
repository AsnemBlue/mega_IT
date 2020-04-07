package com.tj.ex5_account;

public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("111-111","홍길동",20000);
		Account hong1 = new Account("111-112", "김길동");
		Account hong2 = new Account();
		hong2.setAccountNo("111-113");
		hong2.setOwnerName("신길동");
		hong.deposit(10000);
		hong1.deposit(10000);
		hong2.deposit(10000);
		int result = hong.withdraw(40000);
		if(result==0) {
			System.out.println("인출실패");
		}
		result = hong2.withdraw(5000);
		if(result==0) {
			System.out.println("인출실패");
		}
	}
}
