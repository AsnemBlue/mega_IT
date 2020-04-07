package com.tj.ex11_book;

public class BookTestMain {
	public static void main(String[] args) {
		Book b = new Book("a01","java","ȫ�浿");
		ILendable iLendable = new ILendable() {
			@Override
			public void printState() {
				System.out.println("test");
			}			
			@Override
			public void checkOut(String borrower, String checkOutDate) {
				System.out.println("test");
			}
			@Override
			public void checkIn() {
				System.out.println("test");
			}
		};
	}
}
