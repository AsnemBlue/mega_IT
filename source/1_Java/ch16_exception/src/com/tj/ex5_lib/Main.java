package com.tj.ex5_lib;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
// main 함수의 format
public class Main {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890-01", "this is java", "신용권"),
				new BookLib("890-02", "dbms", "박용권")	};
		try {
			books[0].checkOut("kim");
			books[0].setCheckOutDate(new Date(new GregorianCalendar(2019, 10, 13).getTimeInMillis()));
			books[0].checkIn();
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		Scanner sc = new Scanner(System.in); int fn; int idx; String bTitle,borrower;
		do {
			System.out.print("0:전체 대출여부 상태 열람 1.대출, 2.반납, 그외:종료");
			try {
				fn = sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("0,1,2 그 외 문자를 입력하시면 종료되요");
				break;
			}
			switch(fn) {
			case 0:
				System.out.println("for문으로 전체 책정보 열람"); break;
			case 1:
				System.out.println("책이름과 대출자 받아 대출 처리"); break;
			case 2:
				System.out.println("책이름 받아 반납 처리"); break;
			}
		}while(fn==0 || fn==1 || fn==2);
	}//main
}
