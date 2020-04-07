package com.tj.ex12_book;

public class BookMain_test {
	public static void main(String[] args) {
		BookLib testBook = new BookLib("890-01", "java", "½Å¿ë±Ç");// BookLib test
		testBook.checkOut("kim", "12-06");
		testBook.printState();
		testBook.checkOut("kim", "12-06");
		testBook.checkIn();
		testBook.printState();
		testBook.checkIn();
	}
}
