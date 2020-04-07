package com.tj.ex12_book.cd;
import java.util.Scanner;
public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("a01", "java", "신용권"), 
							new BookLib("a02", "dbms", "아무개"),
							new BookLib("a03", "html", "홍길동"), 
							new BookLib("a04", "css", "김길동"),
							new BookLib("a05", "jsp", "박길동") };
		CDLib[] cds = { new CDLib("c01", "java_cd", "a01"), 
						new CDLib("c02", "ITtrend", null), 
						new CDLib("c03", "jsp", "a02") };
		Scanner sc = new Scanner(System.in);
		String title;
		int idx; // 대출이나 반납을 처리할 책의 index
		String borrower, checkOutDate;
		int fn; // 기능번호
		for(BookLib book : books) {
			book.printState();
		}
		for(CDLib cd : cds) {
			cd.printState();
		}
		do {
			System.out.print("1:책대출 | 2:CD대출 | 3:책반납 | 4:CD반납 | 0:종료 ?");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				//책대출처리 1.책이름입력 2.책검색 3.책상태확인 4.대출자입력 5.대출일입력 6.대출처리 
				System.out.print("대출하고자 하는 책이름은?");            // (1)단계. 책이름입력
				title = sc.next(); // white-space앞까지의 스트링 받음.
				for(idx=0 ; idx<books.length ; idx++) {                  // (2)단계. 책검색
					if(books[idx].getBookTitle().equals(title)) {
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
				//cd대출처리 1.cd이름입력 2.cd검색 3.cd상태확인 4.대출자입력 5.대출일입력 6.대출처리 
				System.out.print("대출하고자 하는 cd이름은?");            // (1)단계. cd이름입력
				title = sc.next(); // white-space앞까지의 스트링 받음.
				for(idx=0 ; idx<cds.length ; idx++) {                  // (2)단계. cd검색
					if(cds[idx].getCdTitle().equals(title)) {
						break;//찾았다. 이거 대출하면 되겠다
					}
				}
				// idx<cds.length경우는 찾았다. idx==cds.length경우는 못찾았다
				if(idx==cds.length) {
					System.out.println("현재 보유하지 않은 cd입니다.");
				}else {
					if(cds[idx].getState() == ILendable.STATE_BORROWED) {// (3) 단계. 책상태확인
						System.out.println("현재 대출중인 cd입니다.");
					}else {
						System.out.print("대출자는?");// (4)단계. 대출자입력
						borrower = sc.next();
						System.out.print("대출일은 ?");// (5)단계. 대출일입력 
						checkOutDate = sc.next();
						cds[idx].checkOut(borrower, checkOutDate);// (6)대출처리
					}
				}
				break;
			case 3:
				//책반납처리 1.책이름 2.책검색 3.반납처리
				System.out.print("반납할 책이름은?"); //(1)단계. 책이름
				title = sc.next();
				for(idx=0 ; idx<books.length ; idx++) { // (2)단계. 책검색
					if(books[idx].getBookTitle().equals(title)) {
						break; //찾아서 나가
					}
				}
				if(idx==books.length) {
					System.out.println("이도서는 본도서관 보유책이 아닙니다.");
				}else {
					books[idx].checkIn(); // (3)단계. 반납처리
				}
				break;
			case 4:
				//cd반납처리 1.cd이름 2.cd검색 3.반납처리
				System.out.print("반납할 cd이름은?"); //(1)단계. cd이름
				title = sc.next();
				for(idx=0 ; idx<cds.length ; idx++) { // (2)단계. cd검색
					if(cds[idx].getCdTitle().equals(title)) {
						break; //찾아서 나가
					}
				}
				if(idx==cds.length) {
					System.out.println("이도서는 본도서관 보유책이 아닙니다.");
				}else {
					cds[idx].checkIn(); // (3)단계. 반납처리
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
		for(CDLib cd : cds) {
			cd.printState();
		}
		System.out.println("안녕히 가세요");
		sc.close();
	}
}















