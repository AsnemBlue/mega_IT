package com.tj.ex15_accountinheritance;

public class CheckingAccount extends Account {
	private String cardNo;  // 카드번호
	public CheckingAccount(){ }
	public CheckingAccount(String accountNo,String ownerName, String cardNo){ 
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo,String ownerName,int balance,String cardNo){ 
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public int pay(String cardNo, int amount){
		if(this.cardNo.equals(cardNo)){
			if(getBalance()<amount){
				System.out.println("★★★잔액이 부족합니다★★★");
				return 0;
			}else{
				setBalance(getBalance()-amount);
				System.out.println(amount+"사용되서 현재 잔액 : "+getBalance());
				return amount;
			}
		}else{
			System.out.println("카드번호가 일치하지않습니다");
			return 0;
		}
	}
	public String getCardNo() {return cardNo;}
	public void setCardNo(String cardNo) {this.cardNo = cardNo;}
}
