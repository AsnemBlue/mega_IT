package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class MainClass {
	public static void main(String[] args) {
		Customer customer = new Customer("홍길동", "9999-9999", "서울시 종로구", "12-04");
		customer.buy(10000);
		System.out.println(customer.infoString());
		Staff staff = new Staff("홍일꾼", "8888-8888", "2019-11-01", "전산실");
		Person[] person = {customer, staff};
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		Person customer1 = new Staff("홍", "99", "19-12-1", "전산실"); 
				//new Customer("김길순","7777-7777", "서울시 마포구","11-04");
		System.out.println(customer1.infoString());
		if(customer1 instanceof Customer) {
			((Customer)customer1).buy(10000);
		}
	}//main
}





















