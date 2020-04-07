package com.tj.ex15_accountinheritance;

public class MainClass {
	public static void main(String[] args) {
		Account a1 = new Account("111-1111", "홍길동");
		CheckingAccount a2 = new CheckingAccount("222-2222", "김길동", 
												2000, "1234-1234-1234-1234");
		CheckingAccount a3 = new CreditLineAccount("333-3333", "성춘향", 2000, 
												"1234-1234-1234-1234", 2000);
		a1.deposit(3000);
		a2.withdraw(200);
		a3.deposit(3000);
		a1.printAccount();
		a2.pay("1234-1234-1234-1234", 200);
		a2.pay("1234-1234-1234-1111", 200); // 카드번호 틀림
		a3.pay("1234-1234-1234-1111", 5000);// 카드번호 틀림
		a3.pay("1234-1234-1234-1234", 5000);
	}
}
