package com.tj.ex15_accountinheritance;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine; // 카드한도
	public CreditLineAccount() {	}
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine=creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine=creditLine;
	}
	public int pay (String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) {
			if(creditLine< amount) {
				System.out.println(getOwnerName()+"님, 한도초과. 사용불가합니다");
				return 0;
			} else {
				creditLine -= amount;
				System.out.println(getOwnerName()+"님, "+ amount +"원 사용(잔여 한도:"+creditLine+"원)");
				return amount;
			}
		} else {
			System.out.println("카드번호가 일치하지않습니다");
			return 0;
		}
	}
	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("카드 한도액 :" +creditLine);
	}
	public long getCreditLine() {return creditLine;}
}
