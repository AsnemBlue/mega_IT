package com.tj.ex12_book;
import java.util.Scanner;
public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890-01", "java", "신용권"),
				new BookLib("890-02", "dbms", "박용권"),
				new BookLib("890-03", "html", "김용권"),
				new BookLib("890-04", "css", "이용권"),
				new BookLib("890-05", "jsp", "윤용권")	};
		Scanner sc = new Scanner(System.in);
		String bTitle;
		int idx; // 대출이나 반납을 처리할 책의 index
		String borrower, checkOutDate;
		int fn; // 기능번호
		for(BookLib book : books) {
			book.printState();
		}
		do {
			System.out.print("1.책대출, 2.책반납, 0:종료");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				//대출처리 1.책이름입력 2.책검색 3.책상태확인 4.대출자입력 5.대출일입력 6.대출처리 
				System.out.print("대출하고자 하는 책이름은?");            // (1)단계. 책이름입력
				bTitle = sc.next(); // white-space앞까지의 스트링 받음.
				for(idx=0 ; idx<books.length ; idx++) {                  // (2)단계. 책검색
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;//찾았다. 이거 대출하면 되겠다
					}
				}
				// idx<books.length경우는 찾았다. idx==books.length경우는 못찾았다
				if(idx==books.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");
				}else {
					if(books[idx].getState() == ILendable.STATE_BORROWED) {// (3) 단계. 책상태확인
						System.out.println("현재 대출중인 도서입니다.");
					}else {
						System.out.print("대출자는?");// (4)단계. 대출자입력
						borrower = sc.next();
						System.out.print("대출일은 ?");// (5)단계. 대출일입력 
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);// (6)대출처리
					}
				}
				break;
			case 2:
				//반납처리 1.책이름 2.책검색 3.반납처리
				System.out.print("반납할 책이름은?"); //(1)단계. 책이름
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) { // (2)단계. 책검색
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //찾아서 나가
					}
				}
				if(idx==books.length) {
					System.out.println("이도서는 본도서관 보유책이 아닙니다.");
				}else {
					books[idx].checkIn(); // (3)단계. 반납처리
				}
				break;
			case 0:
				break;
			default:
				System.out.println("유효하지 않는 기능번호입니다.");
			}
		}while(fn!=0);
		for(BookLib book : books) {
			book.printState();
		}
		System.out.println("안녕히 가세요");
		sc.close();
	}
}















