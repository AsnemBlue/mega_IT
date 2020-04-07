package com.tj.ex12_book.cd;

public class BookMain_test {
	public static void main(String[] args) {
		BookLib testBook = new BookLib("890-01", "java", "½Å¿ë±Ç");// BookLib test
		testBook.checkOut("kim", "12-06");
		testBook.printState();
		testBook.checkOut("kim", "12-06");
		testBook.checkIn();
		testBook.printState();
		testBook.checkIn();
		CDLib testCD = new CDLib("001-01", "javacd", "890-01");
		testCD.checkOut("kim", "12-12");
		testCD.printState();
		testCD.checkOut("kim", "12-12");
		testCD.checkIn();
		testCD.checkIn();
	}
}
